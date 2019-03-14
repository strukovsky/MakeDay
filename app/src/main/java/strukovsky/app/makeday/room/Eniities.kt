package strukovsky.app.makeday.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by dmitry on 14.03.2019.
 */

@Entity(tableName = "timetables") data class Timetable(@PrimaryKey var id: Int, var name: String)

@Entity(tableName = "actions")
data class Action(@PrimaryKey var id: Int,
                  var name: String,
                  var description: String,
                  var time: String
)