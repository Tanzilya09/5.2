package com.example.a52.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a52.databinding.ItemCharacterBinding
import com.example.a52.extensions.setImage
import com.example.a52.models.character.CharacterModel

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var list: List<CharacterModel> = ArrayList()

    fun setList(list: MutableList<CharacterModel>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(characterModel: CharacterModel) {
            binding.itemName.text = characterModel.name
            binding.tvFirstSeen.text = characterModel.status
            binding.tvLocation.text = characterModel.gender
            binding.itImage.setImage(characterModel.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}