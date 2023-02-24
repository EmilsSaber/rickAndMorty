package com.example.rickandmorty.presentation.fragment.characters
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.FragmentCharactersBinding
import com.example.rickandmorty.presentation.base.BaseFragment
import com.example.rickandmorty.presentation.fragment.AllViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    private val viewModel1: CharactersViewModel by viewModel()
    private val viewModel: AllViewModel by sharedViewModel()
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
        safeFlowGather{
            viewModel1.getCharacterPaging().collectLatest {
                adapter.submitData(it)

            }}

    }

    override fun initView() {
        safeFlowGather{

            viewModel.getSearch.collectLatest { it ->
                it?.let {
                    viewModel.getCharactersPaging().collectPaging {
                        binding.charactersRecycler.adapter = adapter
                        adapter.submitData(it)
                    }
                }
            }

        }
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentCharactersBinding {
        return FragmentCharactersBinding.inflate(layoutInflater)
    }

}