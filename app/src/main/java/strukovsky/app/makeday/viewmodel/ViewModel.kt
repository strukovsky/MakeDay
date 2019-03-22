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

    fun getAllTimetables() = repository.getAllTimetables()
    fun getAllActions() = repository.getAllActions()
    fun selectActions(timetable_id: Int, time: String) = repository.selectActions(timetable_id, time)






}