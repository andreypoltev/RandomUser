package com.andreypoltev.randomuser

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(userDao: UserDao) : ViewModel() {

    val allUsers = userDao.flowOfAllUsers()

    init {
        viewModelScope.launch(Dispatchers.IO) {

            if (userDao.getRowCount() == 0) {
                getApiResponse()
            }


        }
    }


    suspend fun getApiResponse(): APIResponseModel {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }


        val link = "https://randomuser.me/api/"

        val response = client.get(link)
        Log.d("MyResponse", response.body())


        Log.d("MyResponse", response.status.toString())
        client.close()

        return response.body()

    }

}