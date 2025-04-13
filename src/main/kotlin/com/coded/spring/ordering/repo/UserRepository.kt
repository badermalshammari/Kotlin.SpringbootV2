package com.coded.spring.ordering.repo

import com.coded.spring.ordering.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>