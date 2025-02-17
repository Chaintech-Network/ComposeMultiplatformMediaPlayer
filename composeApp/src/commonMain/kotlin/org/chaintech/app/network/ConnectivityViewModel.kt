package org.chaintech.app.network

import chaintech.network.connectivitymonitor.ConnectivityMonitor
import chaintech.network.connectivitymonitor.ConnectivityStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ConnectivityViewModel {

    private val _connectivityStatus = MutableStateFlow(ConnectivityStatus.DETERMINING)
    val connectivityStatus: StateFlow<ConnectivityStatus> = _connectivityStatus.asStateFlow()

    private val _connectedFromDisconnect = MutableStateFlow(false)
    val connectedFromDisconnect: StateFlow<Boolean> = _connectedFromDisconnect.asStateFlow()

    private var wasDisconnected = false // Track if we were previously offline



    private var viewModelJob: Job? = null

    init {
        startMonitoring()
    }

    private fun startMonitoring() {
        viewModelJob?.cancel() // Cancel any existing job to avoid multiple coroutines running
        viewModelJob = CoroutineScope(Dispatchers.Default).launch {
            ConnectivityMonitor.instance.status.collect { newStatus ->
                val previousStatus = _connectivityStatus.value
                _connectivityStatus.value = newStatus

                if (previousStatus == ConnectivityStatus.DETERMINING) {
                    // Ignore first transition from DETERMINING
                    wasDisconnected = false
                    return@collect
                }

                if (previousStatus in setOf(
                        ConnectivityStatus.NOT_CONNECTED,
                        ConnectivityStatus.CONNECTED_VIA_CELLULAR_WITHOUT_INTERNET,
                        ConnectivityStatus.CONNECTED_VIA_WIFI_WITHOUT_INTERNET
                    ) && newStatus in setOf(
                        ConnectivityStatus.CONNECTED,
                        ConnectivityStatus.CONNECTED_VIA_CELLULAR,
                        ConnectivityStatus.CONNECTED_VIA_WIFI
                    )
                ) {
                    // Transition from "disconnected" to "connected"
                    _connectedFromDisconnect.value = true
                    wasDisconnected = false

                    // Hide the "Connected" banner after 3 seconds
                    launch {
                        delay(3000)
                        delay(50)
                        _connectedFromDisconnect.value = false
                    }
                } else if (newStatus in setOf(
                        ConnectivityStatus.NOT_CONNECTED,
                        ConnectivityStatus.CONNECTED_VIA_CELLULAR_WITHOUT_INTERNET,
                        ConnectivityStatus.CONNECTED_VIA_WIFI_WITHOUT_INTERNET
                    )
                ) {
                    wasDisconnected = true
                }
            }
        }
    }

    fun stopMonitoring() {
        viewModelJob?.cancel()
        ConnectivityMonitor.instance.stopMonitoring()
    }

    fun refresh() {
        ConnectivityMonitor.instance.refresh()
    }
}