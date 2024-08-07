package com.irv205.testproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irv205.testproject.databinding.RickAndMortyItemBinding
import com.irv205.testproject.domain.Character

class RickMortyAdapter :
    ListAdapter<Character, RickMortyAdapter.ViewHolder>(CharactersDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RickAndMortyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: RickAndMortyItemBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Character){
            binding.tvName.text = item.name
            binding.tvStatus.text = item.status

            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.imageCharacter)
        }
    }

}


object CharactersDiffUtils : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}