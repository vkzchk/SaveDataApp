package com.example.savedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)


        val plusBtn: Button = findViewById(R.id.btnPlus)
        val minusBtn: Button = findViewById(R.id.btnMinus)

        textView?.text = MyApplication.getApp().getSavedData().toString()

        plusBtn.setOnClickListener { onPlusClick() }
        minusBtn.setOnClickListener { onMinusClick() }

    }

    private fun onMinusClick() {
        var value = textView?.text.toString().toInt().minus(1)
        if (value >= 1) {
            updateTextView(value)
        } else {
            showToast("The value cannot be less than 1")
        }
    }

    private fun onPlusClick() {
        var value = textView?.text.toString().toInt().plus(1)
        updateTextView(value)
    }

    private fun updateTextView(value:Int) {
        MyApplication.getApp().saveData(value)
        textView?.text = MyApplication.getApp().getSavedData().toString()
    }

    override fun onPause() {
        super.onPause()
        MyApplication.getApp().saveData(textView?.text.toString().toInt())
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}