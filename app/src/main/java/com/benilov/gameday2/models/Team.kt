package com.benilov.gameday2.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Team(
    @SerializedName("strTeam") val name: String,
    @SerializedName("strTeamBadge") val badgeUrl: String
) : Serializable