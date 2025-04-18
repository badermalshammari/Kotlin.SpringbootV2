package com.coded.spring.ordering.service

import com.coded.spring.ordering.models.User
import com.coded.spring.ordering.repo.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun createUser(user: User): User = userRepository.save(user)
    fun getAllUsers(): List<User> = userRepository.findAll()
}