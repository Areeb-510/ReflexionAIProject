package com.example.project.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_table")
data class Result(@PrimaryKey(autoGenerate = true) var id : Int = 0,
                  @SerializedName("Title") val title : String?,
                  @SerializedName("Year") val year : String?,
                  @SerializedName("Summary") val summary : String?,
                  @SerializedName("Short Summary") val short_summary : String?,
                  @SerializedName("Genres") val genres : String?,
                  @SerializedName("IMDBID") val imdb_id : String?,
                  @SerializedName("Runtime") val runtime : String?,
                  @SerializedName("YouTube Trailer") val youtube_trailer : String?,
                  @SerializedName("Rating")val rating : String?,
                  @SerializedName("Movie Poster") val poster : String?,
                  @SerializedName("Director") val director : String?,
                  @SerializedName("Writers") val writers : String?,
                  @SerializedName("Cast") val cast : String?,
)