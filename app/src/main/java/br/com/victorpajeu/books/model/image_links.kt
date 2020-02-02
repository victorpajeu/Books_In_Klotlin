package br.com.victorpajeu.books.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class image_links(
    val smallThumbnail: String,
    val thumbnail: String
): Parcelable