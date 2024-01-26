package com.andreypoltev.randomuser

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
data class User(
    @PrimaryKey
    val userId: Int,
    val gender: String = "",
    val name: Name = Name(),
    val location: Location = Location(),
    val email: String = "",
    val login: Login = Login(),
    val dob: Dob = Dob(),
    val registered: Registered = Registered(),
    val phone: String = "",
    val cell: String = "",
    val id: Id = Id(),
    val picture: Picture = Picture(),
    val nat: String = ""
) {
    @Serializable
    data class Name(
        val title: String = "",
        val first: String = "",
        val last: String = ""
    )

    @Serializable
    data class Location(
        val street: Street = Street(),
        val city: String = "",
        val state: String = "",
        val country: String = "",
        val postcode: Int = 0,
        val coordinates: Coordinates = Coordinates(),
        val timezone: Timezone = Timezone()
    ) {
        @Serializable
        data class Street(
            val number: Int = 0,
            val name: String = ""
        )

        @Serializable
        data class Coordinates(
            val latitude: String = "",
            val longitude: String = ""
        )

        @Serializable
        data class Timezone(
            val offset: String = "",
            val description: String = ""
        )
    }

    @Serializable
    data class Login(
        val uuid: String = "",
        val username: String = "",
        val password: String = "",
        val salt: String = "",
        val md5: String = "",
        val sha1: String = "",
        val sha256: String = ""
    )

    @Serializable
    data class Dob(
        val date: String = "",
        val age: Int = 0
    )

    @Serializable
    data class Registered(
        val date: String = "",
        val age: Int = 0
    )

    @Serializable
    data class Id(
        val name: String = "",
        val value: Int? = null
    )

    @Serializable
    data class Picture(
        val large: String = "",
        val medium: String = "",
        val thumbnail: String = ""
    )
}