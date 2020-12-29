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
    var teams: List<Team>,
    var savedTeams: List<Team>,
    private val listener: NotificationsPrefsListener
) : RecyclerView.Adapter<MyTeamsAdapter.MyTeamViewHolder>() {

    class MyTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val teamIcon: ShapeableImageView = view.findViewById(R.id.team_icon)
        val name: TextView = view.findViewById(R.id.team_name)
        val notificationIcon: ImageButton = view.findViewById(R.id.notification_icon)

        internal val shakeAnimation: Animation = AnimationUtils.loadAnimation(view.context, R.anim.shake)
        var shouldNotify: Boolean = false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_team, parent, false)
        return MyTeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyTeamViewHolder, position: Int) {
        val team = teams[position]
        holder.shouldNotify = savedTeams.contains(team)

        Picasso.get()
            .load(team.iconUrl)
            .into(holder.teamIcon)

        holder.name.text = team.name
        holder.notificationIcon.let {
            if (holder.shouldNotify) {
                it.background = getDrawable(it.context, R.drawable.ic_baseline_notifications_on_24)
            } else {
                it.background = getDrawable(it.context, R.drawable.ic_baseline_notifications_off_24)
            }
        }
        holder.notificationIcon.setOnClickListener {
            if (holder.shouldNotify) {
                listener.removeTeam(team)
                holder.shouldNotify = false
                it.background = getDrawable(it.context, R.drawable.ic_baseline_notifications_off_24)
            } else {
                listener.addTeam(team)
                holder.shouldNotify = true
                it.background = getDrawable(it.context, R.drawable.ic_baseline_notifications_on_24)
                it.startAnimation(holder.shakeAnimation)
            }
        }
    }

    override fun getItemCount() = teams.size
}