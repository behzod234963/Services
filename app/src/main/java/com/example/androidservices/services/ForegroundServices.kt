package com.example.androidservices.services

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.androidservices.R

class ForegroundServices : Service() {
    override fun onBind(intent: Intent?): IBinder?=null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action){

            Actions.START.toString()->{ start() }
            Actions.STOP.toString()->{ stopSelf() }

        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun start(){
        val notification=NotificationCompat.Builder(this,"notification_channel")
            .setSmallIcon(R.drawable.android_kalla)
            .setContentTitle("Notification title")
            .setContentText("Notification text")
            .build()
       startForeground(1,notification)
        Toast.makeText(this, "start function is working", Toast.LENGTH_SHORT).show()

    }

    enum class Actions{

        START,STOP

    }

}