package com.andreypoltev.randomuser

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    version = 1,
    entities = [User::class],
    exportSchema = true
)
@TypeConverters(com.andreypoltev.randomuser.TypeConverters::class)
abstract class UserDataBase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        const val DATABASE_NAME = "users_db"
    }

}