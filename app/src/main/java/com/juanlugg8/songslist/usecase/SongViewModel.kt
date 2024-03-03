package com.juanlugg8.songslist.usecase

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juanlugg8.songslist.entity.Song
import com.juanlugg8.songslist.repository.ProviderSong
import com.juanlugg8.songslist.state.SongState

class SongViewModel : ViewModel() {
    val songList = ProviderSong.songList
    val title = MutableLiveData<String>()
    val album = MutableLiveData<String>()
    val author = MutableLiveData<String>()

    private val state = MutableLiveData<SongState>()
    fun validate() {
        when {
            TextUtils.isEmpty(title.value) -> state.value = SongState.TitleObligatory
            else -> state.value = SongState.Succcess
        }
    }

    fun createSong() {
        val listAuthor = author.value?.split(", ")
        val song = Song(title.value!!, album.value!!, listAuthor!!)
        songList.add(song)
    }

    fun getState(): LiveData<SongState> {
        return state;
    }
}