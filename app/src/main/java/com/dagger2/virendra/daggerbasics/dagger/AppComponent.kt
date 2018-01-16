package com.dagger2.virendra.daggerbasics.dagger

import com.dagger2.virendra.daggerbasics.ui.homepage.HomePageActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by virendra.patil on 15/01/18.
 */

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(target: HomePageActivity)
}