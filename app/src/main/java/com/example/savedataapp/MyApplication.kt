package com.example.savedataapp

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class MyApplication: Application() {

    private lateinit var sharedPrefs: SharedPreferences
    override fun onCreate() {
        super.onCreate()
        instance = this
        sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    fun saveData(title:Int){
        sharedPrefs.edit().putInt("MyInt", title).apply()
    }

    fun getSavedData():Int {
        return sharedPrefs.getInt("MyInt", 1)
    }

    companion object {
        private lateinit var instance: MyApplication
        fun getApp() = instance
    }
}