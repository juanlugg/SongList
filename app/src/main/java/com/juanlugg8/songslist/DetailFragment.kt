package com.juanlugg8.songslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.viewModels
import com.juanlugg8.songslist.databinding.FragmentDetailBinding
import com.juanlugg8.songslist.entity.Song
import com.juanlugg8.songslist.usecase.SongViewModel
import com.juanlugg8.songslist.utils.maxLength


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SongViewModel by viewModels()

    private lateinit var list: MutableList<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = viewModel.songList
        parentFragmentManager.setFragmentResultListener("key", this,
            FragmentResultListener { _, result ->
                val pos: Int = result.getInt("position")
                val song = list[pos]
                binding.tvTitleData.text = song.title
                binding.tvAlbumData.text = song.album
                binding.tvAuthorData.text = song.author.toString()
            })
    }
}