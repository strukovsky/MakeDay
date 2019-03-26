package strukovsky.app.makeday

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import strukovsky.app.makeday.adapter.ActionAdapter
import strukovsky.app.makeday.viewmodel.ActionViewModel

class ActionsActivity : AppCompatActivity() {
    val adapter = ActionAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actions)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val timetableId = intent.getIntExtra(TIMETABLE_ID, 0)
        val time = intent.getIntExtra(HOUR, 0).toString()
        adapter.timetableId = timetableId
        adapter.time = time
        val viewModel = ViewModelProviders.of(this).get(ActionViewModel::class.java)
        val data = viewModel.selectActions(timetableId, time)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        data.observe(this, Observer { it ->
            run {
                adapter.setData(it!!)
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_actions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.add) {
            adapter.addItem()
        }
        if (item?.itemId == R.id.save) {

        }
        return true
    }
}
