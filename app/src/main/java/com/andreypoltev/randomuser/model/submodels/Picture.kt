package com.andreypoltev.randomuser.model.submodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Picture(
    @SerialName("large")
    val large: String = "",
    @SerialName("medium")
    val medium: String = "",
    @SerialName("thumbnail")
    val thumbnail: String = ""
)