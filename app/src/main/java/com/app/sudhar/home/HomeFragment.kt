package com.app.sudhar.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.app.sudhar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        initSetViews()
        initClickListener()
    }
    private fun initSetViews(){
        setViewPagerAdapter()
    }
    private fun initClickListener(){

    }
    private fun setViewPagerAdapter()=binding.apply{
        val fragmentList = arrayListOf(
            Viewpager1Fragment(),
            Viewpager2Fragment(),
            Viewpager3Fragment(),
            ViewPager4Fragment()
        )
        viewPager.isUserInputEnabled = true
        val adapter = HomeViewPagerAdapter(fragmentList,childFragmentManager,lifecycle)
        viewPager.adapter = adapter
        viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
    }
}