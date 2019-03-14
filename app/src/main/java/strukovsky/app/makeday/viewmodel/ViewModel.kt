package strukovsky.app.makeday.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.content.Context
import strukovsky.app.makeday.room.Repository

/**
 * Created by dmitry on 14.03.2019.
 */

class ViewModel(application: Application): AndroidViewModel(application)
{
    private val repository = Repository(application.applicationContext)

    public fun getAllTimetables() = repository.getAllTimetables()
    public fun getAllActions() = repository.getAllActions()
    public fun selectActions(timetable_id: Int, time: String) = repository.selectActions(timetable_id, time)
}