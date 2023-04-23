package com.example.project.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "fav_table")
data class FavouriteResult(
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    val title : String?,
    val year : String?,
    val summary : String?,
    val short_summary : String?,
    val genres : String?,
    val imdb_id : String?,
    val runtime : String?,
    val youtube_trailer : String?,
    val rating : String?,
    val poster : String?,
    val director : String?,
    val writers : String?,
    val cast : String?,
)