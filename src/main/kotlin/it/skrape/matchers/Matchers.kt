package it.skrape.matchers

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.doesNotContain
import assertk.assertions.isEqualTo
import assertk.assertions.isGreaterThanOrEqualTo
import assertk.assertions.isNotEqualTo
import assertk.assertions.isZero
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isNotEqualTo

infix fun Int.toBe(expected: Int) {
    expectThat(this).isEqualTo(expected)
}

infix fun Int.`to be`(expected: Int) = this toBe expected

infix fun String?.toBe(expected: String?) {
    expectThat(this).isEqualTo(expected)
}

infix fun String?.`to be`(expected: String?) = this toBe expected

infix fun String?.toBeNot(expected: String?) {
    expectThat(this).isNotEqualTo(expected)
}

infix fun String?.`to be not`(expected: String?) = this toBeNot expected

infix fun String?.toContain(expected: String) {
    assertThat(this.toString()).contains(expected)
}

infix fun String?.`to contain`(expected: String) = this toContain expected

infix fun String?.toNotContain(expected: String) {
    assertThat(this.toString()).doesNotContain(expected)
}

infix fun String?.`to not contain`(expected: String) = this toNotContain expected

infix fun List<Any>.toContain(expected: String) {
    assertThat(this).contains(expected)
}

fun Elements.toBePresent() {
    assertThat(this.size).isGreaterThanOrEqualTo(1)
}

fun Element.toBePresent() {
    assertThat(this.allElements.size).isGreaterThanOrEqualTo(1)
}

fun Elements.toBeNotPresent() {
    assertThat(this.size).isZero()
}

infix fun List<Any>.`to contain`(expected: String) = this.toContain(expected)
