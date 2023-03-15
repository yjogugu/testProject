package com.taijoo.myproject.data.model

import android.util.Log
import javax.inject.Inject

class ClothingStore @Inject constructor() : Store {

    override fun open() {
        Log.e("여기","Clothing open")
    }

    override fun close() {
        Log.e("여기","Clothing close")
    }

}