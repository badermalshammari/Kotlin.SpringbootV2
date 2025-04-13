package com.coded.spring.ordering.controllers

import com.coded.spring.ordering.models.Order
import com.coded.spring.ordering.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/orders")
    fun createOrder(@RequestBody request: CreateOrderRequest) {
        orderService.createOrder(request.userId)
    }

    @GetMapping("/orders")
    fun getOrders(@RequestParam userId: Long): List<Order> {
        return orderService.getOrdersByUserId(userId)
    }
}

data class CreateOrderRequest(
    val userId: Long
)