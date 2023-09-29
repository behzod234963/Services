package com.example.androidservices.BroadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class AirPlaneModeReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent?.action==Intent.ACTION_AIRPLANE_MODE_CHANGED){

            val isTurnOn=Settings.Global.getInt(context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON
            )!=0
            println("Is airplane mode enabled?: $isTurnOn")

        }

    }
}