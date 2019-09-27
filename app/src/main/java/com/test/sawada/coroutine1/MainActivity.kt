package com.test.sawada.coroutine1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reset()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.reset -> {
                reset()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private var recycleView: RecyclerView? = null
    private var adapter: WordListAdapter? = null

    private fun reset() {
        val words: LinkedList<String> = LinkedList()

        for (i in 0..20) {
            words.addLast("Word" + i)
        }

        recycleView = findViewById(R.id.recycler_view)
        adapter = null
        adapter = WordListAdapter(this, words)
        recycleView?.adapter = adapter
        recycleView?.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val wordListSize = words.size
            words.addLast("+ Word" + wordListSize)
            recycleView?.adapter?.notifyItemInserted(wordListSize)
            recycleView?.smoothScrollToPosition(wordListSize)
        }
    }
}
