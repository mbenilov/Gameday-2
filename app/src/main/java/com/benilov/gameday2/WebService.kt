package com.benilov.gameday2

import com.benilov.gameday2.models.Teams
import retrofit2.Call
import retrofit2.http.GET

interface WebService {
    @GET("api/v1/json/1/search_all_teams.php?l=nba")
    fun getTeams(): Call<Teams>
}