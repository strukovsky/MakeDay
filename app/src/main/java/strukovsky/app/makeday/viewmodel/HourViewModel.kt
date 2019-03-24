package strukovsky.app.makeday.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import strukovsky.app.makeday.room.Action
import strukovsky.app.makeday.room.Timetable
import strukovsky.app.makeday.room.repository.Repository

class HourViewModel(application: Application): AndroidViewModel(application) {
    val  repository = Repository(application)

    //create
    fun insertAction(action: Action) = repository.insertAction(action)

    //read
    fun getAllActions() = repository.getAllActions()
    fun selectActions(timetable_id: Int, time: String) = repository.selectActions(timetable_id, time)
    fun selectActionsByTimetable(timetableId: Int)  = repository.selectActionsByTimetable(timetableId)

    //update
    fun updateAction(action: Action) = repository.updateAction(action)

    //delete
    fun deleteAction(action: Action) = repository.deleteAction(action)
}