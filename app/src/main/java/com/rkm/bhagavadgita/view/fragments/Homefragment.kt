package com.rkm.bhagavadgita.view.fragments


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.RequiresExtension

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.lifecycle.lifecycleScope


import com.rkm.bhagavadgita.adapter.homeadapter
import com.rkm.bhagavadgita.databinding.FragmentHomefragmentBinding
import com.rkm.bhagavadgita.model.Commentary
import com.rkm.bhagavadgita.model.Translation
import com.rkm.bhagavadgita.model.allchaptersdataItem
import com.rkm.bhagavadgita.model.verselistItem
import com.rkm.bhagavadgita.repositry.chapterrepo
import com.rkm.bhagavadgita.repositry.repo
import com.rkm.bhagavadgita.room.allchaptersroom
import com.rkm.bhagavadgita.room.dao
import com.rkm.bhagavadgita.room.roomdatabase
import com.rkm.bhagavadgita.room.roomdatabasechapter
import com.rkm.bhagavadgita.room.verse

import com.rkm.bhagavadgita.viewmodel.mainviewmodel

import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [homefragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homefragment : Fragment() {
   lateinit var binding: FragmentHomefragmentBinding
    val viewmodel : mainviewmodel by viewModels()
    lateinit var  chapterrepo: chapterrepo

    lateinit var chapterlist : List<allchaptersroom>
    lateinit var adapter: homeadapter





    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomefragmentBinding.inflate(layoutInflater,container,false)
            val chapterdao = roomdatabasechapter.getdbcopy(requireContext()).chapterdao()
            chapterrepo = chapterrepo(chapterdao)



       lifecycleScope.launch {


           chapterlist = chapterrepo.readchapter()




           adapter = homeadapter(chapterlist,requireContext())
           binding.homerecyclerview.adapter = adapter

       }






        return binding.root
    }





}

