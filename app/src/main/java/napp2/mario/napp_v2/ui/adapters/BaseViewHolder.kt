package napp2.mario.napp_v2.ui.adapters

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import napp2.mario.napp_v2.inflate

/**
 * Created by mariossd on 24/01/2018.
 */
abstract class BaseViewHolder<T> protected constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    protected var item: T? = null
        private set

    init {
        //itemView is provided by RecyclerView.ViewHolder
        //ButterKnife.bind(this, itemView)
        itemView.setOnClickListener(this)
    }

    internal fun performBind(i: T, position: Int) {
        this.item = i
        onBind(item, position)
    }

    protected abstract fun onBind(item: T?, position: Int)
    protected abstract fun onClick(view: View, item: T?)


    override fun onClick(v: View) {
        onClick(v, item)
    }


}