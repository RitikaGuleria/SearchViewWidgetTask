package com.example.googlesearchviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.googlesearchviewtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var searchView: SearchView
    lateinit var listview: ListView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView=findViewById(R.id.searchview)
        listview=findViewById(R.id.listview)
//        imageView=findViewById(R.id.imageview)
//        imageView.setImageResource(R.drawable.goggle)
//
//        val searchIcon = ContextCompat.getDrawable(this, R.drawable.goggle)
//        searchView.setIconifiedByDefault(false)
//        searchView.setIconified(false)
//        searchView.setQuery("", false)
//        searchView.setIconifiedByDefault(true)
//        searchView.setIconified(true)
//        val magImage = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
//        magImage.setImageDrawable(searchIcon)


        val names= arrayOf("Android","Kotlin","Java","C++","C","Ruby","Python","Javascript","HTML","CSS")
        val adapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,names)
        listview.adapter=adapter

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
//                webView.loadUrl("https://www.google.com/search?q="+searchView.getQuery())
                searchView.clearFocus()
                if(names.contains(query)){
                    adapter.filter.filter(query)
                }
                else{
                        Toast.makeText(applicationContext,"Item not found",Toast.LENGTH_LONG).show()
                    }
                return false;
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })

    }
}