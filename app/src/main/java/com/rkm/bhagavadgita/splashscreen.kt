package com.rkm.bhagavadgita

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rkm.bhagavadgita.databinding.FragmentSplashscreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

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

        binding = FragmentSplashscreenBinding.inflate(layoutInflater,container,false)

        Handler(Looper.getMainLooper()).postDelayed(object:Runnable{
            override fun run() {
                findNavController().navigate(R.id.action_splashscreen2_to_homefragment)
            }
        },2000)

        return binding.root

    }


}