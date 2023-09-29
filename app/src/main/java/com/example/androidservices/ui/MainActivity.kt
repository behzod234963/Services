package com.example.androidservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidservices.databinding.ActivityMainBinding
import com.example.androidservices.services.BackgroundServices

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

            btnServices.setOnClickListener { openServices() }
            btnBrRec.setOnClickListener { openBrReceivers() }

        }

    }

    private fun openBrReceivers() {

        startActivity(Intent(this,BroadcastReceiver::class.java))

    }

    private fun openServices() {

        startActivity(Intent(this@MainActivity,Services::class.java))

    }


    //    Stop Service type(Started Service)
    private fun onBtnStopListener() {

        stopService(Intent(this@MainActivity, BackgroundServices::class.java))


    }


    //    Starting Service type(Started Service)
    private fun onBtnStartListener() {

        startService(Intent(this@MainActivity, BackgroundServices::class.java))

    }
}