package com.example.music_player_sprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var resultsDTO = listOf<ResultsDTO>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callApi()

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