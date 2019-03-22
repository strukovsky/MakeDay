package strukovsky.app.makeday.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.os.AsyncTask
import strukovsky.app.makeday.room.Action
import strukovsky.app.makeday.room.Repository
import strukovsky.app.makeday.room.Timetable

/**
 * Created by dmitry on 14.03.2019.
 */

class ViewModel(application: Application): AndroidViewModel(application)
{
    private val repository = Repository(application.applicationContext)

    fun getAllTimetables() = AsyncGetAllTimetables().execute(repository).get()!!
    fun getAllActions() = AsyncGetAllActions().execute(repository).get()!!
    fun selectActions(timetable_id: Int, time: String) = AsyncSelectActions(timetable_id, time).execute(repository).get()!!

    class AsyncGetAllTimetables: AsyncTask<Repository, Unit, LiveData<List<Timetable>>>()
    {
        override fun doInBackground(vararg repo: Repository): LiveData<List<Timetable>> {
            return repo[0].getAllTimetables()
        }
    }

    class AsyncGetAllActions: AsyncTask<Repository, Unit, LiveData<List<Action>>>(){
        override fun doInBackground(vararg repo: Repository): LiveData<List<Action>> {
            return repo[0].getAllActions()
        }
    }

    class AsyncSelectActions(val timetable_id: Int,val time: String): AsyncTask<Repository, Unit, LiveData<List<Action>>>()
    {
        override fun doInBackground(vararg repo: Repository): LiveData<List<Action>> {
            return repo[0].selectActions(timetable_id, time)
        }

    }



}