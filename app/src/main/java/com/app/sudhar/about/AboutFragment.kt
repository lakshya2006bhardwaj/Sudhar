package com.app.sudhar.about

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.app.sudhar.R
import com.app.sudhar.about.adapter.TeamMemberAdapter
import com.app.sudhar.about.adapter.TeamMemberData
import com.app.sudhar.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding
    private lateinit var teamMemberAdapter:TeamMemberAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        initSetViews()
        initCickListner()
        setTeamRecyclerView()
    }


    private fun initSetViews() = binding.apply {
        val spannable = SpannableString(tvVision.text)
        spannable.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            0, // start
            6, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            11, // start
            18, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        tvVision.text = spannable

        val our = SpannableString(tvOur.text)
        our.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            4, // start
            10, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        tvOur.text = our

        val mission = SpannableString(tvmission.text)
        mission.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            4, // start
            11, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        tvmission.text = mission

        val stories = SpannableString(tvstories.text)
        stories.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            4, // start
            11, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
       tvstories.text = stories

        val team = SpannableString(tvourTeam.text)
        team.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            4, // start
            8, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        tvourTeam.text = team

        val sustainable = SpannableString(sustainableFuture.text)
        sustainable.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            4, // start
            11, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        sustainable.setSpan( ForegroundColorSpan(ContextCompat.getColor(requireContext(),
            R.color.parrotGreen
        )), 4, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        sustainable.setSpan( RelativeSizeSpan(1.5f), 4, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        sustainableFuture.text = sustainable


    }

    private fun initCickListner() {

    }

    private fun setTeamRecyclerView() {
        teamMemberAdapter=TeamMemberAdapter{pos,data,src->
            onItemClick(pos,data,src)
        }
        binding.rvTeamMember.adapter = teamMemberAdapter
        teamMemberAdapter.submitList(arrayListOf(TeamMemberData("Khushi","hdvghvjv"),TeamMemberData("Khushi","hdvghvjv"),TeamMemberData("Khushi","hdvghvjv"),TeamMemberData("Khushi","hdvghvjv"),TeamMemberData("Khushi","hdvghvjv")))
    }

    private fun onItemClick(pos: Int, data: TeamMemberData, src: String) {

    }


}