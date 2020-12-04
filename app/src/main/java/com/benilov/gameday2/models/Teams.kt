package com.benilov.gameday2.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Teams(
    @SerializedName("teams") val teams: List<Team>
) : Serializable