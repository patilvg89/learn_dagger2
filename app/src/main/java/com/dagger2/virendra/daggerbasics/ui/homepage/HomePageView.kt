package com.dagger2.virendra.daggerbasics.ui.homepage

import com.dagger2.virendra.daggerbasics.ui.homepage.model.HomePageData

/**
 * Created by virendra.patil on 15/01/18.
 */
interface HomePageView {
    fun showProgressBar()

    fun hideProgressBar()

    fun onSuccess(result: HomePageData)

    fun onError(error: String?)
}