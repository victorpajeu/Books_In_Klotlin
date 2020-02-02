package br.com.victorpajeu.books.ui

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.victorpajeu.books.R
import br.com.victorpajeu.books.http.BookHttp
import br.com.victorpajeu.books.model.Volume
import br.com.victorpajeu.books.model.VolumeInfo
import br.com.victorpajeu.books.ui.adapter.BookAdapter
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                BookHttp.searchBook("Dominando o Android")
            }
            if (result != null) {
                val bookAdapter = BookAdapter(result.items, this@MainActivity::onVolumeClick)
                rvBooks.layoutManager = LinearLayoutManager(this@MainActivity)
                rvBooks.adapter = bookAdapter
            } else {
                //TODO erro
            }

        }
    }

    private fun onVolumeClick(volume: Volume) {
        val intencao =  Intent(this, bookDetailActivity::class.java)
        intencao.putExtra("volume", volume )
        startActivity(intent)
    }
}