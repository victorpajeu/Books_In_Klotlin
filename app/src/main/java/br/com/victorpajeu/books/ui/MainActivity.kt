package br.com.victorpajeu.books.ui

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.victorpajeu.books.R
import br.com.victorpajeu.books.http.BookHttp
import br.com.victorpajeu.books.ui.adapter.BookAdapter
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
                val bookAdapter = BookAdapter(result.items)
                rvBooks.layoutManager = LinearLayoutManager(this@MainActivity)
                rvBooks.adapter = bookAdapter
            } else {
                //TODO erro
            }

        }
        object : Thread() {
            override fun run() {
                super.run()
                val result = BookHttp.searchBook("Dominando o Android")
                runOnUiThread {
                }
            }
        }.start()
    }
}