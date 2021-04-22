package com.example.gm_coding.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gm_coding.R
import com.example.gm_coding.model.Result

class TrackAdapter(private val results: List<Result>) :RecyclerView.Adapter<TrackAdapter.ViewHolder>(){
    private  val TAG = "SongAdapter"
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val artistNameTv: TextView
        val trackNameTv: TextView
        val releaseDateTv: TextView
        val primaryGenreNameTv: TextView
        val trackPriceTv: TextView

        init {
            artistNameTv = view.findViewById(R.id.artist_name_tv)
            trackNameTv = view.findViewById(R.id.track_name_tv)
            releaseDateTv = view.findViewById(R.id.release_date_tv)
            primaryGenreNameTv = view.findViewById(R.id.primary_genre_name_tv)
            trackPriceTv = view.findViewById(R.id.track_price_tv)
                trackPriceTv.textSize = 20F


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.song_item,
            parent,
            false
        )
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.trackPriceTv.text = results[position].collectionPrice.toString()
        holder.trackNameTv.text = results[position].trackName
       holder.artistNameTv.text = results[position].artistName
        holder.releaseDateTv.text = results[position].releaseDate
        holder.primaryGenreNameTv.text = results[position].primaryGenreName
    }

    override fun getItemCount(): Int {
        return results.size
    }
}