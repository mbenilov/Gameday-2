package com.benilov.gameday2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScheduledGamesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_scheduled_games, container, false)
        viewManager = LinearLayoutManager(context)

        recyclerView = v.findViewById(R.id.scheduled_games_recycler_view)
        recyclerView.layoutManager = viewManager

        return v
    }

    companion object {
        fun newInstance(): ScheduledGamesFragment {
            return ScheduledGamesFragment()
        }
    }
}