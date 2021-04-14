package com.example.template.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.data.model.NasaDate
import com.example.template.ui.selectPhoto.SelectPhotoFragment
import kotlinx.android.synthetic.main.date_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ItemVH>() {
    var data = listOf<NasaDate>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.date_item, parent, false)
        return ItemVH(view)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size

    inner class ItemVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: NasaDate) = with(itemView) {
            dateTxt.text = item.date
            setOnClickListener {
                val bundle = Bundle()
                bundle.putString(SelectPhotoFragment.DATE_ARG, item.date)
                it.findNavController().navigate(R.id.action_mainFragment_to_selectPhotoFragment, bundle)
            }
        }
    }
}