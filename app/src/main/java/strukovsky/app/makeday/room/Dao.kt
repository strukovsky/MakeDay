package strukovsky.app.makeday.room

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
    abstract fun getAllTimetables()

    @Query("DELETE * FROM timetables")
    abstract fun deleteAllTimetables()
}

@Dao abstract class ActionDao
{
    @Insert abstract fun insert(t: Timetable)

    @Query("SELECT * FROM actions")
    abstract fun getAllActions()

    @Query("DELETE * FROM actions")
    abstract fun deleteAllActions()
}