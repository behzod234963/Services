package com.example.androidservices.utils

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.Toast

class ForegroundUtil:Application() {

    override fun onCreate() {

        super.onCreate()
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            val channel=NotificationChannel(

                "notification_channel",
                "Notifications",
                NotificationManager.IMPORTANCE_HIGH

            )


            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            Toast.makeText(this, "utils is working", Toast.LENGTH_SHORT).show()
        }

    }

}