package com.ahmadarif.springbootkotlin

import com.ahmadarif.springbootkotlin.domain.Customer
import com.ahmadarif.springbootkotlin.extension.strRand
import com.ahmadarif.springbootkotlin.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * Created by ARIF on 02-Jun-17.
 */
@Component
class ApplicationLoader : CommandLineRunner {

    @Autowired
    lateinit var repository: CustomerRepository

    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun run(vararg args: String?) {
        // save a couple of customers
        repository.save(Customer("Ahmad", "Arif"))
        repository.save(Customer("Hasan"))
        repository.save(Customer("Muniroh"))
        repository.save(Customer("Ida", "Rosyidah"))
        repository.save(Customer("Siti", "Aisyah"))
        repository.save(Customer("Hanny Tia", "Lestari"))

        (1..1000).forEach { repository.save(Customer(strRand(5), strRand(5))) }

        // fetch all customers
        log.info("Customers found with findAll():")
        log.info("-------------------------------")
        for (customer in repository.findAll()) {
            log.info(customer.toString())
        }
        log.info("")

        // fetch an individual customer by ID
        val customer = repository.findOne(1L)
        log.info("Customer found with findOne(1L):")
        log.info("--------------------------------")
        log.info(customer.toString())
        log.info("")

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):")
        log.info("--------------------------------------------")
        for (bauer in repository.findByLastName("Bauer")) {
            log.info(bauer.toString())
        }
        log.info("")
    }
}