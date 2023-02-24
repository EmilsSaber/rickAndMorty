package com.example.rickandmorty.presentation.fragment.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.databinding.ItemCharactersBinding
import com.example.rickandmorty.domein.model.modelCharacters.Result

class CharactersAdapter: PagingDataAdapter<Result, CharactersAdapter.CharactersViewHolder>(MangaModelItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CharactersViewHolder(private val binding: ItemCharactersBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Result) {
            binding.imageCharacter.load(result.image)
            binding.nameCharacter.text = result.name
            binding.tvLocation.text = result.location.name
            binding.tvCreate.text = result.created
            binding.tvUtils.text = result.status
        }

    }
    private object MangaModelItemCallback : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return  oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id && oldItem.image == newItem.image
        }

    }
}