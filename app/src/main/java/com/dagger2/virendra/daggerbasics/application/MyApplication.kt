package com.dagger2.virendra.daggerbasics.application

import android.app.Application
import com.dagger2.virendra.daggerbasics.dagger.AppComponent
import com.dagger2.virendra.daggerbasics.dagger.AppModule
import com.dagger2.virendra.daggerbasics.dagger.DaggerAppComponent

/**
 * Created by virendra.patil on 15/01/18.
 */
class MyApplication : Application() {

    private lateinit var myAppComponent: AppComponent;

    override fun onCreate() {
        super.onCreate()

        myAppComponent = initDagger(this);
    }

    private fun initDagger(application: MyApplication): AppComponent {
        return DaggerAppComponent.builder().appModule(AppModule(application)).build()
    }


    fun getAppComponent(): AppComponent {
        return myAppComponent;
    }
}