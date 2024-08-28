package com.app.sudhar.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.sudhar.R
import com.app.sudhar.databinding.FragmentViewPager4Binding

class ViewPager4Fragment : Fragment() {
    private lateinit var binding:FragmentViewPager4Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentViewPager4Binding.inflate(inflater)
        return binding.root
    }
}