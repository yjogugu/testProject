package com.taijoo.myproject.data.model

import android.util.Log
import javax.inject.Inject

interface Store {

    fun open()

    fun close()
}