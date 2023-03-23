package com.example.theSwitcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.theswitcher_rubenrocha.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }

}