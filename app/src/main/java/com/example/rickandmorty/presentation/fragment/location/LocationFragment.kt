package com.example.rickandmorty.presentation.fragment.location

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState

import com.example.rickandmorty.databinding.FragmentLocationBinding
import com.example.rickandmorty.presentation.base.BaseFragment
import com.example.rickandmorty.presentation.fragment.AllViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class LocationFragment : BaseFragment<FragmentLocationBinding>() {
    private val viewModel:AllViewModel by sharedViewModel()

    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = LocationAdapter()
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentLocationBinding {
        return FragmentLocationBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        binding.LocationRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.LocationRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }


        safeFlowGather {
            viewModel.getLocationPAging().collectLatest {
                adapter.submitData(it)
            }
        }

    }
    override fun initView() {


            safeFlowGather {

                viewModel.getSearch3.collectLatest { it ->

                    it?.let {
                        viewModel.getLocationPAging().collectPaging {
                            binding.LocationRecycler.adapter = adapter
                            adapter.submitData(it)
                        }
                    }
                }

        }
    }


}