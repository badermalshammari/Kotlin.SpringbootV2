package com.coded.spring.ordering.service

import com.coded.spring.ordering.models.MenuItem
import com.coded.spring.ordering.repo.MenuItemRepository
import org.springframework.stereotype.Service

@Service
class MenuService(
    private val menuItemRepository: MenuItemRepository
) {
    fun getAllMenuItems(): List<MenuItem> = menuItemRepository.findAll()

    fun addMenuItem(menuItem: MenuItem): MenuItem = menuItemRepository.save(menuItem)
}