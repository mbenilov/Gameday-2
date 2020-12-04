package com.benilov.gameday2.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benilov.gameday2.Repository

class TeamsViewModel() : ViewModel() {

    val teams: MutableLiveData<Teams> by lazy {
        MutableLiveData<Teams>().also {
            loadTeams()
        }
    }

    private val repository = Repository()

    private fun loadTeams() {
        repository.getTeams()
    }
}