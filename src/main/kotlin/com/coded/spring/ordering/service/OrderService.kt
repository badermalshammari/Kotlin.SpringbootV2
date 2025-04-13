package com.coded.spring.ordering.service

import com.coded.spring.ordering.models.Order
import com.coded.spring.ordering.repo.OrderRepository
import com.coded.spring.ordering.repo.UserRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val userRepository: UserRepository
) {

    fun createOrder(userId: Long) {
        val user = userRepository.findById(userId).orElseThrow { Exception("User not found") }
        val newOrder = Order(user = user)
        orderRepository.save(newOrder)
    }

    fun getOrdersByUserId(userId: Long): List<Order> {
        return orderRepository.findByUserId(userId)
    }
}