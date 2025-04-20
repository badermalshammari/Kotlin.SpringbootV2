package com.coded.spring.ordering.repo

import com.coded.spring.ordering.models.Profile
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<Profile, Long> {
    fun findByUserId(userId: Long): Profile?
}