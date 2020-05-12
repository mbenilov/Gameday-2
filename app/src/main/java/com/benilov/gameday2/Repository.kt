package com.benilov.gameday2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benilov.gameday2.models.Team
import retrofit2.Callback

class Repository {
    private val webService: Webservice = TODO()

//    fun getTeams(): LiveData<Team> {
//        val data = MutableLiveData<Team>()
//        webService.getTeams().enqueue(object : Callback<Team>) {
//
//        }
//    }
}