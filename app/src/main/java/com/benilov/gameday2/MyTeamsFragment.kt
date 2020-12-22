package com.benilov.gameday2

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

class MyTeamsFragment : Fragment() {
    private var teams: List<Team> = ArrayList()
    private var myTeamsRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_my_teams, container, false)

        myTeamsRecycler = v.findViewById(R.id.my_teams_recycler_view)
        myTeamsRecycler?.adapter = MyTeamsAdapter(teams)
        myTeamsRecycler?.layoutManager = LinearLayoutManager(context)

        val teamsViewModel: TeamsViewModel by viewModels()
        teamsViewModel.getTeams()?.observe(viewLifecycleOwner, Observer {
            (myTeamsRecycler?.adapter as MyTeamsAdapter).teams = it.teams
            myTeamsRecycler?.adapter?.notifyDataSetChanged()
        })

        return v
    }

    companion object {
        fun newInstance(): MyTeamsFragment {
            return MyTeamsFragment()
        }
    }
}