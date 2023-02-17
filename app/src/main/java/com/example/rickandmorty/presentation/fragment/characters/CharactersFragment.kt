package com.example.rickandmorty.presentation.fragment.characters

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.FragmentCharactersBinding
import com.example.rickandmorty.presentation.base.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    private val viewModel: CharactersViewModel by viewModel()
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            adapter = CharactersAdapter()
    }


    override fun initListener() {
        binding.charactersRecycler.layoutManager = LinearLayoutManager(context)
        binding.charactersRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.charactersRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }

        lifecycleScope.launch {
            viewModel.fetchFoo().collectLatest{
                adapter.submitData(it)
            }
        }
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentCharactersBinding {
        return FragmentCharactersBinding.inflate(layoutInflater)
    }

}