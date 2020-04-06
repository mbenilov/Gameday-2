package com.benilov.gameday2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.benilov.gameday2.models.GameViewModel

class ScheduledGamesFragment : Fragment() {

    private var scheduledGamesRecycler: RecyclerView? = null
    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scheduled_games, container, false)
    }
}