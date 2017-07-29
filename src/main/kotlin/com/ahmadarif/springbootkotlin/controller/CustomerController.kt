package com.ahmadarif.springbootkotlin.controller

import com.ahmadarif.springbootkotlin.extension.pageable
import com.ahmadarif.springbootkotlin.repository.CustomerRepository
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by ARIF on 02-Jun-17.
 */
@RestController
class CustomerController(val repository: CustomerRepository) {
    @GetMapping("/")
    fun findAll(@RequestParam(defaultValue = "0") page: Int) = repository.findAll(pageable(page))

    @GetMapping("/firstName/{firstName}")
    fun findByFirstName(@PathVariable firstName: String) =
        repository.findByFirstName(firstName)

    @GetMapping("/lastName/{lastName}")
    fun findByLastName(@PathVariable lastName: String, pageable: Pageable) =
        repository.findByLastName(lastName, pageable)
}