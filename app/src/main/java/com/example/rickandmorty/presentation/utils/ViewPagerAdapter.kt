package com.example.rickandmorty.presentation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.rickandmorty.presentation.fragment.characters.CharactersFragment
import com.example.rickandmorty.presentation.fragment.episode.EpisodeFragment
import com.example.rickandmorty.presentation.fragment.location.LocationFragment


class ViewPagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm){
    private val COUNT = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CharactersFragment()
            1 -> EpisodeFragment()
            2-> LocationFragment()
            else -> CharactersFragment()
        }
    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Персонажи"
            1 -> return "Эпизод"
            2 -> return "Локации"
        }
        return ""
    }

}
