package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

//    Online Ordering - Post an Order exercise 2
@RestController
class OrderController(val orderRepository: OrderRepository) {

    @PostMapping("/orders")
    fun submitOrder(@RequestBody request: OrderRequest): Order {
        val order = Order(
            username = request.username,
            restaurant = request.restaurant,
            items = request.items,

        )
        return orderRepository.save(order)
    }

    @GetMapping("/listOrders")
    fun listOrders(): List<Order> {
        return orderRepository.findAll()
    }
}

data class OrderRequest(
    val username: String,
    val restaurant: String,
    val items: List<String>,
)