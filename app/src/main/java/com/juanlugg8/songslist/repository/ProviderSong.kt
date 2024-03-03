package com.juanlugg8.songslist.repository

import com.juanlugg8.songslist.entity.Song

class ProviderSong private constructor(){
    companion object{
        var songList : MutableList<Song> = mutableListOf(
            Song("Bemaste", "Portales", listOf("Tiago PZK")),
            Song("Media Luna", "Estrella", listOf("Mora")),
            Song("She Don't Give a Fo", "She Don't Give a Fo", listOf("Duki","KHEA")),
            Song("No soy Eterno", "en dormir sin Madrid", listOf("Bizarrap", "Milo j")),
            Song("22", "Y3Y2", listOf("Rojuu")),
            Song("Feelings", "V", listOf("Maroon 5")),
            Song("CON UN BESO", "SEROTONINA", listOf("KHEA")),
            Song("Siempre", "Lluvia: Rain City Vol.2", listOf("3AM")),
            Song("Morocha", "Morocha", listOf("Milo j")),
            Song("NO DA MÁS", "EL AFTER DEL AFTER", listOf("YSY A, Duki")),
            )
    }
}