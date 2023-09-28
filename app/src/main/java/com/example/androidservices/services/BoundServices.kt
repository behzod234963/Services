package com.example.androidservices.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.androidservices.R

class BoundServices: Service() {

    inner class UploadBinder: Binder(){

        fun subscribeToProgress(onProgress:(Int)->Unit){



        }

    }
    override fun onBind(intent: Intent?): IBinder?=UploadBinder()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action){

            Actions.START.toString()->{ startBound() }
            Actions.STOP.toString()->{ stopSelf() }

        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun startBound(){
        val notification= NotificationCompat.Builder(this,"bound_channel")
            .setSmallIcon(R.drawable.android_kalla)
            .setContentTitle("Bound title")
            .setContentText("Bound text")
            .build()
        startForeground(1,notification)
        Toast.makeText(this, "start function is working", Toast.LENGTH_SHORT).show()

    }

    enum class Actions{

        START,STOP

    }
}