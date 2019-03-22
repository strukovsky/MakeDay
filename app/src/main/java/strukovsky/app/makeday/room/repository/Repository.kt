package strukovsky.app.makeday.room.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import android.os.AsyncTask
import strukovsky.app.makeday.room.*

/**
 * Created by dmitry on 14.03.2019.
 */

class Repository(context: Context) {
    val database: Database = Database.getInstance(context)
    val timetableDao = database.timetableDao
    val actionDao = database.actionDao
    
    //create
    fun insertTimetable(timetable: Timetable) = AsyncInsertTimetable(timetableDao, timetable).execute().get()!!
    fun insertAction(action: Action) = AsyncInsertAction(actionDao, action).execute().get()!!

    //read
    fun getAllTimetables() = AsyncGetAllTimetables(timetableDao).execute().get()!!
    fun getAllActions() = AsyncGetAllActions(actionDao).execute().get()!!
    fun selectActions(timetable_id: Int, time: String) = AsyncSelectActions(actionDao, timetable_id, time).execute().get()!!
    
    //update
    fun updateTimetable(timetable: Timetable) = AsyncUpdateTimetable(timetableDao, timetable).execute()
    fun updateAction(action: Action) = AsyncUpdateAction(actionDao, action).execute()
    
    //delete
    fun deleteTimetable(timetable: Timetable) = AsyncDeleteTimetable(timetableDao, timetable).execute()
    fun deleteAction(action: Action) = AsyncDeleteAction(actionDao, action).execute()
    
    
    







}