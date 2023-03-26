package com.bulletin.extension

import java.util.*

fun String?.isEmpty(): Boolean {
    return this == null || "" == trim()
}

fun String?.capitalized(): String? {
    if (this.isNullOrBlank()) {
        return this
    }

    return this.trim().split("\\s+".toRegex())
        .joinToString(" ") {    it.replaceFirstChar { // it: Char
            it.uppercase()
        } }
}

fun String?.toCamelCaseSingleWord(): String {
    if (this == null) return ""

    var s = ""
    if (length > 0) {
        s = substring(0, 1).uppercase(Locale.getDefault())
    }

    if (length > 1) {
        s += substring(1).lowercase(Locale.getDefault())
    }
    return s
}

fun String.toCamelCaseMultipleWords(): String {
    if (length == 0) {
        return this
    }
    val parts = split(" ").toTypedArray()
    var camelCaseString = ""
    for (part in parts) {
        camelCaseString = camelCaseString + toProperCase(part) + " "
    }
    return camelCaseString
}

private fun toProperCase(s: String): String {
    return s.substring(0, 1).uppercase(Locale.getDefault()) +
            s.substring(1).lowercase(Locale.getDefault())
}
