package com.example.template.ui.selectPhoto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.data.model.NasaPhoto
import com.example.template.ui.showPhoto.PhotoFragment
import kotlinx.android.synthetic.main.select_photo_item.view.*

class SelectPhotoAdapter() : RecyclerView.Adapter<SelectPhotoAdapter.ItemVH>() {
    var data = listOf<NasaPhoto>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.select_photo_item, parent, false)
        return ItemVH(view)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size

    inner class ItemVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: NasaPhoto) = with(itemView) {
            dateText.text = item.date
            setOnClickListener {
                val bundle = Bundle()
                bundle.putString(PhotoFragment.PHOTO_ARG, item.getImageUrl())
                it.findNavController().navigate(R.id.action_selectPhotoFragment_to_showPhotoFragment, bundle)
            }
        }
    }
}