package strukovsky.app.makeday.room

import android.arch.lifecycle.LiveData
import android.content.Context
import android.os.AsyncTask

/**
 * Created by dmitry on 14.03.2019.
 */

class Repository(context: Context) {
    val database: Database = Database.getInstance(context)
    val timetableDao = database.timetableDao
    val actionDao = database.actionDao


    fun getAllTimetables() = AsyncGetAllTimetables(timetableDao).execute().get()!!
    fun getAllActions() = AsyncGetAllActions(actionDao).execute().get()!!
    fun selectActions(timetable_id: Int, time: String) = AsyncSelectActions(timetable_id = timetable_id, time = time, dao = actionDao).execute().get()!!


    class AsyncGetAllTimetables(val dao: TimetableDao) : AsyncTask<Unit, Unit, LiveData<List<Timetable>>>() {
        override fun doInBackground(vararg p0: Unit): LiveData<List<Timetable>> {
            return dao.getAllTimetables()
        }
    }

    class AsyncGetAllActions(val dao: ActionDao) : AsyncTask<Unit, Unit, LiveData<List<Action>>>() {
        override fun doInBackground(vararg p0: Unit): LiveData<List<Action>> {
            return dao.getAllActions()
        }
    }

    class AsyncSelectActions(val dao: ActionDao, val timetable_id: Int, val time: String) : AsyncTask<Unit, Unit, LiveData<List<Action>>>() {
        override fun doInBackground(vararg p0: Unit): LiveData<List<Action>> {
            return dao.selectActions(timetable_id, time)
        }

    }

    class AsyncInsertTimetable(val dao: TimetableDao, val timetable: Timetable) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg p0: Unit?) {
            dao.insert(timetable)
        }

    }

    class AsyncInsertAction(val dao: ActionDao, val action: Action): AsyncTask<Unit, Unit, Unit>()
    {
        override fun doInBackground(vararg p0: Unit?) {
            dao.insert(action)
        }

    }


}