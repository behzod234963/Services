package com.example.androidservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidservices.R
import com.example.androidservices.databinding.ActivityMainBinding
import com.example.androidservices.services.MyService

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {

        binding.apply {

            btnStart.setOnClickListener { onBtnStartListener() }
            btnStop.setOnClickListener { onBtnStopListener() }

        }

    }


    //    Stop Service type(Started Service)
    private fun onBtnStopListener() {

        stopService(Intent(this@MainActivity, MyService::class.java))


    }


    //    Starting Service type(Started Service)
    private fun onBtnStartListener() {

        startService(Intent(this@MainActivity, MyService::class.java))

    }
}