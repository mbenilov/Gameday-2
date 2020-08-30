package com.benilov.gameday2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnNavigationItemSelectedListener(getNavigationItemSelectedListener())

        navigate(ScheduledGamesFragment.newInstance())
    }

    private fun getNavigationItemSelectedListener(): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.scheduled_tab -> {
                    navigate(ScheduledGamesFragment.newInstance())
                    true
                }
                R.id.following_tab -> {
                    navigate(MyTeamsFragment.newInstance())
                    true
                }
                R.id.news_tab -> {
                    navigate(NewsFragment.newInstance())
                    true
                }
                else -> false
            }
        }
    }

    private fun navigate(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(fragment.tag)
        transaction.commit()
    }
}
