package br.com.victorpajeu.books.model

data class Volume(
    val id: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)