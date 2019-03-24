package strukovsky.app.makeday

import android.arch.lifecycle.Observer
import strukovsky.app.makeday.viewmodel.TimetableViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.facebook.stetho.Stetho
import strukovsky.app.makeday.adapter.TimetableAdapter
import strukovsky.app.makeday.room.Timetable

class MainActivity : AppCompatActivity() {


    val adapter = TimetableAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initializeWithDefaults(this);


        val recyclerView: RecyclerView = findViewById(R.id.timetables)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(TimetableViewModel::class.java)
       // viewModel.insertTimetable(Timetable("Name", "Description"))
      //  viewModel.insertAction(Action(1, "wake up", "description: wake up", "7"))


        viewModel.getAllTimetables().observe(this,
                Observer<List<Timetable>> { t -> adapter.setData(t!!)

        }
        )





    }
}
