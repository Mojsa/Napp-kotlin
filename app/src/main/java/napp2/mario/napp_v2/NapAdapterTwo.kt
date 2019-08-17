package napp2.mario.napp_v2

import android.view.ViewGroup
import napp2.mario.napp_v2.ui.adapters.BaseAdapter

/**
 * Created by mariossd on 29/01/2018.
 */
class NapAdapterTwo (val napInfos : List<NapInfo>) : BaseAdapter<NapInfo, NapInfoHolder>() {

    init {
        setItems(napInfos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NapInfoHolder {
        return NapInfoHolder(parent.inflate(R.layout.nap_view_fullscreen))
    }


}