package com.andreypoltev.randomuser


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APIResponseModel(
    @SerialName("results")
    val results: List<Result> = listOf(),
    @SerialName("info")
    val info: Info = Info()
) {
    @Serializable
    data class Result(
        @SerialName("gender")
        val gender: String = "",
        @SerialName("name")
        val name: Name = Name(),
        @SerialName("location")
        val location: Location = Location(),
        @SerialName("email")
        val email: String = "",
        @SerialName("login")
        val login: Login = Login(),
        @SerialName("dob")
        val dob: Dob = Dob(),
        @SerialName("registered")
        val registered: Registered = Registered(),
        @SerialName("phone")
        val phone: String = "",
        @SerialName("cell")
        val cell: String = "",
        @SerialName("id")
        val id: Id = Id(),
        @SerialName("picture")
        val picture: Picture = Picture(),
        @SerialName("nat")
        val nat: String = ""
    ) {
        @Serializable
        data class Name(
            @SerialName("title")
            val title: String = "",
            @SerialName("first")
            val first: String = "",
            @SerialName("last")
            val last: String = ""
        )

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
            val postcode: Int = 0,
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

        @Serializable
        data class Login(
            @SerialName("uuid")
            val uuid: String = "",
            @SerialName("username")
            val username: String = "",
            @SerialName("password")
            val password: String = "",
            @SerialName("salt")
            val salt: String = "",
            @SerialName("md5")
            val md5: String = "",
            @SerialName("sha1")
            val sha1: String = "",
            @SerialName("sha256")
            val sha256: String = ""
        )

        @Serializable
        data class Dob(
            @SerialName("date")
            val date: String = "",
            @SerialName("age")
            val age: Int = 0
        )

        @Serializable
        data class Registered(
            @SerialName("date")
            val date: String = "",
            @SerialName("age")
            val age: Int = 0
        )

        @Serializable
        data class Id(
            @SerialName("name")
            val name: String = "",
            @SerialName("value")
            val value: Int? = null
        )

        @Serializable
        data class Picture(
            @SerialName("large")
            val large: String = "",
            @SerialName("medium")
            val medium: String = "",
            @SerialName("thumbnail")
            val thumbnail: String = ""
        )
    }

    @Serializable
    data class Info(
        @SerialName("seed")
        val seed: String = "",
        @SerialName("results")
        val results: Int = 0,
        @SerialName("page")
        val page: Int = 0,
        @SerialName("version")
        val version: String = ""
    )
}