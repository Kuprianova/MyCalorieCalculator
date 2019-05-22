package com.example.xxx_alena_1337_xxx.mycaloriecalculator

import android.app.Application
import com.chibatching.kotpref.Kotpref

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)

    }

}