package com.example.androidservices.viewModel

import android.provider.MediaStore.Images
import androidx.lifecycle.ViewModel
import com.example.androidservices.ui.ContentProviders

class ImageViewModel :ViewModel(){

    fun updateImages(images:List<ContentProviders.Image>){

        this.images=images

    }

}