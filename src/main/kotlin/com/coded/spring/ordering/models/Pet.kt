package com.coded.spring.ordering.models

import java.io.Serializable

data class Pet(
    val name: String ="",
    val type: String= ""
) : Serializable
{
    constructor() : this("", "")
}