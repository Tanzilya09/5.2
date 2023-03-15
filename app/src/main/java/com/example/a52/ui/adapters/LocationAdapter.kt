package com.example.a52.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a52.databinding.ItemLocationBinding
import com.example.a52.models.location.LocationModel

class LocationAdapter  : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private var list: List<LocationModel> = ArrayList()

    fun setList(list: MutableList<LocationModel>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(locationModel: LocationModel) {
            binding.txtCreated.text = locationModel.created
            binding.txtName.text = locationModel.name
            binding.txtDimension.text = locationModel.dimension
            binding.txtType.text = locationModel.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}