package com.benilov.gameday2

import com.benilov.gameday2.models.Team
import retrofit2.Call
import retrofit2.http.GET

interface Webservice {
    @GET("https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=nba/")
    fun getTeams(): Call<List<Team>>
}