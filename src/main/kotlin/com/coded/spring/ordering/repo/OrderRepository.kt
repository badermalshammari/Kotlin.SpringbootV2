package com.coded.spring.ordering.repo

import com.coded.spring.ordering.models.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
    fun findByUserId(userId: Long): List<Order>
}