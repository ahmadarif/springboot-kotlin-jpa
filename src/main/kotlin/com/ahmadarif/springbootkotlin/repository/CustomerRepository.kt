package com.ahmadarif.springbootkotlin.repository

import com.ahmadarif.springbootkotlin.domain.Customer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Created by ARIF on 02-Jun-17.
 */
interface CustomerRepository : PagingAndSortingRepository<Customer, Long> {
    fun findByFirstName(firstName: String): Iterable<Customer>
    fun findByLastName(lastName: String, pageable: Pageable? = null): Page<Customer>
}