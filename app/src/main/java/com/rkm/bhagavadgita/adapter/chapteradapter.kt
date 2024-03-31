package com.rkm.bhagavadgita.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.rkm.bhagavadgita.databinding.RcvsingleitemBinding
import com.rkm.bhagavadgita.model.verselist
import com.rkm.bhagavadgita.room.allchaptersroom
import com.rkm.bhagavadgita.room.verse
import com.rkm.bhagavadgita.view.fragments.chapterfragmentDirections
import com.rkm.bhagavadgita.view.fragments.homefragmentDirections

class chapteradapter(var list: List<verse>, var context: Context): RecyclerView.Adapter<chapteradapter.chapterviewholder>() {

    class chapterviewholder(var binding: RcvsingleitemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model: verse, context: Context){

            binding.name.text = model.text
            binding.des.text = model.commentaries[0].description

            binding.root.setOnClickListener {

                val action = chapterfragmentDirections.actionChapterfragmentToDetailFragment(model.chapter_number,model.verse_number)

               Navigation.findNavController(it).navigate(action)


            }





        }






    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chapterviewholder {
        var binding = RcvsingleitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return chapterviewholder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: chapterviewholder, position: Int) {
        var currentchapterdata = list.get(position)
        holder.bind(currentchapterdata,context)

    }

}