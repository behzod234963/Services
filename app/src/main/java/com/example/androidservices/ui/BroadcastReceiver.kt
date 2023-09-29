package com.example.androidservices.ui

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidservices.BroadcastReceiver.AirPlaneModeReceiver
import com.example.androidservices.R
import com.example.androidservices.databinding.ActivityBroadcastReceiverBinding

class BroadcastReceiver : AppCompatActivity() {

    lateinit var binding:ActivityBroadcastReceiverBinding
    private val airPlaneModeReceiver=AirPlaneModeReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controller()

    }

    private fun controller() {

        onRegisterReceiver()

    }

    private fun onRegisterReceiver() {

        registerReceiver(airPlaneModeReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airPlaneModeReceiver)
    }

}