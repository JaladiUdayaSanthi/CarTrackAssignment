package com.demo.cartrack

import android.app.Activity
import android.app.Application
import android.os.Bundle

abstract class BaseApplication : Application(), Application.ActivityLifecycleCallbacks {


    override fun onCreate() {
        super.onCreate()
    }

//    override fun onActivityStarted(activity: Activity?) {
//    }
//
//    override fun onActivityDestroyed(activity: Activity?) {
//    }
//
//    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
//    }
//
//    override fun onActivityStopped(activity: Activity?) {
//    }
//
//    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
//    }

}
