package strukovsky.app.makeday.room.repository

import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import strukovsky.app.makeday.room.Action
import strukovsky.app.makeday.room.ActionDao
import strukovsky.app.makeday.room.Timetable
import strukovsky.app.makeday.room.TimetableDao

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