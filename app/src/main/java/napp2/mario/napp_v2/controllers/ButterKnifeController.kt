package napp2.mario.napp_v2.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller

import butterknife.ButterKnife
import butterknife.Unbinder


/**
 * Created by test2 on 06/12/2017.
 */
abstract class ButterKnifeController : Controller {

    private var unbinder: Unbinder? = null

    protected constructor() {}
    protected constructor(args: Bundle) : super(args) {}

    protected abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflateView(inflater, container)
        unbinder = ButterKnife.bind(this, view)
        onViewBound(view)
        return view
    }

    protected fun onViewBound(view: View) {}

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        unbinder!!.unbind()
        unbinder = null
    }

}