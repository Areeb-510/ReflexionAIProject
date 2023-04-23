package com.example.project.models

import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("Movie List") val movies : List<Result>,
)