package com.example.androidservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {

        binding.apply {

            btnServices.setOnClickListener { openServices() }
            btnBrRec.setOnClickListener { openBrReceivers() }
            btnContenPro.setOnClickListener { openContentPro() }

        }

    }

    private fun openContentPro() {

        startActivity(Intent(this,ContentProvidersActivity::class.java))

    }

    private fun openBrReceivers() {

        startActivity(Intent(this,BroadcastReceiverActivity::class.java))

    }

    private fun openServices() {

        startActivity(Intent(this@MainActivity,ServicesActivity::class.java))

    }

}