package com.coded.spring.ordering.repo

import com.coded.spring.ordering.models.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long> {
    fun findByOrderId(orderId: Long): List<Item>
}