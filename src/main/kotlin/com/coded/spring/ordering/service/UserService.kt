package com.coded.spring.ordering.service

import com.coded.spring.ordering.models.User
import com.coded.spring.ordering.repo.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun createUser(user: User): User {
        // Check for username uniqueness
        if (userRepository.findByUsername(user.username) != null) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists")
        }

        // Validate password strength
        if (!isValidPassword(user.password)) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Password must be at least 6 characters long, contain at least one capital letter, and one number"
            )
        }

        // Hash the password and save the user
        val hashedPassword = passwordEncoder.encode(user.password)
        val newUser = user.copy(password = hashedPassword)
        return userRepository.save(newUser)
    }

    private fun isValidPassword(password: String): Boolean {
        val hasCapital = Regex("[A-Z]").containsMatchIn(password)
        val hasNumber = Regex("[0-9]").containsMatchIn(password)
        val isLongEnough = password.length >= 6

        return hasCapital && hasNumber && isLongEnough
    }
}