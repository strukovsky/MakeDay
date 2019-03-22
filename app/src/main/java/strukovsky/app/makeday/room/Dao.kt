package strukovsky.app.makeday.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by dmitry on 14.03.2019.
 */

@Dao abstract class TimetableDao
{
    @Insert abstract fun insert(t: Timetable)

    @Query("SELECT * FROM timetables")
    abstract fun getAllTimetables(): LiveData<List<Timetable>>



}

@Dao abstract class ActionDao
{
    @Insert abstract fun insert(t: Timetable)

    @Query("SELECT * FROM actions")
    abstract fun getAllActions(): LiveData<List<Action>>

    @Query("SELECT * FROM actions WHERE timetable_id = :timetable_id AND time = :time")
    abstract fun selectActions(timetable_id: Int, time: String): LiveData<List<Action>>

}