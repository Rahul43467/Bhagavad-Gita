package com.rkm.bhagavadgita.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.rkm.bhagavadgita.R
import com.rkm.bhagavadgita.adapter.chapteradapter
import com.rkm.bhagavadgita.databinding.FragmentChapterfragmentBinding
import com.rkm.bhagavadgita.databinding.FragmentDetailBinding
import com.rkm.bhagavadgita.repositry.repo
import com.rkm.bhagavadgita.room.roomdatabase
import com.rkm.bhagavadgita.room.verse
import com.rkm.bhagavadgita.viewmodel.mainviewmodel
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [detailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class detailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    val detailnumbers by navArgs<detailFragmentArgs>()
    lateinit var binding: FragmentDetailBinding
    val viewmodel : mainviewmodel by viewModels()
    lateinit var  repo: repo
    lateinit var verse : verse
    lateinit var adapter: chapteradapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        val dao = roomdatabase.getdbcopy(requireContext()).chapterdao()
        repo = repo(dao)



        lifecycleScope.launch {


            verse = repo.readsingleverse(detailnumbers.chapter,detailnumbers.versenumber)

            binding.apply {

                a.text = verse.text
                b.text = verse.id.toString()
                c.text = verse.verse_number.toString()
                d.text = verse.chapter_number.toString()
                e.text = verse.commentaries[0].description
                f.text = verse.commentaries[1].description
                g.text = verse.translations[2].description
                g.text = verse.translations[0].description
                g.text = verse.translations[1].description
            }




        }






        return binding.root
    }

}