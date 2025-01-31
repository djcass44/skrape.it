package it.skrape.selects.html5

import it.skrape.SkrapeItDslMarker
import it.skrape.core.Doc
import it.skrape.selects.elements
import org.jsoup.select.Elements

/**
 * Will pick all occurrences of <area> elements from a Doc.
 * The selection can be specified/limited by an additional css-selector.
 * @param cssSelector
 * @return Elements
 */
@SkrapeItDslMarker
fun Doc.area(cssSelector: String = "", init: Elements.() -> Unit) = elements("area$cssSelector", init)

/**
 * Will pick all occurrences of <audio> elements from a Doc.
 * The selection can be specified/limited by an additional css-selector.
 * @param cssSelector
 * @return Elements
 */
@SkrapeItDslMarker
fun Doc.audio(cssSelector: String = "", init: Elements.() -> Unit) = elements("audio$cssSelector", init)

/**
 * Will pick all occurrences of <img> elements from a Doc.
 * The selection can be specified/limited by an additional css-selector.
 * @param cssSelector
 * @return Elements
 */
@SkrapeItDslMarker
fun Doc.img(cssSelector: String = "", init: Elements.() -> Unit) = elements("img$cssSelector", init)

/**
 * Will pick all occurrences of <map> elements from a Doc.
 * The selection can be specified/limited by an additional css-selector.
 * @param cssSelector
 * @return Elements
 */
@SkrapeItDslMarker
fun Doc.map(cssSelector: String = "", init: Elements.() -> Unit) = elements("map$cssSelector", init)

/**
 * Will pick all occurrences of <track> elements from a Doc.
 * The selection can be specified/limited by an additional css-selector.
 * @param cssSelector
 * @return Elements
 */
@SkrapeItDslMarker
fun Doc.track(cssSelector: String = "", init: Elements.() -> Unit) = elements("track$cssSelector", init)

/**
 * Will pick all occurrences of <video> elements from a Doc.
 * The selection can be specified/limited by an additional css-selector.
 * @param cssSelector
 * @return Elements
 */
@SkrapeItDslMarker
fun Doc.video(cssSelector: String = "", init: Elements.() -> Unit) = elements("video$cssSelector", init)
