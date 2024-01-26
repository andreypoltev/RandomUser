package com.andreypoltev.randomuser

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT COUNT(*) FROM User")
    suspend fun getRowCount(): Int

    @Query("SELECT * FROM User")
    fun flowOfAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM User WHERE id = :id")
    fun flowOfExistingUser(id: Int): Flow<User?>

    @Query("SELECT * FROM User WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Insert
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}