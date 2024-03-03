package com.juanlugg8.songslist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.juanlugg8.songslist.R
import com.juanlugg8.songslist.entity.Song
import com.juanlugg8.songslist.utils.maxLength

class SongAdapter(val songs: MutableList<Song>, val onClick : (pos : Int) -> Unit) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var title: TextView = v.findViewById(R.id.titleSong)
        var album: TextView = v.findViewById(R.id.albumSong)
        var author: TextView = v.findViewById(R.id.authorSong)
        var cvSong: CardView = v.findViewById(R.id.cvSong)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_song_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songs[position]
        holder.title.text = maxLength(song.title)
        holder.album.text = maxLength(song.album)
        holder.author.text = maxLength(song.author.toString())

        holder.cvSong.setOnClickListener {
            onClick(position)

        }
    }

    override fun getItemCount(): Int {
        return songs.size
    }


}