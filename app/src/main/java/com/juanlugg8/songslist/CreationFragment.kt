package com.juanlugg8.songslist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.juanlugg8.songslist.databinding.FragmentCreationBinding
import com.juanlugg8.songslist.state.SongState
import com.juanlugg8.songslist.usecase.SongViewModel

class CreationFragment : Fragment() {

    private var _binding: FragmentCreationBinding? = null

    private val binding get() = _binding!!

    val viewModel: SongViewModel by viewModels()

    inner class TextWatcherSong(val til  : TextInputLayout): TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            til.isErrorEnabled = false
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreationBinding.inflate(inflater, container, false)
        binding.viewmodel = this.viewModel
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getState().observe(viewLifecycleOwner) {
            when (it) {
                SongState.TitleObligatory -> {binding.tilTitle.error = "Title is Obligatory"}
                SongState.Succcess -> {
                    Toast.makeText(requireContext(), "SONG ADDED", Toast.LENGTH_SHORT).show()
                    viewModel.createSong()
                    findNavController().popBackStack()
                }
            }
        }

        binding.tieTitle.addTextChangedListener {
            TextWatcherSong(binding.tilTitle)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}