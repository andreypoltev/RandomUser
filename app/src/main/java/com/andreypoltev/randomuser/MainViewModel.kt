package com.andreypoltev.randomuser

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreypoltev.randomuser.database.User
import com.andreypoltev.randomuser.database.UserDao
import com.andreypoltev.randomuser.model.APIResponseModel
import com.andreypoltev.randomuser.util.mapData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val userDao: UserDao) : ViewModel() {

    val isLoading = mutableStateOf(false)

    val allUsers = userDao.flowOfAllUsers()

    init {
        viewModelScope.launch(Dispatchers.IO) {

//            dbSize.value = userDao.getRowCount()

            if (userDao.getRowCount() == 0) {

                val results = getApiResponse().results

                userDao.insertUsers(mapData(results))

            }


        }
    }

    fun userEntry(id: Int) = userDao.flowUserEntry(id)

    fun refreshUserList() {
        viewModelScope.launch(Dispatchers.IO) {

            try {

                isLoading.value = true

                val newListOfUsers = getApiResponse().results

                if (newListOfUsers.isNotEmpty()) {
                    userDao.clearTable()
                    userDao.insertUsers(mapData(newListOfUsers))
                }

            } catch (e: Exception) {

                Log.e("ERROR", "An error occurred: ${e.message}", e)


            } finally {
                isLoading.value = false

            }


        }
    }

    suspend fun getApiResponse(): APIResponseModel {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }


        val link = "https://randomuser.me/api/?results=10"

        val response = client.get(link)
        Log.d("MyResponse", response.body())


        Log.d("MyResponse", response.status.toString())
        client.close()

        return response.body()

    }

}