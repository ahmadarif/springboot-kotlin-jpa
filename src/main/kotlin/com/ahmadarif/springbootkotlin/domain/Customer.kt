package com.ahmadarif.springbootkotlin.domain

import javax.persistence.*

/**
 * Created by ARIF on 02-Jun-17.
 */
@Entity
@Table(name = "customers")
data class Customer (
        @Column(nullable = false) val firstName: String = "",
        @Column(nullable = false) val lastName: String = "",
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0
)