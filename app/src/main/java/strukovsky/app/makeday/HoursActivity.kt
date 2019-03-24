package strukovsky.app.makeday

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import strukovsky.app.makeday.adapter.HourAdapter
import strukovsky.app.makeday.viewmodel.HourViewModel
import strukovsky.app.makeday.viewmodel.TimetableViewModel

class HoursActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hour)

        val timetableId = intent.getIntExtra(TIMETABLE_ID, 0)

        val adapter = HourAdapter(timetableId)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(HourViewModel::class.java)
       viewModel.selectActionsByTimetable(timetableId).observe(
               this, Observer { item ->
           run {
               adapter.setData(item!!)

           }
       }
       )
      //  adapter.setData(data.value!!)



    }
}
