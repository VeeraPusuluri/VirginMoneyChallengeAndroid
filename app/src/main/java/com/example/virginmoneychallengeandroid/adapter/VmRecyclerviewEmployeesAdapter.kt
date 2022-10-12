package com.example.virginmoneychallengeandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoneychallengeandroid.data.remote.EmployeeDetails
import com.example.virginmoneychallengeandroid.databinding.LayoutEmployeeDetailsItemBinding

class VmRecyclerviewEmployeesAdapter(val Employee:(EmployeeDetails) -> Any ) : ListAdapter<EmployeeDetails, VmRecyclerviewEmployeesAdapter.VmRecyclerviewAdapterViewHolder>(diffUtil) {

    class VmRecyclerviewAdapterViewHolder(val view: LayoutEmployeeDetailsItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(data:EmployeeDetails){
            view.employee = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VmRecyclerviewAdapterViewHolder {
        return VmRecyclerviewAdapterViewHolder(LayoutEmployeeDetailsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: VmRecyclerviewAdapterViewHolder, position: Int) {
        val currentData = getItem(position)
        holder.bind(currentData)
        holder.itemView.setOnClickListener {
            Employee(currentData)
        }
    }

    companion object diffUtil : DiffUtil.ItemCallback<EmployeeDetails>() {
        override fun areItemsTheSame(oldItem: EmployeeDetails, newItem: EmployeeDetails): Boolean  = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: EmployeeDetails, newItem: EmployeeDetails): Boolean = oldItem == newItem
    }
}