package com.example.a52.ui.fragments.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a52.databinding.FragmentCharactersBinding
import com.example.a52.ui.adapters.CharacterAdapter


class CharacterFragment : Fragment() {

    private var viewModel: CharacterViewModel? = null
    private lateinit var binding: FragmentCharactersBinding
    private val characterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserves()
    }

    private fun initialize() {
        binding.rvCharacter.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    private fun setupObserves() {
        viewModel?.fetchCharacters()?.observe(viewLifecycleOwner) {
            characterAdapter.setList(it.results)
        }
    }

}