package com.benilov.gameday2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benilov.gameday2.models.Team
import com.benilov.gameday2.models.Teams
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository constructor() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val webService = retrofit.create(WebService::class.java)

    fun getTeams(): LiveData<Teams> {
        val data = MutableLiveData<Teams>()
        webService.getTeams().enqueue(object : Callback<Teams> {
            override fun onResponse(call: Call<Teams>, response: Response<Teams>) {
                response.body()?.teams?.forEach {
                    Log.i(TAG, it.name)
                }
            }

            override fun onFailure(call: Call<Teams>, t: Throwable) {
                Log.e(TAG, "Unable to retrieve teams: " + t.message)
            }

        })
        return data
    }

    companion object {
        private const val BASE_URL = "https://www.thesportsdb.com/"
        private const val TAG = "Repository"
    }
}