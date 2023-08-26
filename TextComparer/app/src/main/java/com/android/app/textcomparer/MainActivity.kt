package com.android.app.textcomparer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: Comparer
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var resultTextView: TextView
    private lateinit var comparatorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[Comparer::class.java]

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        resultTextView = findViewById(R.id.result)
        comparatorButton = findViewById(R.id.button)

        comparatorButton.setOnClickListener {
            val text1 = textView1.text.toString()
            val text2 = textView2.text.toString()
            viewModel.textComparer(text1, text2)
        }

        viewModel.resultado.observe(this) { resultado ->
            resultTextView.text = resultado
        }
    }
}