package it.skrape.core.fetcher

import it.skrape.core.*
import org.assertj.core.api.KotlinAssertions
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.net.SocketTimeoutException

internal class BrowserFetcherTest : WireMockSetup() {

    @Test
    internal fun `will fetch localhost 8080 with defaults if no params`() {
        // given
        wireMockServer.setupStub()

        // when
        val fetched = BrowserFetcher(Request()).fetch()

        // then
        KotlinAssertions.assertThat(fetched.statusCode).isEqualTo(200)
        KotlinAssertions.assertThat(fetched.document.title()).isEqualTo("i'm the title")
    }

    @Test
    internal fun `can fetch url and use HTTP verb GET by default`() {
        // given
        wireMockServer.setupStub(path = "/example")
        val options = Request().apply {
            url = "https://localhost:8089/example"
        }

        // when
        val fetched = BrowserFetcher(options).fetch()

        // then
        KotlinAssertions.assertThat(fetched.statusCode).isEqualTo(200)
        KotlinAssertions.assertThat(fetched.document.title()).isEqualTo("i'm the title")
    }

    @Test
    internal fun `will not throw exception on non existing url`() {
        // given
        val options = Request().apply {
            url = "http://localhost:8080/not-existing"
        }

        // when
        val fetched = BrowserFetcher(options).fetch()

        // then
        KotlinAssertions.assertThat(fetched.statusCode).isEqualTo(404)
    }

    @Test
    internal fun `will throw exception when trying to not follow redirects`() {
        // given
        wireMockServer.setupRedirect()
        val options = Request().apply {
            followRedirects = false
        }

        Assertions.assertThrows(UnsupportedRequestOptionException::class.java
        ) {
            BrowserFetcher(options).fetch()
        }
    }

    @Test
    internal fun `will follow redirect by default`() {
        // given
        wireMockServer.setupRedirect()

        // when
        val fetched = BrowserFetcher(Request()).fetch()

        // then
        KotlinAssertions.assertThat(fetched.statusCode).isEqualTo(404)
    }

    @Test
    internal fun `will throw exception on HTTP verb POST`() {
        // given
        val options = Request().apply {
            method = Method.POST
        }

        Assertions.assertThrows(UnsupportedRequestOptionException::class.java
        ) {
            BrowserFetcher(options).fetch()
        }
    }

    @Test
    internal fun `can parse js rendered elements`() {
        // given
        // given
        wireMockServer.setupStub(fileName = "js.html")

        val fetched = BrowserFetcher(Request()).fetch()

        KotlinAssertions.assertThat(fetched.document.select("div.dynamic").text()).isEqualTo("I have been dynamically added via Javascript")
    }

    @Disabled
    @Test
    internal fun `will throw exception on timeout`() {
        wireMockServer.setupStub(delay = 6000)

        Assertions.assertThrows(SocketTimeoutException::class.java
        ) {
            BrowserFetcher(Request()).fetch()
        }
    }
}