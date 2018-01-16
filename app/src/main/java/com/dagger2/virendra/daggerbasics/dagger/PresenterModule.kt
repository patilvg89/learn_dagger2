package com.dagger2.virendra.daggerbasics.dagger

import com.dagger2.virendra.daggerbasics.network.ServerRequest
import com.dagger2.virendra.daggerbasics.ui.homepage.HomePagePresenter
import com.dagger2.virendra.daggerbasics.ui.homepage.HomePagePresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by virendra.patil on 15/01/18.
 */
@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideHomepagePresenter(serverRequest: ServerRequest): HomePagePresenter = HomePagePresenterImpl(serverRequest)
}