package com.example.a52.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a52.databinding.ItemEpisodeBinding
import com.example.a52.models.episode.EpisodeModel

class EpisodeAdapter  : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private var list: List<EpisodeModel> = ArrayList()

    fun setList(list: MutableList<EpisodeModel>){
        this.list = list
        notifyDataSetChanged()
    }

   inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(episodeModel: EpisodeModel) {
            binding.txtEpisode.text = episodeModel.episode
            binding.txtAirDate.text = episodeModel.airDate
            binding.txtCreated.text = episodeModel.created
            binding.txtName.text = episodeModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
