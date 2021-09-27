package com.example.music_player_sprint

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class SongViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
    fun setData(resultsDTO: ResultsDTO){
        if (resultsDTO.artistViewUrl != null){

        }
        view.tvNameOfSong.text = resultsDTO.trackName
        view.tvartistOfSong.text = resultsDTO.artistName;
    }
}