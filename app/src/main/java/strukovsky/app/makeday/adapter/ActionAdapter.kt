package strukovsky.app.makeday.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import strukovsky.app.makeday.R
import strukovsky.app.makeday.room.Action

class ActionAdapter(): RecyclerView.Adapter<ActionAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val action = data[position]
        holder.name.setText(action.name)
        holder.delete.setOnClickListener {
            data.remove(action)
            notifyItemRemoved(position)
        }
    }

    var timetableId = 0
    var time = "0"

    override fun getItemCount(): Int {
        return data.size
    }

    private var data = ArrayList<Action>()

    fun setData(array: List<Action>)
    {
        data = ArrayList(array)
        notifyDataSetChanged()
    }


    fun addItem()
    {
        data.add(Action(timetableId, "", "", time))
        notifyItemInserted(data.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.action, parent, false)

        return ViewHolder(view)
    }

    inner class ViewHolder( itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val name = itemView.findViewById<EditText>(R.id.name)
        val delete = itemView.findViewById<ImageView>(R.id.delete)
    }
}