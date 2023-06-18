package com.cads.mydestinations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cads.mydestinations.databinding.ItemDestinationBinding
import com.cads.mydestinations.network.Dest

class DestinationListAdapter: ListAdapter<Dest, DestinationListAdapter.DestinationListViewHolder>(DiffCallback) {

    class DestinationListViewHolder(
        private var binding: ItemDestinationBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(destination: Dest) {
            binding.dest= destination
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<Dest>() {
        override fun areItemsTheSame(oldItem: Dest, newItem: Dest): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Dest, newItem: Dest): Boolean {
            return oldItem.city == newItem.city
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DestinationListViewHolder {
        return DestinationListViewHolder(
            ItemDestinationBinding.inflate(LayoutInflater.from(parent.context))
        )
    }


    override fun onBindViewHolder(holder: DestinationListViewHolder, position: Int) {
        val dest = getItem(position)
        holder.bind(dest)
    }

}