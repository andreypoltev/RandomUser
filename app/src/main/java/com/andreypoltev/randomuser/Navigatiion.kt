package com.andreypoltev.randomuser

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp

@Composable
fun Navigation(viewModel: MainViewModel) {

    val users by viewModel.allUsers.collectAsState(initial = emptyList())




    Scaffold {
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            )
        ) {

            items(users) { user ->

                Text(text = user.phone)

            }


        }
    }

}