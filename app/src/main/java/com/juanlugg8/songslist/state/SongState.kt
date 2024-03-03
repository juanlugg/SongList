package com.juanlugg8.songslist.state

sealed class SongState {
    data object TitleObligatory : SongState()
    data object Succcess : SongState()
}