package com.coded.spring.ordering.controllers

import com.coded.spring.ordering.AppProperties
import com.coded.spring.ordering.pets.PetsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

    @RestController
    @RequestMapping("/api")
    class HelloWorldController (
        private val petsProvider: PetsService,
        private val appProperties: AppProperties
        ){

        @GetMapping("/hello")
        fun helloWorld(): String {
            return "Hello World!"
        }

        @PostMapping("/myNameIs")
        fun myName(@RequestBody request: NameRequest): NameResponse {
            return NameResponse(id = 1, name = request.name)
        }
        @GetMapping("/Pets")
        fun getPets(): String {
            return petsProvider.listPets().toString().replace("[", "").replace("]", "")
        }
        @GetMapping("/Welcome/OnlineOrdering")
        fun welcome(): String {
            return if (appProperties.festiveMode) {
                appProperties.festiveMessage
            } else {
                "Welcome to Online Ordering by ${appProperties.companyName}"
            }
        }

        data class NameRequest(
            val name: String
        )

        data class NameResponse(
            val id: Int,
            val name: String
        )
    }