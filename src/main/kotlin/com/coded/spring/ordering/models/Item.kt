package com.coded.spring.ordering.models

import jakarta.persistence.*

@Entity
@Table(name = "items")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",

    val quantity: Int = 0,

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    val order: Order = Order()
) {
    constructor() : this(0, "", 0, Order())
}