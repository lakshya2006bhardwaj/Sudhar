package com.app.sudhar.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class DashboardViewPagerAdapter(list:ArrayList<Fragment>, fm:FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fm,lifecycle) {
    private val fragmentList = list

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}