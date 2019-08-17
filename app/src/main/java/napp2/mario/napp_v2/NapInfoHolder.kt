package napp2.mario.napp_v2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.iigo.library.ClockHelper
import com.iigo.library.ClockView
import kotlinx.android.synthetic.main.nap_card_view.view.*
import kotlinx.android.synthetic.main.nap_view_fullscreen.view.*
import napp2.mario.napp_v2.models.Nap
import napp2.mario.napp_v2.ui.adapters.BaseViewHolder
import java.util.*

/**
 * Created by mariossd on 29/01/2018.
 */
class NapInfoHolder(itemView: View) : BaseViewHolder<NapInfo>(itemView) {

    var title: TextView
    var duration: TextView
    var clockView: ClockView

    init {
        title = itemView.napTitle
        duration = itemView.napDuration
        clockView = itemView.clockView
    }

    override fun onBind(item: NapInfo?, position: Int) {
        item?.let {
            title.text = item.name
            duration.text = item.duration
            val clockHelper = ClockHelper(clockView)
            clockHelper.start()
        }

    }

    override fun onClick(view: View, item: NapInfo?) {
        item?.let {
            val i = createAlarmIntent(view.context, item)
            view.context.startActivity(i)
        }
    }

}