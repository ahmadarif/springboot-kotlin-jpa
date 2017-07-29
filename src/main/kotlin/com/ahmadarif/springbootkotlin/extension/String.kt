package com.ahmadarif.springbootkotlin.extension

import java.util.Random
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort


/**
 * Created by ARIF on 02-Jun-17.
 */

fun strRand(length: Int = 10): String {
    val leftLimit = 97 // letter 'a'
    val rightLimit = 122 // letter 'z'
    val targetStringLength = length
    val random = Random()
    val buffer = StringBuilder(targetStringLength)
    for (i in 0..targetStringLength - 1) {
        val randomLimitedInt = leftLimit + (random.nextFloat() * (rightLimit - leftLimit + 1)).toInt()
        buffer.append(randomLimitedInt.toChar())
    }
    return buffer.toString()
}