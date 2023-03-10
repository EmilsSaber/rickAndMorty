package com.example.rickandmorty.presentation.fragment.home

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.databinding.FragmentHomeBinding
import com.example.rickandmorty.presentation.base.BaseFragment
import com.example.rickandmorty.presentation.fragment.AllViewModel
import com.example.rickandmorty.presentation.utils.ViewPagerAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: AllViewModel by sharedViewModel()
    override fun inflate(layoutInflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initView() {



        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)



        binding.searchId.addTextChangedListener(object : TextWatcher {


            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                s.let {

                        lifecycleScope.launch {
                            viewModel.searchResults(it.toString(), it.toString(), it.toString())
                        }
            }

            }
        })
    }
}