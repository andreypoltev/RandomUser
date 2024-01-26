package com.andreypoltev.randomuser.util

import androidx.room.TypeConverter
import com.andreypoltev.randomuser.model.submodels.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class TypeConverters {

    @TypeConverter
    fun toName(name: String): Name =
        Json.decodeFromString<Name>(name)

    @TypeConverter
    fun fromName(name: Name): String =
        Json.encodeToString(name)


    @TypeConverter
    fun toLocation(location: String): Location =
        Json.decodeFromString<Location>(location)

    @TypeConverter
    fun fromLocation(location: Location): String =
        Json.encodeToString(location)


    @TypeConverter
    fun toLogin(login: String): Login =
        Json.decodeFromString<Login>(login)

    @TypeConverter
    fun fromLogin(login: Login): String =
        Json.encodeToString(login)


    @TypeConverter
    fun toDob(dob: String): Dob =
        Json.decodeFromString<Dob>(dob)

    @TypeConverter
    fun fromDob(dob: Dob): String =
        Json.encodeToString(dob)

    @TypeConverter
    fun toRegistered(registered: String): Registered =
        Json.decodeFromString<Registered>(registered)

    @TypeConverter
    fun fromRegistered(registered: Registered): String =
        Json.encodeToString(registered)


    @TypeConverter
    fun toId(id: String): Id =
        Json.decodeFromString<Id>(id)

    @TypeConverter
    fun fromId(id: Id): String =
        Json.encodeToString(id)

    @TypeConverter
    fun toPicture(picture: String): Picture =
        Json.decodeFromString<Picture>(picture)

    @TypeConverter
    fun fromPicture(picture: Picture): String =
        Json.encodeToString(picture)




}