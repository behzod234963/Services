package com.example.androidservices.services

import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService:android.app.Service() {

    private lateinit var player:MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        player=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.isLooping
        player.start()
        return START_NOT_STICKY


    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }


}