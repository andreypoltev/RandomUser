package com.andreypoltev.randomuser

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.andreypoltev.randomuser.composables.CustomProgressIndicator
import com.andreypoltev.randomuser.util.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavHostController) {


    val users by viewModel.allUsers.collectAsState(initial = emptyList())

    val size by viewModel.dbSize


//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
//    val scrollBehavior1 = TopAppBarDefaults.

    if (users.isNotEmpty()) {


        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Users") },
                actions = {
                    IconButton(onClick = { viewModel.refreshUserList() }) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "Refresh User List"
                        )


                    }
                }

//            scrollBehavior = scrollBehavior
            )
        }) {

            if (!viewModel.isLoading.value) {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        end = 16.dp,
                        top = it.calculateTopPadding(),
                        bottom = it.calculateBottomPadding()
                    ), verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

//            item {
//                Text(text = size.toString())
//            }

                    items(users) { user ->

                        Card(modifier = Modifier.fillMaxWidth(), onClick = {


                            navController.navigate(Routes.userDetailsScreen + "/${user.id}")
                            viewModel.getCurrentUser(user.userId)

                        }) {

                            Row(
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AsyncImage(
                                    model = user.picture.medium,
                                    contentDescription = "Photo",
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clip(CircleShape),
//                            contentScale = ContentScale.FillHeight
                                )

                                Column {
                                    Text(text = user.name.title + " " + user.name.first + " " + user.name.last)
                                    Text(text = user.location.postcode + ", " + user.location.country + ", " + user.location.state + ", " + user.location.city)
                                    Text(text = user.phone)
                                }


                            }
                        }


                    }


                }
            } else {
                CustomProgressIndicator()
            }


        }

    } else {
        CustomProgressIndicator()
    }
}