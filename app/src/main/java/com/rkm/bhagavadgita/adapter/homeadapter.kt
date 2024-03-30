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
import com.rkm.bhagavadgita.room.allchaptersroom

class homeadapter(var list: List<allchaptersroom>, var context: Context): RecyclerView.Adapter<homeadapter.homeViewholder>() {

    class homeViewholder(var binding: RcvsingleitemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model: allchaptersroom,  context: Context){

            binding.name.text = model.name
            binding.des.text = model.name_meaning

            binding.root.setOnClickListener {

                move(it)


            }





        }

        private fun move(it: View?) {
            if (it != null) {
                findNavController(it).navigate(R.id.action_homefragment_to_chapterfragment)
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