package com.alfdonyus.myapplication02

import android.app.Application
import android.util.Log

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("APP", "Application created")
    }
}