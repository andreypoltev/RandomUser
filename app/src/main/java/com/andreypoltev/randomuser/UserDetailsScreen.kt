package com.andreypoltev.randomuser

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.andreypoltev.randomuser.composables.CustomCard
import com.andreypoltev.randomuser.composables.CustomColumn
import com.andreypoltev.randomuser.composables.CustomProgressIndicator
import com.andreypoltev.randomuser.database.User
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsScreen(viewModel: MainViewModel, navController: NavHostController, id: String?) {

    val context = LocalContext.current


    val users = viewModel.allUsers.collectAsState(initial = emptyList())

    if (users.value.isNotEmpty()) {
        val user = users.value.find { it.userId == id.toString().toInt() }

        if (user != null) {

            Scaffold {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = it.calculateTopPadding(),
                            bottom = it.calculateBottomPadding()
                        ),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    item {

                        AsyncImage(
                            model = user.picture.large,
                            contentDescription = "Photo",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(20.dp)),
//                                contentScale = ContentScale.Fit
//                            .clip(CircleShape),
                            contentScale = ContentScale.FillWidth
                        )
                    }

                    item {
                        Text(text = user.name.title + " " + user.name.first + " " + user.name.last + ", " + user.gender)
                        Text(text = "Date of birth: ${user.dob.date.take(10)} (${user.dob.age})")
                        Text(text = "Nationality: ${user.nat}")

                    }
                    item {
                        Card(onClick = {

                            val emailAddress = user.email

                            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:")
                                putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
//                                putExtra(Intent.EXTRA_SUBJECT, "subject")
//                                putExtra(Intent.EXTRA_TEXT, "body")
                            }
                            if (emailIntent.resolveActivity(context.packageManager) != null) {
                                context.startActivity(emailIntent)
                            }


                        }) {

                            Text(text = user.email)
                        }

                    }

                    item {
                        CustomCard {
                            CustomColumn {
                                Text(text = user.location.country)
                                Text(text = user.location.postcode + ", " + user.location.state + ", " + user.location.city + ", " + user.location.street.number.toString() + " " + user.location.street.name)
//                                Text(text = "Country: ${user.location.country}")
//                                Text(text = "State: ${user.location.state}")
//                                Text(text = "City: ${user.location.city}")

                            }
                        }

                    }

                    item {
                        Text(text = user.location.timezone.offset)
                        Text(text = user.location.timezone.description)
                    }

                    item {
                        CustomCard {
                            CustomColumn {
                                Text(text = user.login.uuid)
                                Text(text = user.login.username)
                                Text(text = user.login.password)
                                Text(text = user.login.salt)
                                Text(text = user.login.md5)
                                Text(text = user.login.sha1)
                                Text(text = user.login.sha256)
                            }
                        }

                    }

                    item {
                        Card(onClick = {


//                            val phoneNumber = user.phone
//
//
//                            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
//                                data = Uri.parse("tel:$phoneNumber")
//                            }
//                            if (dialIntent.resolveActivity(context.packageManager) != null) {
//                                context.startActivity(dialIntent)
//                            }


                            val latitude = user.location.coordinates.latitude
                            val longitude = user.location.coordinates.longitude


                            val uriString = "geo:$latitude,$longitude"
//                            val uriString = "geo:$latitude,$longitude?q=$latitude,$longitude"
                            val uri = Uri.parse(uriString)
                            val mapIntent = Intent(Intent.ACTION_VIEW, uri)

                            // You can set the package name of a specific maps app to open that app directly
                            // Example: mapIntent.setPackage("com.google.android.apps.maps")

                            if (mapIntent.resolveActivity(context.packageManager) != null) {
                                startActivity(context, mapIntent, null)
//                                startActivity(context, mapIntent, null)
                            }

//                            val locationUri = Uri.parse("geo:$latitude,$longitude")
//
//                            val mapIntent = Intent(Intent.ACTION_VIEW, locationUri)
//                            if (mapIntent.resolveActivity(context.packageManager) != null) {
//                                context.startActivity(mapIntent)
//                            }


                        }) {
                            CustomColumn {
                                Text(text = user.location.street.number.toString())
                                Text(text = user.location.street.name)
                                Text(text = user.location.coordinates.latitude)
                                Text(text = user.location.coordinates.longitude)
                            }
                        }

                    }


                    item {
                        CustomCard {
                            CustomColumn {
                                Text(text = user.registered.date)
                                Text(text = user.registered.age.toString())
                            }
                        }

                    }

                    item {
                        Card(onClick = {
                            val phoneNumber = user.phone


                            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:$phoneNumber")
                            }
                            if (dialIntent.resolveActivity(context.packageManager) != null) {
                                context.startActivity(dialIntent)
                            }

                        }) {
                            CustomColumn {
                                Text(text = user.phone)
                                Text(text = user.cell)
                            }
                        }

                    }


                    item {


                        Text(text = user.id.name)
                        Text(text = user.id.value.toString())

                    }
                }
            }


        } else {
            navController.popBackStack()
        }
    } else {
        CustomProgressIndicator()
    }


}