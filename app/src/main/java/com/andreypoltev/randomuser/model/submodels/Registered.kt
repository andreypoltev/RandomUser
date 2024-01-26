package com.andreypoltev.randomuser.model.submodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Registered(
    @SerialName("date")
    val date: String = "",
    @SerialName("age")
    val age: Int = 0
)