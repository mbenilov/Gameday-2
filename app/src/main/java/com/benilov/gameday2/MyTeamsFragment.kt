package com.benilov.gameday2

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benilov.gameday2.models.Team
import com.benilov.gameday2.models.TeamsViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyTeamsFragment : Fragment(), NotificationsPrefsListener {
    private var teams: List<Team> = ArrayList()
    private var savedTeams: ArrayList<Team> = ArrayList()
    private var teamsRecycler: RecyclerView? = null
    private var loadingIcon: LoadingIconView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_my_teams, container, false)

        activity?.getPreferences(MODE_PRIVATE)?.getString(SAVED_TEAMS, null)?.let { json ->
            savedTeams = Gson().fromJson<ArrayList<Team>>(json)
        }

        loadingIcon = v.findViewById(R.id.loading_icon)
        teamsRecycler = v.findViewById(R.id.my_teams_recycler_view)
        teamsRecycler?.adapter = MyTeamsAdapter(teams, savedTeams,this)
        teamsRecycler?.layoutManager = LinearLayoutManager(context)

        val teamsViewModel: TeamsViewModel by viewModels()
        teamsViewModel.getTeams()?.observe(viewLifecycleOwner, Observer {
            (teamsRecycler?.adapter as MyTeamsAdapter).teams = it.teams
            teamsRecycler?.adapter?.notifyDataSetChanged()
            loadingIcon?.stop()
        })

        return v
    }

    override fun onStart() {
        super.onStart()

        loadingIcon?.start()
    }

    override fun addTeam(team: Team) {
        if (!savedTeams.contains(team)) savedTeams.add(team)
        updateNotificationPrefs()
    }

    override fun removeTeam(team: Team) {
        savedTeams.remove(team)
        updateNotificationPrefs()
    }

    private fun updateNotificationPrefs() {
        val notificationPrefs = activity?.getPreferences(MODE_PRIVATE) ?: return
        with (notificationPrefs.edit()) {
            putString(SAVED_TEAMS, Gson().toJson(savedTeams))
            apply()
        }
    }

    private inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object: TypeToken<T>() {}.type)

    companion object {
        const val SAVED_TEAMS = "SAVED_TEAMS"
        fun newInstance(): MyTeamsFragment {
            return MyTeamsFragment()
        }
    }
}