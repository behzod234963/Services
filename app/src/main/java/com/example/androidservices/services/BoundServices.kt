package com.example.androidservices.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.androidservices.R
import java.util.Calendar

class BoundServices: Service() {
    private val binder: IBinder = MyBinder()
    override fun onBind(intent: Intent?): IBinder = MyBinder()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notification=NotificationCompat.Builder(this
        ,"channel")
            .setSmallIcon(R.drawable.android_kalla)
            .setContentTitle("hello i am a title")
            .setContentText("helllo i am a text")
            .build()

        return super.onStartCommand(intent, flags, startId)
    }

    class MyBinder : Binder() {
        fun getService(): BoundServices = BoundServices()

    }
}
