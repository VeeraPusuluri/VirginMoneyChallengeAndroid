package com.example.virginmoneychallengeandroid.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoneychallengeandroid.data.remote.WorlSpaceDetails
import com.example.virginmoneychallengeandroid.databinding.LayoutEmployeeDetailsItemBinding
import com.example.virginmoneychallengeandroid.databinding.LayoutWorkSpacesItemBinding


class VmRecyclerviewRoomsAdapter(val Spaces:(WorlSpaceDetails) -> Unit ): ListAdapter<WorlSpaceDetails, VmRecyclerviewRoomsAdapter.VmRecyclerviewRoomsAdapterViewHolder>(diffUtil) {

    class VmRecyclerviewRoomsAdapterViewHolder(val view: LayoutWorkSpacesItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(data:WorlSpaceDetails){
            view.workspace = data
            view.maxOccupancyTv.text = data.maxOccupancy.toString()
            view.occupiedWorkspacesTv.text = data.isOccupied.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VmRecyclerviewRoomsAdapterViewHolder {
        return VmRecyclerviewRoomsAdapterViewHolder(LayoutWorkSpacesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VmRecyclerviewRoomsAdapterViewHolder, position: Int) {
        val currentData = getItem(position)
        holder.bind(currentData)
        holder.itemView.setOnClickListener {
        }
    }

    companion object diffUtil : DiffUtil.ItemCallback<WorlSpaceDetails>() {
        override fun areItemsTheSame(oldItem: WorlSpaceDetails, newItem: WorlSpaceDetails): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: WorlSpaceDetails, newItem: WorlSpaceDetails): Boolean = oldItem == newItem
    }
}