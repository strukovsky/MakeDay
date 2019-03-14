package strukovsky.app.makeday.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * Created by dmitry on 14.03.2019.
 */

@Entity(tableName = "timetables")
data class Timetable(@PrimaryKey var id: Int,
                     @ColumnInfo(name = "name") var name: String,
                     @ColumnInfo(name = "name") var description: String

)

@Entity(tableName = "actions", foreignKeys = arrayOf(
        ForeignKey(entity = Timetable::class, parentColumns = arrayOf("id"),
                childColumns = arrayOf("timetable_id"))
))
data class Action(@PrimaryKey var id: Int,
                  @ColumnInfo(name = "timetable_id") var timetable_id: Int,
                  @ColumnInfo(name = "name") var name: String,
                  @ColumnInfo(name = "description") var description: String,
                  @ColumnInfo(name = "time") var time: String
)