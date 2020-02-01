package br.com.victorpajeu.books.ui.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.victorpajeu.books.R
import br.com.victorpajeu.books.model.Volume
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter(
   val list: List<Volume>
): RecyclerView.Adapter<BookAdapter.BookVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookVH {
       val view =LayoutInflater.from(parent.context)
            .inflate(R. layout.item_book, parent, false)
        return BookVH(view)
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: BookVH, position: Int) {
        val volume = list[position]
        holder.run{
            txtTitle.text = volume.volumeInfo.title
            txtAuthor.text = volume.volumeInfo.authors?.joinToString () ?: "Nenhum"
            txtPages.text = volume.volumeInfo.pageCount?.toString()
        }
    }

    inner class BookVH(parent:View)
        : RecyclerView.ViewHolder(parent){
        val imgCover: ImageView = parent.imgCover
        val txtTitle:TextView = parent.txtTitle
        val txtAuthor:TextView = parent.txtAuthor
        val txtPages:TextView = parent.txtPages
    }
}
