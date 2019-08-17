package napp2.mario.napp_v2.ui.adapters

import android.support.v7.widget.RecyclerView
import java.util.ArrayList

/**
 * Created by mariossd on 24/01/2018.
 */
abstract class BaseAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {
    private var items: MutableList<T> = ArrayList()

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        //bind holder
        holder.performBind(item, position)
    }

    fun setItems(listItems: List<T>) {
        items = ArrayList(listItems)
    }


    fun addItem(item: T) {
        items.add(item)
    }

    fun addItems(list: List<T>) {
        items.addAll(list)
    }

    fun deleteItems() {
        items.clear()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}