package com.rkm.bhagavadgita.view.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rkm.bhagavadgita.R
import com.rkm.bhagavadgita.databinding.FragmentSplashscreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [splashscreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class splashscreen : Fragment() {
    lateinit var binding: FragmentSplashscreenBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSplashscreenBinding.inflate(layoutInflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed(object:Runnable{
            override fun run() {
                findNavController().navigate(R.id.action_splashscreen2_to_homefragment)
            }
        },2000)

        return binding.root

    }


}