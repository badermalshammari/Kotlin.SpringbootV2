package com.coded.spring.ordering.service

import com.coded.spring.ordering.models.Item
import com.coded.spring.ordering.repo.ItemRepository
import com.coded.spring.ordering.repo.OrderRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository,
    private val orderRepository: OrderRepository
) {
    fun createItem(orderId: Long, name: String, quantity: Int): Item {
        val order = orderRepository.findById(orderId).orElseThrow { Exception("Order not found") }
        return itemRepository.save(Item(name = name, quantity = quantity, order = order))
    }

    fun getItemsByOrderId(orderId: Long): List<Item> {
        return itemRepository.findByOrderId(orderId)
    }
}