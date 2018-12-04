package com.feed.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.leo.simplearcloader.ArcConfiguration
import com.leo.simplearcloader.SimpleArcDialog

open class BaseActivity : AppCompatActivity() {
    lateinit var loaderDialog: SimpleArcDialog

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    fun showLoader(context: Context) {
        loaderDialog = SimpleArcDialog(context)
        loaderDialog.setConfiguration(ArcConfiguration(context))
        loaderDialog.show()
        loaderDialog.loadingTextView.text = "Loading"
    }

    fun hideLoader() {
        if (::loaderDialog.isInitialized && loaderDialog.isShowing)
            loaderDialog.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::loaderDialog.isInitialized) {
            loaderDialog.dismiss()
        }
    }
}