package com.coded.spring.ordering.pets

import com.coded.spring.ordering.models.Pet
import org.springframework.stereotype.Component

@Component
class PetsClient {

    fun getPets(): List<Pet> {
        return listOf(
            Pet(name = "Coco", type = "Bird"),
            Pet(name = "Rocky", type = "Dog"),
            Pet(name = "Daisy", type = "Rabbit"),
            Pet(name = "Simba", type = "Cat"),
            Pet(name = "Buddy", type = "Dog"),
            Pet(name = "Chloe", type = "Cat"),
            Pet(name = "Angel", type = "Bird"),
            Pet(name = "Shadow", type = "Dog"),
            Pet(name = "Lily", type = "Cat"),
            Pet(name = "Pepper", type = "Bird"),
            Pet(name = "Bailey", type = "Dog"),
            Pet(name = "Nala", type = "Cat"),
            Pet(name = "Zoe", type = "Rabbit"),
            Pet(name = "Toby", type = "Dog")
        )
    }
}