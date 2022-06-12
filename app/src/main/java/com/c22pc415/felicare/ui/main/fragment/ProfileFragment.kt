package com.c22pc415.felicare.ui.main.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.c22pc415.felicare.databinding.FragmentProfileBinding
import com.c22pc415.felicare.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initFirebaseAuth() {
        auth = FirebaseAuth.getInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initFirebaseAuth()
        setupView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupView(){
        //val btnLogout:Button = view.findViewById(R.id.btn_logout)
        binding.btnLogout.setOnClickListener(){
            auth.signOut()
            //startActivity(Intent(this, LoginActivity::class.java))
            val `in` = Intent(activity, LoginActivity::class.java)
            startActivity(`in`)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
