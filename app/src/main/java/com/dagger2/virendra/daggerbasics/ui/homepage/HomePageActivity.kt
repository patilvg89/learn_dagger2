package com.dagger2.virendra.daggerbasics.ui.homepage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.dagger2.virendra.daggerbasics.R
import com.dagger2.virendra.daggerbasics.application.MyApplication
import com.dagger2.virendra.daggerbasics.ui.homepage.model.HomePageData
import com.raywenderlich.android.droidwiki.utils.errorDialog
import com.raywenderlich.android.droidwiki.utils.parseHtml
import kotlinx.android.synthetic.main.activity_homepage.*
import javax.inject.Inject

class HomePageActivity : AppCompatActivity(), HomePageView {

    @Inject
    lateinit var homePagePresenter: HomePagePresenterImpl;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        //inject dependency
        (this.application as MyApplication).getAppComponent().inject(this);

        homePagePresenter.setView(this);
        homePagePresenter.loadHomePage();
    }


    override fun showProgressBar() {
        wait_progress_bar.post {
            wait_progress_bar.visibility = View.VISIBLE
            homepage_sv.visibility = View.GONE
        }
    }

    override fun hideProgressBar() {
        wait_progress_bar.post {
            wait_progress_bar.visibility = View.GONE
            homepage_sv.visibility = View.VISIBLE
        }
    }

    override fun onSuccess(data: HomePageData) {
        homepage_tv.post {
            homepage_tv.text = data.result.parseHtml();
        }
    }

    override fun onError(error: String?) {
        Log.e("ERROR", error)
        runOnUiThread {
            R.string.error.errorDialog(this)
        }
    }
}
