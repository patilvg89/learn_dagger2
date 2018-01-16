package com.dagger2.virendra.daggerbasics.dagger

import android.content.Context
import com.dagger2.virendra.daggerbasics.application.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by virendra.patil on 15/01/18.
 */

@Module
class AppModule(private val app: MyApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context = app
}