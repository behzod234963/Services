package com.example.androidservices.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.androidservices.databinding.ActivityServicesBinding
import com.example.androidservices.services.BackgroundServices
import com.example.androidservices.services.ForegroundServices

class Services : AppCompatActivity() {

    lateinit var binding: ActivityServicesBinding
    var startStopBG = 0
    var startStopFg = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainController()

    }


    //    Main controller for this UI
    private fun mainController() {

        initView()
        listeners()
        requestPermission()

    }


    //    Request permission of User for posting notifications
    private fun requestPermission() {

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){

            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1)

        }

    }


    //    Listeners logic
    private fun listeners() {

        binding.apply {

            btnBackground.setOnClickListener { onBtnBgListener() }

            btnForeground.setOnClickListener { onBtnFgListener() }

        }

    }

    private fun onBtnFgListener() {

        startStopFg++

        when(startStopFg){

            1->{

                Intent(applicationContext,ForegroundServices::class.java).also {

                    it.action=ForegroundServices.Actions.START.toString()
                    startService(it)

                }

            }
            2->{

                Intent(applicationContext,ForegroundServices::class.java).also {

                    it.action=ForegroundServices.Actions.STOP.toString()
                    startService(it)

                }

                startStopFg=0

            }

        }

    }


    //    Listener for background service button
    private fun onBtnBgListener() {

        startStopBG++
        when (startStopBG) {

            1 -> {

                startService(Intent(this@Services, BackgroundServices::class.java))

            }

            2 -> {

                stopService(Intent(this@Services, BackgroundServices::class.java))
                startStopBG= 0

            }

        }

    }


    //    Initialize data
    private fun initView() {


    }
}