package strukovsky.app.makeday.room

import android.content.Context

/**
 * Created by dmitry on 14.03.2019.
 */

class Repository(val context: Context)
{
    val database: Database = Database.getInstance(context)
    val timetableDao = database.timetableDao
    val actionDao = database.actionDao

    fun getAllTimetables() = timetableDao.getAllTimetables()
    fun getAllActions() = actionDao.getAllActions()

}