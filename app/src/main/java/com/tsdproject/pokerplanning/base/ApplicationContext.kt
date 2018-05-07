package com.tsdproject.pokerplanning.base

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import io.paperdb.Paper

class ApplicationContext : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        MultiDex.install(this)
        Paper.init(this)
    }

    companion object {
        private var mAppContext: Context? = null

        var appContext: Context?
            get() = mAppContext
            set(mAppContext) {
                ApplicationContext.mAppContext = mAppContext
            }
    }
}
