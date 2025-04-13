package com.coded.spring.ordering.authentication

import com.coded.spring.ordering.repo.UserRepository
import org.springframework.security.core.userdetails.*
import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.User as SecurityUser

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found")

        return SecurityUser.builder()
            .username(user.username)
            .password(user.password)
            .roles("USER")
            .build()
    }
}