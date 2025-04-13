package com.coded.spring.ordering.models

import jakarta.persistence.*


@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var age: Int,

    @Column(unique = true)
    var username: String,


    var password: String,

    @Enumerated(EnumType.STRING)
    val role: Roles = Roles.USER

){
    constructor() : this(null, "name", 0, "username", "password", Roles.USER)
}
enum class Roles {
    USER, ADMIN
}