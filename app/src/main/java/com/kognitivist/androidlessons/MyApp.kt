package com.kognitivist.androidlessons

import android.app.Application
import android.util.Log

class MyApp:Application() {
    companion object{
        const val TAG = "TagLifeCycleApplication"
    }
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreateApplication")
    }
}