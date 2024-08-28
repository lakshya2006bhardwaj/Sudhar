package com.app.sudhar.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.app.sudhar.databinding.FragmentDashboardBinding
import com.app.sudhar.home.HomeViewPagerAdapter
import com.app.sudhar.home.ViewPager4Fragment
import com.app.sudhar.home.Viewpager1Fragment
import com.app.sudhar.home.Viewpager2Fragment
import com.app.sudhar.home.Viewpager3Fragment


class DashboardFragment : Fragment() {
    private lateinit var binding:FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}