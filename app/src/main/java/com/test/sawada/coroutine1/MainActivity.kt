package com.test.sawada.coroutine1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.wordlist_item.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var wordList: LinkedList<String> = LinkedList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..20) {
            wordList.addLast("Word" + i)
        }

        recycleView = findViewById(R.id.recycler_view)
        adapter = WordListAdapter(this, wordList)
        recycleView?.adapter = adapter
        recycleView?.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val wordListSize = wordList.size
            wordList.addLast("+ Word" + wordListSize)
            recycleView?.adapter?.notifyItemInserted(wordListSize)
            recycleView?.smoothScrollToPosition(wordListSize)
        }
    }

    private var recycleView: RecyclerView? = null
    private var adapter: WordListAdapter? = null
}
