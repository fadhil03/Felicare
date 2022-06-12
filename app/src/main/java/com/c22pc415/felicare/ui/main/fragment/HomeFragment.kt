package com.c22pc415.felicare.ui.main.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.c22pc415.felicare.databinding.FragmentHomeBinding
import com.c22pc415.felicare.ui.healthcheck.HealthCheckActivity
import com.c22pc415.felicare.ui.history.HistoryActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupView(){
        binding.btnStartcheck.setOnClickListener(){
            val intentToHealt = Intent(activity, HealthCheckActivity::class.java)
            startActivity(intentToHealt)
        }
        binding.seeMore.setOnClickListener(){
            val intentToHistory = Intent(activity, HistoryActivity::class.java)
            startActivity(intentToHistory)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}