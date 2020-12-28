package com.benilov.gameday2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.benilov.gameday2.models.Team
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyTeamsAdapter(
    var teams: List<Team>
) : RecyclerView.Adapter<MyTeamsAdapter.MyTeamViewHolder>() {

    class MyTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val teamIcon: ShapeableImageView = view.findViewById(R.id.team_icon)
        val notificationIcon: ImageButton = view.findViewById(R.id.notification_icon)
        var shouldNotify: Boolean = false
        val name: TextView = view.findViewById(R.id.team_name)
        internal val shakeAnimation: Animation = AnimationUtils.loadAnimation(view.context, R.anim.shake)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_team, parent, false)
        return MyTeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyTeamViewHolder, position: Int) {
        holder.name.text = teams[position].name
        Picasso.get()
            .load(teams[position].iconUrl)
            .into(holder.teamIcon)
        holder.notificationIcon.setOnClickListener {
            if (holder.shouldNotify) {
                holder.shouldNotify = false
                it.background = getDrawable(it.context, R.drawable.ic_baseline_notifications_off_24)
            } else {
                holder.shouldNotify = true
                it.background = getDrawable(it.context, R.drawable.ic_baseline_notifications_active_24)
                it.startAnimation(holder.shakeAnimation)
            }
        }
    }

    override fun getItemCount() = teams.size
}