package com.example.virginmoneychallengeandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoneychallengeandroid.R
import com.example.virginmoneychallengeandroid.data.WorlSpaceDetails
import com.example.virginmoneychallengeandroid.databinding.LayoutWorkSpacesItemBinding


class VmRecyclerviewRoomsAdapter(val Spaces:(WorlSpaceDetails) -> Unit ): ListAdapter<WorlSpaceDetails, VmRecyclerviewRoomsAdapter.VmRecyclerviewRoomsAdapterViewHolder>(diffUtil) {

    class VmRecyclerviewRoomsAdapterViewHolder(val view: LayoutWorkSpacesItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(data: WorlSpaceDetails){
            view.idWorkspacesTv.text =view.root.context.getString(R.string.id, data.id)
            view.maxOccupancyTv.text = view.root.context.getString(R.string.max_occupency,data.maxOccupancy.toString())
            view.occupiedWorkspacesTv.text = view.root.context.getString(R.string.occupied,data.isOccupied.toString())
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