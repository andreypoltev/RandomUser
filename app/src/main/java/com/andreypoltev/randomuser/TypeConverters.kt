package com.andreypoltev.randomuser

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TypeConverters {

    @TypeConverter
    fun toName(name: String): User.Name =
        Json.decodeFromString<User.Name>(name)

    @TypeConverter
    fun fromName(name: User.Name): String =
        Json.encodeToString(name)


    @TypeConverter
    fun toLocation(location: String): User.Location =
        Json.decodeFromString<User.Location>(location)

    @TypeConverter
    fun fromLocation(location: User.Location): String =
        Json.encodeToString(location)


    @TypeConverter
    fun toLogin(login: String): User.Login =
        Json.decodeFromString<User.Login>(login)

    @TypeConverter
    fun fromLogin(login: User.Login): String =
        Json.encodeToString(login)


    @TypeConverter
    fun toDob(dob: String): User.Dob =
        Json.decodeFromString<User.Dob>(dob)

    @TypeConverter
    fun fromDob(dob: User.Dob): String =
        Json.encodeToString(dob)

    @TypeConverter
    fun toRegistered(registered: String): User.Registered =
        Json.decodeFromString<User.Registered>(registered)

    @TypeConverter
    fun fromRegistered(registered: User.Registered): String =
        Json.encodeToString(registered)


    @TypeConverter
    fun toId(id: String): User.Id =
        Json.decodeFromString<User.Id>(id)

    @TypeConverter
    fun fromId(id: User.Id): String =
        Json.encodeToString(id)

    @TypeConverter
    fun toPicture(picture: String): User.Picture =
        Json.decodeFromString<User.Picture>(picture)

    @TypeConverter
    fun fromPicture(picture: User.Picture): String =
        Json.encodeToString(picture)




}