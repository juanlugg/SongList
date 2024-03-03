package com.juanlugg8.songslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.juanlugg8.songslist.adapter.SongAdapter
import com.juanlugg8.songslist.databinding.FragmentListBinding
import com.juanlugg8.songslist.entity.Song
import com.juanlugg8.songslist.repository.ProviderSong
import com.juanlugg8.songslist.usecase.SongViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SongViewModel by viewModels()

    private lateinit var  list : MutableList<Song>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = viewModel.songList
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val adapter = SongAdapter(list){pos:Int->
            var bundle = Bundle()
            bundle.putInt("position",pos)
            parentFragmentManager.setFragmentResult("key",bundle)
            findNavController().navigate(R.id.action_ListFragment_to_detailFragment)
        }
        binding.rvList.adapter = adapter
        binding.rvList.scrollToPosition(list.size - 1)
        binding.rvList.layoutManager = LinearLayoutManager(context)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabList.setOnClickListener {
            findNavController().navigate(R.id.action_ListFragment_to_CreationFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}