package com.example.rickandmorty.presentation.fragment.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.databinding.ItemCharactersBinding
import com.example.rickandmorty.domein.model.modelCharacters.DResult

class CharactersAdapter: PagingDataAdapter<DResult, CharactersAdapter.CharactersViewHolder>(MangaModelItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CharactersViewHolder(private val binding: ItemCharactersBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(dresult: DResult) {
            binding.imageCharacters.load(dresult.image)
        }

    }
    private object MangaModelItemCallback : DiffUtil.ItemCallback<DResult>(){
        override fun areItemsTheSame(oldItem: DResult, newItem: DResult): Boolean {
            return  oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DResult, newItem: DResult): Boolean {
            return oldItem.id == newItem.id && oldItem.image == newItem.image
        }

    }
}