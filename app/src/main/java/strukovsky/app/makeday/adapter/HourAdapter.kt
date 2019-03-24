package strukovsky.app.makeday.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import strukovsky.app.makeday.ActionsActivity
import strukovsky.app.makeday.HOUR
import strukovsky.app.makeday.R
import strukovsky.app.makeday.TIMETABLE_ID
import strukovsky.app.makeday.room.Action
import java.lang.StringBuilder

class HourAdapter(private val timetableId: Int) : RecyclerView.Adapter<HourAdapter.HolderView>() {
    override fun onBindViewHolder(holder: HolderView, position: Int) {
        val hour = position.toString() + ":00"
        holder.time.text = hour
        holder.actions.text = makeStringOfActions(position.toString())
        holder.itemView.setOnClickListener {
            run {
                val intent = Intent(holder.itemView.context, ActionsActivity::class.java)
                intent.putExtra(TIMETABLE_ID, timetableId)
                intent.putExtra(HOUR, position)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    private  fun makeStringOfActions( hour: String) : String
    {
        val result = StringBuilder()
        // only 0, 1, 2, 3 actions can be in string representation
        var countOfActions = 0
        for(action in data)
        {
            if(countOfActions == 3)
                break
            if(action.time == hour)
            {
                result.append(action.name)
                result.append(" ")
                countOfActions++
            }
        }
        return result.toString()
    }

    var data = ArrayList<Action>()

    override fun getItemCount() = 24

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hour, parent, false)
        return HolderView(view)
    }

    fun setData(item: List<Action>) {
        data = ArrayList(item)
        notifyDataSetChanged()
    }


    inner class HolderView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val time = itemView.findViewById<TextView>(R.id.time)!!
        val actions = itemView.findViewById<TextView>(R.id.actions)!!
    }
}