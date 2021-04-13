package com.example.template.base

import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.main_fragment.*

open class BaseFragment: Fragment() {

    fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progress.visibility = View.GONE
    }
}