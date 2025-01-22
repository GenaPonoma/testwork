package com.example.testwork.ui.dashboard

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testwork.data.Bin
import com.example.testwork.databinding.ItemHistoryViewBinding

class HistoryAdapter() :
    ListAdapter<Bin, HistoryAdapter.HistoryViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding =
            ItemHistoryViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

        val item = getItem(position)
        Log.d("HistoryAdapter", "onBindViewHolder: $item")
        with(holder.binding) {
            bankTextView.text = item.bank?.name.toString()
            brandTextView.text = item.brand.toString()
            countryTextView.text = item.country.name.toString()
            schemeTextView.text = item.scheme.toString()
        }
    }


    class HistoryViewHolder(val binding: ItemHistoryViewBinding) :
        RecyclerView.ViewHolder(binding.root)


    class DiffCallback : DiffUtil.ItemCallback<Bin>() {
        override fun areItemsTheSame(oldItem: Bin, newItem: Bin): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Bin, newItem: Bin): Boolean {
            return oldItem == newItem
        }
    }
}