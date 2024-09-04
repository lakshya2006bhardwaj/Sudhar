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
    private lateinit var teamMemberAdapter: TeamMemberAdapter

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
        sustainable.setSpan(
            ForegroundColorSpan(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.parrotGreen
                )
            ), 4, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        sustainable.setSpan(RelativeSizeSpan(1.5f), 4, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        sustainableFuture.text = sustainable


    }

    private fun initCickListner() {

    }

    private fun setTeamRecyclerView() {
        teamMemberAdapter = TeamMemberAdapter { pos, data, src ->
            onItemClick(pos, data, src)
        }
        binding.rvTeamMember.adapter = teamMemberAdapter
        teamMemberAdapter.submitList(
            arrayListOf(
                TeamMemberData(
                    "Khushi Pandit\n" +
                            "UI/UX Designer",
                    "Design is not just about aesthetics;\n it's about creating experiences that resonate with people. Working on Sudha has allowed me to design a platform that is not only functional but also user-friendly, ensuring our message reaches and impacts as many people as possible."
                ),
                TeamMemberData("Krati Gupta\n" +
                        "Project Coordinator &\n" +
                        "Quality Assurance", "Coordinating the SUDHAR project has been a journey of growth and learning. Every step, from ideation to implementation, has taught me the power of teamwork and dedication. Together, we’re not just building a platform; we’re building a better future."),
                TeamMemberData("Krishan Pratap Singh\n" +
                        "Lead Developer", "Building the future, one line of code at a time. Being a part of the SUDHAR project has shown me how technology can truly make a difference in the world. Every challenge we overcome brings us one step closer to a more sustainable planet."),
                TeamMemberData("Lakshya Bharadwaj\n" +
                        "Lead Developer", "Turning ideas into code has always been my passion. As the Lead Developer for SUDHAR, I've had the opportunity to shape the core of our platform, ensuring it’s robust, scalable, and ready to make an impact. Every feature we build brings us closer to helping others understand their carbon footprint."),
                TeamMemberData("Mayank Gupta\n" +
                        "Data Analyst ", "Data tells the story of our planet, and I'm proud to be part of a project that listens. Analyzing the carbon footprint data for Sudha has deepened my understanding of the environmental impact we can address through informed decisions."),
                TeamMemberData("Kumar Satyam\n" +
                        "Research Specialist ","Research is the foundation of any impactful project. Diving into the environmental issues that Sudha aims to address has been eye-opening and motivating. I'm excited to see how our work can drive positive change.")
            )
        )
    }

    private fun onItemClick(pos: Int, data: TeamMemberData, src: String) {

    }


}