package com.andreypoltev.randomuser.util

import com.andreypoltev.randomuser.database.User
import com.andreypoltev.randomuser.model.APIResponseModel

fun mapData(response: List<APIResponseModel.Result>): List<User> = response.map { user ->

    User(
        userId = 0,
        gender = user.gender,
        name = user.name,
        location = user.location,
        email = user.email,
        login = user.login,
        dob = user.dob,
        registered = user.registered,
        phone = user.phone,
        cell = user.cell,
        id = user.id,
        picture = user.picture,
        nat = user.nat
    )

}