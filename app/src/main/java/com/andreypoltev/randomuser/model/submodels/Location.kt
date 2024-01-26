package com.andreypoltev.randomuser.model.submodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("street")
    val street: Street = Street(),
    @SerialName("city")
    val city: String = "",
    @SerialName("state")
    val state: String = "",
    @SerialName("country")
    val country: String = "",
    @SerialName("postcode")
    val postcode: String = "",
    @SerialName("coordinates")
    val coordinates: Coordinates = Coordinates(),
    @SerialName("timezone")
    val timezone: Timezone = Timezone()
) {
    @Serializable
    data class Street(
        @SerialName("number")
        val number: Int = 0,
        @SerialName("name")
        val name: String = ""
    )

    @Serializable
    data class Coordinates(
        @SerialName("latitude")
        val latitude: String = "",
        @SerialName("longitude")
        val longitude: String = ""
    )

    @Serializable
    data class Timezone(
        @SerialName("offset")
        val offset: String = "",
        @SerialName("description")
        val description: String = ""
    )
}