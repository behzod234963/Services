package com.example.androidservices.contentProviders

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media
import java.util.Calendar

val yesterDay=Calendar.getInstance().apply {

    add(Calendar.DAY_OF_YEAR,-1)

}.timeInMillis
class ContentProviders : ContentProvider(){
    override fun onCreate(): Boolean = true

    override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? {

       var contentUri=MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        contentUri=uri
        var contentProjection= arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME
        )
        contentProjection= projection as Array<String>
        var contentSelection="${MediaStore.Images.Media.DATE_TAKEN}>=?"
        contentSelection=selection!!
        var contentSelectionArgs= arrayOf(yesterDay.toString())
        contentSelectionArgs= selectionArgs as Array<String>
        var contentSortOrder="${MediaStore.Images.Media.DATE_TAKEN}DESC"
        contentSortOrder=sortOrder!!

    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }
}