package strukovsky.app.makeday.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import strukovsky.app.makeday.room.Action
import strukovsky.app.makeday.room.repository.Repository
import strukovsky.app.makeday.room.Timetable

/**
 * Created by dmitry on 14.03.2019.
 */

class ViewModel(application: Application): AndroidViewModel(application)
{
    private val repository = Repository(application.applicationContext)


    //create
    fun insertTimetable(timetable: Timetable) = repository.insertTimetable(timetable)
    fun insertAction(action: Action) = repository.insertAction(action)

    //read
    fun getAllTimetables() = repository.getAllTimetables()
    fun getAllActions() = repository.getAllActions()
    fun selectActions(timetable_id: Int, time: String) = repository.selectActions(timetable_id, time)

    //update
    fun updateTimetable(timetable: Timetable) = repository.updateTimetable(timetable)
    fun updateAction(action: Action) = repository.updateAction(action)

    //delete
    fun deleteTimetable(timetable: Timetable) = repository.deleteTimetable(timetable)
    fun deleteAction(action: Action) = repository.deleteAction(action)








}