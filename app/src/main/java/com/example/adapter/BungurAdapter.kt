package com.example.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mylaporyukksss.R
import com.example.mylaporyukksss.databinding.ItemSitubungurBinding

class BungurAdapter(var listBungur : ArrayList<ListBungur>) : RecyclerView.Adapter<BungurAdapter.ViewHolder>() {

//    var onClick : ((ListBungur) -> Unit)? = null

    class ViewHolder(var binding: ItemSitubungurBinding):RecyclerView.ViewHolder(binding.root)  {
//        var namaBungur = view.findViewById<TextView>(R.id.name_bungur)
//        var description = view.findViewById<TextView>(R.id.DescriptionBungur)
//        var imgBungur = view.findViewById<ImageView>(R.id.img_bungur)
//        var card = view.findViewById<CardView>(R.id.crd_potensiDPDesaaa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):BungurAdapter.ViewHolder {
        var view = ItemSitubungurBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.nameBungur.text = listBungur[position].name
        holder.binding.lokasi.text = listBungur[position].lokasi
        holder.binding.DescriptionBungur.text = listBungur[position].Description
        Glide.with(holder.itemView).load(listBungur[position].img).into(holder.binding.imgBungur)

        holder.binding.crdPotensiDPDesaaa.setOnClickListener{
        var bund = Bundle()
        bund.putSerializable("databungur",listBungur[position])
            Navigation.findNavController(it).navigate(R.id.action_statistikDesaFragment_to_detailPotensiFragment,bund)

//        holder.namaBungur.text = listBungur[position].name
//        holder.description.text = listBungur[position].Description
//        holder.imgBungur.setImageResource(listBungur[position].img)
//        holder.crd.setOnClickListener{
//            onClick?.invoke(listBungur[position])
        }

    }

    override fun getItemCount(): Int {
        return listBungur.size
    }


}
