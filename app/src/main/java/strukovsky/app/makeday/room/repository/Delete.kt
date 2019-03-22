package strukovsky.app.makeday.room.repository

import android.os.AsyncTask
import strukovsky.app.makeday.room.Action
import strukovsky.app.makeday.room.ActionDao
import strukovsky.app.makeday.room.Timetable
import strukovsky.app.makeday.room.TimetableDao

class AsyncDeleteTimetable(val dao: TimetableDao, val timetable: Timetable) : AsyncTask<Unit, Unit, Unit>()
{
    override fun doInBackground(vararg p0: Unit?) {
        dao.delete(timetable)
    }
}

class AsyncDeleteAction(val dao: ActionDao, val action: Action): AsyncTask<Unit, Unit, Unit>()
{
    override fun doInBackground(vararg p0: Unit?) {
        dao.delete(action)
    }

}