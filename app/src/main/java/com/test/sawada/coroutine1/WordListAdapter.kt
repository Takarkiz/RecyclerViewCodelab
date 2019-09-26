package com.test.sawada.coroutine1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    constructor(context: Context, wordList: LinkedList<String>) {
        inflater = LayoutInflater.from(context)
        this.mWordList = wordList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {


        val itemView: View = inflater.inflate(R.layout.wordlist_item, parent, false)
        return WordViewHolder(itemView, this)
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = mWordList[position]
        holder.wordItemView?.text = current
    }


    // private

    private var mWordList: LinkedList<String> = LinkedList()
    private var inflater: LayoutInflater


    inner class WordViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        var wordItemView: TextView? = null
        var adapter: WordListAdapter? = null

        constructor(itemView: View, adapter: WordListAdapter) : super(itemView){
            wordItemView = itemView.findViewById(R.id.word)
            itemView.setOnClickListener(this)
            this.adapter = adapter
        }

        override fun onClick(v: View?) {
            val position = layoutPosition
            val element = mWordList[position]
            mWordList.set(position, "Clicked!" + element)
            adapter?.notifyDataSetChanged()

        }
    }
}