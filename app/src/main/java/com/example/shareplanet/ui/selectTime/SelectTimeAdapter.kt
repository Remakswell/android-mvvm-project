package com.example.shareplanet.ui.selectTime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.shareplanet.R
import com.example.shareplanet.data.model.NasaPhoto
import kotlinx.android.synthetic.main.time_item.view.*

class SelectTimeAdapter() : RecyclerView.Adapter<SelectTimeAdapter.ItemVH>() {
    var data = listOf<NasaPhoto>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.time_item, parent, false)
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
                val photoUrlAction = SelectTimeFragmentDirections.actionSelectPhotoFragmentToShowPhotoFragment(item.getImageUrl())
                it.findNavController().navigate(photoUrlAction)
            }
        }
    }
}