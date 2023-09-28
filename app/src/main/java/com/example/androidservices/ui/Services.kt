package com.example.androidservices.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.androidservices.databinding.ActivityServicesBinding
import com.example.androidservices.services.BackgroundServices
import com.example.androidservices.services.ForegroundServices

class Services : AppCompatActivity() {

    lateinit var binding: ActivityServicesBinding
    var startStopBG = 0
    var startStopFg = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainController()

    }


    //    Main controller for this UI
    @RequiresApi(Build.VERSION_CODES.O)
    private fun mainController() {

        requestPermission()
        initView()
        listeners()

    }


    //    Request permission of User for posting notifications
    private fun requestPermission() {

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){

            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 0)

        }

    }


    //    Listeners logic
    @RequiresApi(Build.VERSION_CODES.O)
    private fun listeners() {

        binding.apply {

            btnBackground.setOnClickListener { onBtnBgListener() }

            btnForeground.setOnClickListener { onBtnFgListener() }

        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onBtnFgListener() {

        startStopFg++

        when(startStopFg){

            1->{

                Intent(applicationContext,ForegroundServices::class.java).also {

                    it.action=ForegroundServices.Actions.START.toString()
                    startForegroundService(it)

                }
                Toast.makeText(this, "1 is working", Toast.LENGTH_SHORT).show()

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