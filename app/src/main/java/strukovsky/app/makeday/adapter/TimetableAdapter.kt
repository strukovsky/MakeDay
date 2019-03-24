package strukovsky.app.makeday.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import strukovsky.app.makeday.HoursActivity
import strukovsky.app.makeday.R
import strukovsky.app.makeday.room.Timetable
import strukovsky.app.makeday.TIMETABLE_ID

/**
 * Created by dmitry on 14.03.2019.
 */

class TimetableAdapter: RecyclerView.Adapter<TimetableAdapter.ViewHolder>()
{
    override fun onBindViewHolder(holder: ViewHolder,  position: Int) {
        val timetable = data[position]

        holder.name.text = timetable.name
        holder.description.text = timetable.description
        holder.itemView.setOnClickListener { view ->
            run {
                val intent = Intent(view.context, HoursActivity::class.java)
                intent.putExtra(TIMETABLE_ID, position)
                view.context.startActivity(intent)
            }
        }

        holder.name.text = timetable.name
        holder.description.text = timetable.description


    }

    private var data =  ArrayList<Timetable>()



    override fun getItemCount(): Int {
        return data.size
    }

    public fun setData(timetables: List<Timetable>)
    {
        data = ArrayList(timetables)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.timetable, parent, false)

        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val name: TextView = itemView.findViewById(R.id.name)
        val description: TextView = itemView.findViewById(R.id.description)
        val delete: ImageView = itemView.findViewById(R.id.delete)
    }
}
