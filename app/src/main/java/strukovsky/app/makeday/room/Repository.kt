package strukovsky.app.makeday.room

import android.arch.lifecycle.LiveData
import android.content.Context
import java.lang.StringBuilder
import java.util.*

/**
 * Created by dmitry on 14.03.2019.
 */

class Repository(context: Context)
{
    val database: Database = Database.getInstance(context)
    val timetableDao = database.timetableDao
    val actionDao = database.actionDao

    /*
    TODO: AsyncTasks
     */
    fun getAllTimetables() = timetableDao.getAllTimetables()
    fun getAllActions() = actionDao.getAllActions()
    fun selectActions(timetable_id: Int, time: String) = actionDao.selectActions(timetable_id, time)

    fun applyActionsInTimetables(data: LiveData<ArrayList<Timetable>>)
    {
        val timetables = data.value!!
        val size = timetables.size
        for(id in 0..size)
        {
            val map = TreeMap<Int, String>()
            val timetable = timetables[id]
            for(hour in 0..24)
            {
                val actions = selectActions(timetable_id = id, time = hour.toString()).value
                map.put(hour, formatActions(actions!!))
            }
            timetable.actions = map
        }
    }

    private fun formatActions(actions: ArrayList<Action>): String
    {
        val result = StringBuilder()
        actions.forEach { it ->
            result.append(it.toString())
        }
        return result.toString()
    }


}