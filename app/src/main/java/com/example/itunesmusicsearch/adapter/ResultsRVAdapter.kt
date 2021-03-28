package com.example.itunesmusicsearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itunesmusicsearch.R
import com.example.itunesmusicsearch.api.models.Result
import java.util.concurrent.TimeUnit

class ResultsRVAdapter: RecyclerView.Adapter<ResultsRVAdapter.ViewHolder>() {

    private val seachResults: ArrayList<Result> = ArrayList()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val trackName: TextView = itemView.findViewById(R.id.tvTrackName)
        val artistName: TextView = itemView.findViewById(R.id.tvArtistName)
        val trackImage: ImageView = itemView.findViewById(R.id.ivTrackImage)
        val trackGenre: TextView = itemView.findViewById(R.id.tvTrackGenre)
        val trackDuration: TextView = itemView.findViewById(R.id.tvTrackDuration)
        
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_result_rv_item, parent, false)
        val searchViewHolder = ViewHolder(view)
        return searchViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = seachResults[position]
        holder.trackName.text = currentItem.trackName
        holder.artistName.text = currentItem.artistName
        holder.trackGenre.text = currentItem.primaryGenreName
        holder.trackDuration.text = "${inMinutes(currentItem.trackTimeMillis!!)} min"
        Glide.with(holder.itemView.context).load(currentItem.artworkUrl100).into(holder.trackImage)
    }

    override fun getItemCount(): Int {
        return seachResults.size
    }

    fun updateRV(newRVResults: List<Result>) {
        //clearing earlier results
        seachResults.clear()
        //adding new results
        seachResults.addAll(newRVResults)
        //updating the recyclerview with changes
        notifyDataSetChanged()
    }

    fun inMinutes(milliseconds: Long): String {
        val minutes = milliseconds/ 1000/ 60
        val seconds = milliseconds/ 1000% 60
        val result = "${minutes}:${seconds}"
        return result
    }
}