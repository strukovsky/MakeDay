package strukovsky.app.makeday.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import strukovsky.app.makeday.R
import strukovsky.app.makeday.room.Timetable

/**
 * Created by dmitry on 14.03.2019.
 */

class TimetableAdapter: RecyclerView.Adapter<TimetableAdapter.ViewHolder>()
{
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val timetable = data[position]
        holder.name.setText(timetable.name)
        holder.description.setText(timetable.description)
        val actions = timetable.actions.values
        holder.actions.adapter = ArrayAdapter<String>(holder.itemView.context,
                android.R.layout.simple_list_item_1,
                actions.toTypedArray())


    }

    private var data =  ArrayList<Timetable>()



    override fun getItemCount(): Int {
        return data.size
    }

    public fun setData(timetables: ArrayList<Timetable>)
    {
        data = timetables
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.timetable, parent)

        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val name: EditText = itemView.findViewById(R.id.name)
        val description: EditText = itemView.findViewById(R.id.description)
        val delete: ImageView = itemView.findViewById(R.id.delete)
        val actions: ListView = itemView.findViewById(R.id.actions)
    }
}