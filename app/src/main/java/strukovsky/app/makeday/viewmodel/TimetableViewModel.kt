package strukovsky.app.makeday.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import strukovsky.app.makeday.room.Action
import strukovsky.app.makeday.room.repository.Repository
import strukovsky.app.makeday.room.Timetable

/**
 * Created by dmitry on 14.03.2019.
 */

class TimetableViewModel(application: Application): AndroidViewModel(application)
{
    private val repository = Repository(application.applicationContext)


    //create
    fun insertTimetable(timetable: Timetable) = repository.insertTimetable(timetable)

    //read
    fun getAllTimetables() = repository.getAllTimetables()
    fun getAllActions() = repository.getAllActions()

    //update
    fun updateTimetable(timetable: Timetable) = repository.updateTimetable(timetable)

    //delete
    fun deleteTimetable(timetable: Timetable) = repository.deleteTimetable(timetable)


}