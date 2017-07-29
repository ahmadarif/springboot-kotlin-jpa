package com.ahmadarif.springbootkotlin.extension

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

/**
 * Created by ARIF on 03-Jun-17.
 */

fun pageable(page: Int = 0, size: Int = 20, sortName: String? = null, sortDir: String? = "ASC"): PageRequest {
    when (sortName) {
        null -> return PageRequest(page, size)
        else -> {
            when (sortDir) {
                "DESC" -> return PageRequest(page, size, Sort.Direction.DESC, sortName)
                else -> return PageRequest(page, size, Sort.Direction.ASC, sortName)
            }
        }
    }
}