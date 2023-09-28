package com.example.androidservices.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.app.NotificationCompat
import com.example.androidservices.R
import com.example.androidservices.ui.Services

class NotificationFactory(

    private val ctx:Context,
    private var channelID: String = "simple_notifications",
    private var notificationID: Int = 1,
    private val pendingIntent:PendingIntent?=null){


    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotification(){

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            requestPermissions(Services(), arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),1)

        }

        val notificationManager=Services().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
       val channel=NotificationChannel(channelID,"notification",NotificationManager.IMPORTANCE_HIGH)
        notificationManager.createNotificationChannel(channel)
        val notificationBuilder=NotificationCompat.Builder(Services(),channelID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Title")
            .setContentText("Music is playing")
            .setAutoCancel(true)
        notificationManager.notify(notificationID,notificationBuilder.build())

    }

}

