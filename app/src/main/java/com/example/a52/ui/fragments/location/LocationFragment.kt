package com.example.a52.ui.fragments.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a52.databinding.FragmentLocationsBinding
import com.example.a52.ui.adapters.LocationAdapter


class LocationFragment : Fragment() {
    private var viewModel: LocationViewModel? =  null
    private lateinit var binding: FragmentLocationsBinding
    private val locationAdapter = LocationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LocationViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserves()
    }

    private fun initialize() {
        binding.rvLocation.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    private fun setupObserves() {
        viewModel?.fetchLocation()?.observe(viewLifecycleOwner) {
            locationAdapter.setList(it.results)
        }
    }

}