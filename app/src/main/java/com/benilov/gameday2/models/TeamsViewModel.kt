package com.benilov.gameday2.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benilov.gameday2.Repository

class TeamsViewModel() : ViewModel() {

    private val repository = Repository()
    private var teams: MutableLiveData<Teams>? = null

    init {
        if (teams == null) {
            loadTeams()
        }
    }

    fun getTeams(): LiveData<Teams>? {
        return teams
    }

    private fun loadTeams() {
        teams = repository.getTeams()
    }
}