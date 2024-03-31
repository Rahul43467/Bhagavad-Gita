package com.rkm.bhagavadgita.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rkm.bhagavadgita.R
import com.rkm.bhagavadgita.adapter.chapteradapter
import com.rkm.bhagavadgita.adapter.homeadapter
import com.rkm.bhagavadgita.databinding.FragmentChapterfragmentBinding
import com.rkm.bhagavadgita.databinding.FragmentHomefragmentBinding
import com.rkm.bhagavadgita.repositry.chapterrepo
import com.rkm.bhagavadgita.repositry.repo
import com.rkm.bhagavadgita.room.allchaptersroom
import com.rkm.bhagavadgita.room.roomdatabase
import com.rkm.bhagavadgita.room.roomdatabasechapter
import com.rkm.bhagavadgita.room.verse
import com.rkm.bhagavadgita.viewmodel.mainviewmodel
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [chapterfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class chapterfragment : Fragment() {
    // TODO: Rename and change types of parameters
    val chapternumberargs by navArgs<chapterfragmentArgs>()
    val viewmodel : mainviewmodel by viewModels()
    lateinit var  repo: repo
    lateinit var binding : FragmentChapterfragmentBinding
    lateinit var verselist : List<verse>
    lateinit var adapter: chapteradapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChapterfragmentBinding.inflate(layoutInflater,container,false)
        val dao = roomdatabase.getdbcopy(requireContext()).chapterdao()
        repo = repo(dao)



        lifecycleScope.launch {


            verselist = repo.readchapterverse(chapternumberargs.data)




            adapter = chapteradapter(verselist,requireContext())
            binding.chapterrcv.adapter = adapter

        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,true,{

            if (true){

                findNavController().navigate(R.id.action_chapterfragment_to_homefragment)

            }else{
                requireActivity().onBackPressed()
            }
        })






        return binding.root
    }

}