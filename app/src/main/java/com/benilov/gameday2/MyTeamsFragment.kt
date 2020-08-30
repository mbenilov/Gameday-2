package com.benilov.gameday2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MyTeamsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_my_teams, container, false)
        return v
    }

    companion object {
        fun newInstance(): MyTeamsFragment {
            return MyTeamsFragment()
        }
    }
}