package com.example.rickandmorty.presentation.fragment.episode

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.rickandmorty.databinding.FragmentEpisodeBinding
import com.example.rickandmorty.presentation.base.BaseFragment
import com.example.rickandmorty.presentation.fragment.AllViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<FragmentEpisodeBinding>() {
    private val viewModel: AllViewModel by sharedViewModel()
    private val viewModel1: EpisodeViewModel by viewModel()

    private lateinit var adapter: EpisodeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = EpisodeAdapter()
    }
    override fun inflate(layoutInflater: LayoutInflater): FragmentEpisodeBinding {
        return FragmentEpisodeBinding.inflate(layoutInflater)
    }


    override fun initListener() {

        binding.episodeRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.episodeRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }


        safeFlowGather{
            viewModel1.getEpisodePaging().collectLatest {
                adapter.submitData(it)
            }}

    }
    override fun initView() {


        safeFlowGather{
            viewModel.getSearch2.collectLatest { it ->
                it?.let {
                    viewModel.getEpisodePAging().collectPaging {
                        binding.episodeRecycler.adapter = adapter
                        adapter.submitData(it)
                    }
                }
            }
        }
    }

}