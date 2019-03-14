package strukovsky.app.makeday.room

import android.content.Context

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

}