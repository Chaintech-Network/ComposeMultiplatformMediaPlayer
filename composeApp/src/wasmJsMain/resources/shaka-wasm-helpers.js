window.ShakaWasmHelpers = {
            setABR: function(player, enabled) {
                player.configure({ abr: { enabled: enabled } });
            },
            createEmptyObject: function() {
                return {};
            },
            setObjectProperty: function(obj, key, value) {
                obj[key] = value;
            },
            configureHeaders: function(player, headersObject) {
                const networkingEngine = player.getNetworkingEngine();
                networkingEngine.registerRequestFilter(function(type, request) {
                    if (headersObject) {
                        for (const key in headersObject) {
                            if (headersObject.hasOwnProperty(key)) {
                                request.headers[key] = headersObject[key];
                            }
                        }
                    }
                });
            },
            setClearKey: function(player, keyId, key) {
                const keyObj = {};
                keyObj[keyId] = key;
                player.configure({
                     drm: {
                         clearKeys: keyObj
                     }
                 });
            },
            requestFullscreen: function(element) {
                if (element.requestFullscreen) {
                    element.requestFullscreen();
                } else if (element.webkitRequestFullscreen) { // Safari support
                    element.webkitRequestFullscreen();
                } else if (element.msRequestFullscreen) { // IE/Edge
                    element.msRequestFullscreen();
                }
            },
            exitFullscreen: function() {
                const doc = document;
                const fsElement = doc.fullscreenElement || doc.webkitFullscreenElement || doc.msFullscreenElement;
                if (fsElement) {
                    if (doc.exitFullscreen) {
                        doc.exitFullscreen();
                    } else if (doc.webkitExitFullscreen) {
                        doc.webkitExitFullscreen();
                    } else if (doc.msExitFullscreen) {
                        doc.msExitFullscreen();
                    }
                }
            }
        };