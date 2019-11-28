package com.example.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        Log.d("MainActivity", "Before fetchDataAndSave(): " + Thread.currentThread().name)

        viewModel.fetchDataAndSave()

        Log.d("MainActivity", "After fetchDataAndSave(): " + Thread.currentThread().name)
    }
}
