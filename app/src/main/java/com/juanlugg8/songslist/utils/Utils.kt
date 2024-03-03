package com.juanlugg8.songslist.utils

fun maxLength(text: String): String {
    val max = 10
    if (text.length > max) {
        return text.substring(0, max) + "..."
    } else
        return text
}