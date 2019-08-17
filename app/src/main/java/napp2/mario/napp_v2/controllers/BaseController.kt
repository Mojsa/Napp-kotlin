package napp2.mario.napp_v2.controllers

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.View

/**
 * Created by test2 on 06/12/2017.
 */
abstract class BaseController : RefWatchingController {

    // Note: This is just a quick demo of how an ActionBar *can* be accessed, not necessarily how it *should*
    // be accessed. In a production app, this would use Dagger instead.
    /*protected val actionBar: ActionBar?
        get() {
            val actionBarProvider = getActivity() as ActionBarProvider
            return if (actionBarProvider != null) actionBarProvider!!.getSupportActionBar() else null
        }*/

    protected val title: String?
        get() = null

    protected constructor() {}

    protected constructor(args: Bundle) : super(args) {}

    override protected fun onAttach(view: View) {
        setTitle()
        super.onAttach(view)
    }

    protected fun setTitle() {
        var parentController = getParentController()
        while (parentController != null) {
            if (parentController is BaseController && (parentController as BaseController).title != null) {
                return
            }
            parentController = parentController!!.getParentController()
        }

        val title = title
       //val actionBar = actionBar
       // if (title != null && actionBar != null) {
       //     actionBar.setTitle(title)
       // }
    }
}
