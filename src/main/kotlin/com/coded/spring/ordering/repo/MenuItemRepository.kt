package com.coded.spring.ordering.repo

import com.coded.spring.ordering.models.MenuItem
import org.springframework.data.jpa.repository.JpaRepository

interface MenuItemRepository : JpaRepository<MenuItem, Long>