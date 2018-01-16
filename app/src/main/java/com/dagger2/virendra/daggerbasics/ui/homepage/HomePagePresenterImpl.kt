package com.dagger2.virendra.daggerbasics.ui.homepage

import com.dagger2.virendra.daggerbasics.network.ServerRequest
import com.dagger2.virendra.daggerbasics.ui.homepage.model.HomePageData
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

/**
 * Created by virendra.patil on 15/01/18.
 */
class HomePagePresenterImpl @Inject constructor(private val serviceApi: ServerRequest) : HomePagePresenter {
    private lateinit var homePageView: HomePageView;

    override fun setView(homePageView: HomePageView) {
        this.homePageView = homePageView;
    }

    override fun loadHomePage() {
        //homePageView.onSuccess(HomePageData("<h1>title</h1>"))
        homePageView.showProgressBar()

        serviceApi.getHomepage().enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                homePageView.hideProgressBar()
                if (response?.isSuccessful == true) {
                        homePageView.onSuccess(HomePageData(response.toString()))
                    } else {
                    homePageView.onError(response?.message())
                }
            }

            override fun onFailure(call: Call?, t: IOException?) {
                homePageView.onError(t?.message)
                t?.printStackTrace()
            }
        })
    }
}