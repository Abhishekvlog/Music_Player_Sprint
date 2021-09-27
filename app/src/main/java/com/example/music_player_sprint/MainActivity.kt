package com.example.music_player_sprint

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
//    private val serviceConnection : ServiceConnection = object :ServiceConnection{
//        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
//            val getMusicService = p1 as MusicService.ServiceBinder
//            val service = ServiceBinder.getMusicService()
//
//
//
//        }
//
//        override fun onServiceDisconnected(p0: ComponentName?) {
//            TODO("Not yet implemented")
//        }
//
//    }
    private var resultsDTO = listOf<ResultsDTO>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callApi()
//        btnPlay.setOnClickListener {
//            val intent = Intent(MainActivity , MusicService::class.java)
//            ServiceBinder(intent , serviceConnection , Context.BIND_AUTO_CREATE)
//
//
//        }

    }


    private fun callApi() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getSongDetail(1).enqueue(object  : Callback<List<ResponseDTO>>{
            override fun onResponse(
                call: Call<List<ResponseDTO>>,
                response: Response<List<ResponseDTO>>
            ) {
                response.body()
                setRecyclerView()
            }

            override fun onFailure(call: Call<List<ResponseDTO>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun setRecyclerView() {
        val songAdapter = SongAdapter(resultsDTO)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.adapter= songAdapter
        recyclerView.layoutManager = linearLayoutManager
    }
}