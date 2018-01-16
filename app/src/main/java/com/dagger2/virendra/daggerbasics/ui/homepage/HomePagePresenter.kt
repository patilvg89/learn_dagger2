package com.dagger2.virendra.daggerbasics.ui.homepage

/**
 * Created by virendra.patil on 15/01/18.
 */
interface HomePagePresenter {
    fun setView(homePageView: HomePageView);
    fun loadHomePage();
}