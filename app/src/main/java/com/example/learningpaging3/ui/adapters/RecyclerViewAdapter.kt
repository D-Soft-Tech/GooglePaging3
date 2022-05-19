package com.example.learningpaging3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.learningpaging3.databinding.CharDataRvItemLayoutBinding
import com.example.learningpaging3.model.CharacterData
import javax.inject.Inject

class RecyclerViewAdapter @Inject constructor() :
    PagingDataAdapter<CharacterData, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {

    class MyViewHolder(val itemBinding: CharDataRvItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(characterData: CharacterData) {
            itemBinding.apply {
                charData = characterData
                executePendingBindings()
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = CharDataRvItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(inflater)
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<CharacterData>() {
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean =
            oldItem.name == newItem.name
    }
}
