package napp2.mario.napp_v2.controllers

import android.os.Bundle
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import napp2.mario.napp_v2.NapAdapter
import napp2.mario.napp_v2.NapApplication

/**
 * Created by test2 on 06/12/2017.
 */
abstract class RefWatchingController : ButterKnifeController {

    private var hasExited: Boolean = false

    protected constructor() {}
    protected constructor(args: Bundle) : super(args) {}

    override fun onDestroy() {
        super.onDestroy()

        if (hasExited) {
            NapApplication.refWatcher.watch(this)
        }
    }

    override protected fun onChangeEnded(changeHandler: ControllerChangeHandler, changeType: ControllerChangeType) {
        super.onChangeEnded(changeHandler, changeType)

        hasExited = !changeType.isEnter
        if (isDestroyed()) {
            NapApplication.refWatcher.watch(this)
        }
    }
}