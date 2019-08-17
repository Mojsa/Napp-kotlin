package napp2.mario.napp_v2

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

/**
 * Created by test2 on 06/12/2017.
 */
class NapApplication : Application() {


    companion object {
        public lateinit var refWatcher : RefWatcher
    }

    override fun onCreate() {
        super.onCreate()
        refWatcher = LeakCanary.install(this)
    }
}