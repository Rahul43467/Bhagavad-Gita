package com.rkm.bhagavadgita.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rkm.bhagavadgita.R

import com.rkm.bhagavadgita.databinding.RcvsingleitemBinding
import com.rkm.bhagavadgita.model.allchaptersdataItem
import com.rkm.bhagavadgita.model.verselist
import com.rkm.bhagavadgita.model.verselistItem
import com.rkm.bhagavadgita.room.allchaptersroom
import com.rkm.bhagavadgita.room.verse
import com.rkm.bhagavadgita.view.fragments.homefragmentDirections

class homeadapter(var list: List<allchaptersroom>, var context: Context): RecyclerView.Adapter<homeadapter.homeViewholder>() {

    class homeViewholder(var binding: RcvsingleitemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model: allchaptersroom,  context: Context){

            binding.name.text = model.name
            binding.des.text = model.verses_count.toString()

            binding.root.setOnClickListener {

                val action = homefragmentDirections.actionHomefragmentToChapterfragment(model.chapter_number)

                findNavController(it).navigate(action)


            }





        }






    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): homeViewholder {
        var binding = RcvsingleitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
         return homeViewholder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: homeViewholder, position: Int) {
       var currentchapterdata = list.get(position)
        holder.bind(currentchapterdata,context)

    }

}