package com.coded.spring.ordering.controllers

import com.coded.spring.ordering.models.Item
import com.coded.spring.ordering.service.ItemService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/items")
class ItemController(
    private val itemService: ItemService
) {

    @PostMapping
    fun createItem(@RequestBody request: CreateItemRequest): Item {
        return itemService.createItem(request.orderId, request.name, request.quantity)
    }

    @GetMapping
    fun getItems(@RequestParam orderId: Long): List<Item> {
        return itemService.getItemsByOrderId(orderId)
    }
}

data class CreateItemRequest(
    val orderId: Long,
    val name: String,
    val quantity: Int
)