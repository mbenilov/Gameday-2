package com.benilov.gameday2

import com.benilov.gameday2.models.Team

interface NotificationsPrefsListener {
    fun addTeam(team: Team)
    fun removeTeam(team: Team)
}