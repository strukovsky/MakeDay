package strukovsky.app.makeday.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by dmitry on 14.03.2019.
 */

@Dao
abstract class TimetableDao {
    @Insert
    abstract fun insert(t: Timetable)

    @Query("SELECT * FROM timetables")
    abstract fun getAllTimetables(): LiveData<List<Timetable>>

    @Update
    abstract fun update(t: Timetable)

    @Delete
    abstract fun delete(t: Timetable)


}

@Dao
abstract class ActionDao {
    @Insert
    abstract fun insert(a: Action)

    @Query("SELECT * FROM actions")
    abstract fun getAllActions(): LiveData<List<Action>>

    @Query("SELECT * FROM actions WHERE timetable_id = :timetable_id AND time = :time")
    abstract fun selectActions(timetable_id: Int, time: String): LiveData<List<Action>>

    @Update
    abstract fun update(a: Action)

    @Delete
    abstract fun delete(a: Action)


    @Query("SELECT * FROM actions WHERE timetable_id = :timetable_id")
    abstract fun selectActionsByTimetable(timetable_id: Int): LiveData<List<Action>>


}