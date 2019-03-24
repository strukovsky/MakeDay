package strukovsky.app.makeday.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import strukovsky.app.makeday.R

class ActionAdapter(): RecyclerView.Adapter<ActionAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.action, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder( itemView: View): RecyclerView.ViewHolder(itemView)
    {

    }
}