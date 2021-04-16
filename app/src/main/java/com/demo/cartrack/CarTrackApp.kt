package com.demo.cartrack

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.LifecycleObserver
import com.demo.cartrack.di.module.appViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module

open class CarTrackApp : BaseApplication(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        setUpConfigData()
    }

    private fun setUpConfigData() {
        if (GlobalContext.getOrNull() == null) {
            loadKoinModules( module { startKoin {
                androidContext(this@CarTrackApp)
                modules(listOf(appViewModelModule))
            } })
        }
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStarted(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityDestroyed(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        TODO("Not yet implemented")
    }

    override fun onActivityStopped(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onActivityResumed(activity: Activity) {
    }

}