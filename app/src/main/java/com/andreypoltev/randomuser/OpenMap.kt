package com.andreypoltev.randomuser

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun OpenMap() {
    val context = LocalContext.current
    val latitude = 37.7749
    val longitude = -122.4194

    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = Uri.parse("geo:$latitude,$longitude")
    }

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}