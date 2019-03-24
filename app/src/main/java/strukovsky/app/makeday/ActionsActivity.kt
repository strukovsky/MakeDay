package strukovsky.app.makeday

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import strukovsky.app.makeday.adapter.ActionAdapter
import strukovsky.app.makeday.viewmodel.ActionViewModel

class ActionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actions)

        val timetableId = intent.getIntExtra(TIMETABLE_ID, 0)
        val time = intent.getIntExtra(HOUR, 0)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = ActionAdapter()
        recycler.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(ActionViewModel::class.java)
        viewModel.selectActions(timetableId, time.toString()).observe(this, Observer {it ->
            run{
                adapter.setData(it!!)
        } })


    }
}
