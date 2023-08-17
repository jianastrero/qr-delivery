package com.jianastrero.templateandroidapp.util

/**
 * Checks if the length of a given string is greater than or equal to a specified length.
 *
 * @param string The string to be checked.
 * @param length The minimum length required.
 * @return `true` if the length of the string is greater than or equal to the specified length, `false` otherwise.
 */
fun checkStringLength(string: String, length: Int): Boolean = string.length >= length
