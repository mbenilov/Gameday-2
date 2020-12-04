package com.benilov.gameday2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.benilov.gameday2.models.Teams
import com.benilov.gameday2.models.TeamsViewModel

class MyTeamsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_my_teams, container, false)
        val teamsViewModel: TeamsViewModel by viewModels()

        teamsViewModel.teams.observe(viewLifecycleOwner, Observer<Teams> { teams ->
            // update recycler view here
            Toast.makeText(context, "NBA teams successfully loaded", LENGTH_SHORT).show()
        })

        return v
    }

    companion object {
        fun newInstance(): MyTeamsFragment {
            return MyTeamsFragment()
        }
    }
}