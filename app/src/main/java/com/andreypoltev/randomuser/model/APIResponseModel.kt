package com.andreypoltev.randomuser.model


import com.andreypoltev.randomuser.model.submodels.Dob
import com.andreypoltev.randomuser.model.submodels.Id
import com.andreypoltev.randomuser.model.submodels.Location
import com.andreypoltev.randomuser.model.submodels.Login
import com.andreypoltev.randomuser.model.submodels.Name
import com.andreypoltev.randomuser.model.submodels.Picture
import com.andreypoltev.randomuser.model.submodels.Registered
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
    )

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