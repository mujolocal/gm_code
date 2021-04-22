package com.example.gm_coding.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gm_coding.databinding.SongItemBinding
import com.example.gm_coding.model.Result

class TrackAdapter(
    private val results: List<Result>
) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = TrackViewHolder(
        SongItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(
        holder: TrackViewHolder, position: Int
    ) = with(holder.binding) { track = results[position] }

    override fun getItemCount() = results.size

    class TrackViewHolder(val binding: SongItemBinding) : RecyclerView.ViewHolder(binding.root)
}