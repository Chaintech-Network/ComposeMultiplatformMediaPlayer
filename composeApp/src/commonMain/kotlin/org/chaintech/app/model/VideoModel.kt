package org.chaintech.app.model

data class VideoModel  (
    var id: String,
    var description: String,
    var sources: String,
    var subtitle: String,
    var thumb: String,
    var title: String,
    var duration: String = "",
    var rating: String = "",
    var date: String = "",
    var thumbL: String = ""
    )