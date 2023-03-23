package com.example.a52.ui.fragments.episode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a52.databinding.FragmentEpisodesBinding
import com.example.a52.ui.adapters.EpisodeAdapter


class EpisodeFragment : Fragment() {

    private var viewModel: EpisodeViewModel? = null
    private lateinit var binding: FragmentEpisodesBinding
    private val episodeAdapter = EpisodeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[EpisodeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpObserves()
    }

    private fun initialize() {
        binding.rvEpisode.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    private fun setUpObserves() {
        viewModel?.fetchEpisode()?.observe(viewLifecycleOwner) {
            episodeAdapter.setList(it.results)
        }
    }

}
