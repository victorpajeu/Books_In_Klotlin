package br.com.victorpajeu.books

import br.com.victorpajeu.books.http.BookHttp
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun SearchIsComplete() {
       val searchResult = BookHttp.searchBook("Dominando o Android")
        searchResult?.items?.forEach{volume ->
            println(volume.volumeInfo.title)
        }
    }
}
