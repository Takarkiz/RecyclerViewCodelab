package com.test.sawada.coroutine1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddActivity : AppCompatActivity() {

    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        editText = findViewById(R.id.edit_text)

    }

    fun finishEdit(view: View) {
        if (editText.text.toString().isNotBlank()) {
            val text = editText.text.toString()

        }
    }

}
