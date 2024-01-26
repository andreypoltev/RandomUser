package com.andreypoltev.randomuser.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andreypoltev.randomuser.model.submodels.Dob
import com.andreypoltev.randomuser.model.submodels.Id
import com.andreypoltev.randomuser.model.submodels.Location
import com.andreypoltev.randomuser.model.submodels.Login
import com.andreypoltev.randomuser.model.submodels.Name
import com.andreypoltev.randomuser.model.submodels.Picture
import com.andreypoltev.randomuser.model.submodels.Registered

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
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
)