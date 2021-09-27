package com.example.music_player_sprint

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class SongViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
    fun setData(resultsDTO: ResultsDTO){
        Glide.with(view.tvImagePoster).load(resultsDTO.trackViewUrl).placeholder(R.drawable.shapeofyou).into(view.tvImagePoster)
        view.tvNameOfSong.text = resultsDTO.trackName
        view.tvartistOfSong.text = resultsDTO.artistName;
    }
}