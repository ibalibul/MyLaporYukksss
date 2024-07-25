package com.example.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.ResponseDataPengaduanItem
import com.example.mylaporyukksss.R
import com.example.mylaporyukksss.databinding.ItemBeritaBinding

class BeritaAdapter(val listBerita: List<ResponseDataPengaduanItem>?): RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

//    var onClick :((ListBerita)-> Unit)? = null

    class ViewHolder(var binding: ItemBeritaBinding):RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaAdapter.ViewHolder {
        val view = ItemBeritaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.namePlace.text = listBerita!![position].judul
        holder.binding.lokasi.text = listBerita[position].lokasi
        holder.binding.Descriptionplace.text = listBerita[position].deskripsi
        holder.binding.notlp.text = listBerita[position].notlp.toString()
        holder.binding.tglPengaduan.text = listBerita[position].tanggal
        Glide.with(holder.itemView).load(listBerita[position].foto).into(holder.binding.imgPlace)

        holder.binding.cvItemBerita.setOnClickListener{
            var bundlee = Bundle()
            bundlee.putSerializable("dataBerita",listBerita[position])
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailPengaduanFragment,bundlee)
        }

//        holder.binding.imgPlace.setImageResource(listBerita[position].image)
//        holder.binding.cvItemBerita.setOnClickListener{
//            onClick?.invoke(listBerita[position])
//        }
    }


    override fun getItemCount(): Int {
        return listBerita!!.size
    }
}