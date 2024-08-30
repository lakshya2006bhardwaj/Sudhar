package com.app.sudhar.about.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.sudhar.databinding.TeamMemberItemBinding

class TeamMemberAdapter(val onItemClick: (pos: Int, model: TeamMemberData, src: String) -> Unit) :
    ListAdapter<TeamMemberData, TeamMemberAdapter.MyViewHolder>(
        TeamMemberAdapterCallback
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding= TeamMemberItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(getItem(position))
    }

    inner class MyViewHolder(private val binding: TeamMemberItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data:TeamMemberData){

            }
    }

    object TeamMemberAdapterCallback : DiffUtil.ItemCallback<TeamMemberData>() {

        override fun areItemsTheSame(
            oldItem: TeamMemberData,
            newItem: TeamMemberData
        ): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(
            oldItem: TeamMemberData,
            newItem: TeamMemberData
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun submitList(list: MutableList<TeamMemberData>?) {
        super.submitList(list?.let { ArrayList(it) })
    }
}