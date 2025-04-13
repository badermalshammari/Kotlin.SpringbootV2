package com.coded.spring.ordering.models

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val username: String ="",

    @Column(nullable = false)
    val age: Int = 0
)