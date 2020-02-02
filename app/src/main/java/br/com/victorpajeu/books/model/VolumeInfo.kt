package br.com.victorpajeu.books.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VolumeInfo(
    val title : String,
    val description: String,
    val authors: List<String>?,
    val publisher: String,
    val publishedDate: String,
    val pageCount: Int?,
    val imageLinks: image_links?
):Parcelable