package it.skrape.core

import org.jsoup.Connection

data class Request(
        var mode: Mode = Mode.SOURCE,
        // trailing slash is required
        var url: String = "http://localhost:8080/",
        var method: Method = Method.GET,
        var userAgent: String = "Mozilla/5.0 skrape.it",
        var headers: Map<String, String> = emptyMap(),
        var cookies: Map<String, String> = emptyMap(),
        var timeout: Int = 5000,
        var followRedirects: Boolean = true
)

enum class Mode {
    SOURCE,
    DOM
}

typealias Method = Connection.Method
