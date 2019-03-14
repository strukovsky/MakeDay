package strukovsky.app.makeday.room;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by dmitry on 14.03.2019.
 */

@android.arch.persistence.room.Database(entities = {Timetable.class, Action.class}, version = 1)
public abstract class Database extends RoomDatabase{
    private static Database instance = null;

    public abstract TimetableDao getTimetableDao();
    public abstract ActionDao getActionDao();

    public static Database getInstance(Context context)
    {
        if(instance == null)
        synchronized (Database.class)
        {
            if(instance == null)
            {
                instance = Room.databaseBuilder(context, Database.class, "app_db").fallbackToDestructiveMigration()
                .build();
            }
        }
        return instance;
    }
}
