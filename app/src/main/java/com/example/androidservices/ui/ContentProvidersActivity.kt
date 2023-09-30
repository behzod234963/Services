package com.example.androidservices.ui

import android.content.ContentUris
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.androidservices.databinding.ActivityContentProvidersBinding
import java.util.Calendar

class ContentProvidersActivity : AppCompatActivity() {

    lateinit var binding: ActivityContentProvidersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContentProvidersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controller()

    }

    private fun controller() {

        val projection= arrayOf(

            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,

        )
        val behzodYesterday= Calendar.getInstance().apply {

            add(Calendar.DAY_OF_YEAR,-1)

        }.timeInMillis
        val selection="${MediaStore.Images.Media.DATE_TAKEN}>=?"
        val selectionArgs= arrayOf(behzodYesterday.toString())
        val sortOrder="${MediaStore.Images.Media.DATE_TAKEN}DESC"
        contentResolver.query(

            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            sortOrder
        )?.use {cursor->

            val idColumn=cursor.getColumnIndex(MediaStore.Images.Media._ID)
            val nameColumn=cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)

            val images= mutableListOf<Image>()
            while (cursor.moveToNext()){

                val id=cursor.getLong(idColumn)
                val name=cursor.getString(nameColumn)
                val uri=ContentUris.withAppendedId(

                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id,
                )

                images.add(Image(id,name,uri))

            }


        }

    }

    data class Image(

        val id:Long,
        val name:String,
        val uri:Uri
    )
}