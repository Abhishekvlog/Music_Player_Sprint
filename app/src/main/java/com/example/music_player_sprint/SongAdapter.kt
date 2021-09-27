package com.example.music_player_sprint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(private val resultsDTO: List<ResultsDTO>) : RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val resultsDTO = resultsDTO[position]
        holder.setData(resultsDTO)
    }

    override fun getItemCount(): Int {
        return resultsDTO.size
    }
}