package com.coded.spring.ordering.controllers

import com.coded.spring.ordering.models.MenuItem
import com.coded.spring.ordering.service.MenuService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/menu")
class MenuController(
    private val menuService: MenuService
) {

    @GetMapping
    fun getMenu(): List<MenuItem> = menuService.getAllMenuItems()

    @PostMapping
    fun addMenuItem(@RequestBody menuItem: MenuItem): MenuItem {
        return menuService.addMenuItem(menuItem)
    }
}