package napp2.mario.napp_v2


import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.nap_card_view.view.*

/**
 * Created by mariofil on 26/10/2017.
 */
class NapAdapter (val items: List<NapInfo>) : RecyclerView.Adapter<NapAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items.get(position))

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NapAdapter.ViewHolder = ViewHolder(parent.inflate(R.layout.nap_card_view))


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: NapInfo) = with(itemView) {
            title.text = item.name
            info.text = item.info
            duration.text = item.duration

            val listener = View.OnClickListener {
                val i = createAlarmIntent(context, item)
                context.startActivity(i)


            }

            itemView.setOnClickListener(listener)

        }

    }




}