package com.cads.mydestinations

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cads.mydestinations.network.Dest

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Dest>?) {
    val adapter = recyclerView.adapter as DestinationListAdapter
    adapter.submitList(data)
}