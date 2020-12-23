package com.benilov.gameday2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.benilov.gameday2.models.Team
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyTeamsAdapter(
    internal var teams: List<Team>
) : RecyclerView.Adapter<MyTeamsAdapter.MyTeamViewHolder>() {

    class MyTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var icon: ShapeableImageView = view.findViewById(R.id.teamIcon)
        var name: TextView = view.findViewById(R.id.teamName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_team, parent, false)
        return MyTeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyTeamViewHolder, position: Int) {
        holder.name.text = teams[position].name
        Picasso.get()
            .load(teams[position].badgeUrl)
            .into(holder.icon)
    }

    override fun getItemCount() = teams.size
}