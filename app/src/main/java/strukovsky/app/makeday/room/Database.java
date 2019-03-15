package strukovsky.app.makeday.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.TreeMap;

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
                FillDatabase callback = new FillDatabase(instance);
                instance = Room.databaseBuilder(context, Database.class, "app_db").fallbackToDestructiveMigration()
                        .addCallback(callback)
                .build();
            }
        }
        return instance;
    }

    static class FillDatabase extends RoomDatabase.Callback{

        private Database db;

        FillDatabase(Database db)
        {
            this.db = db;
        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            TimetableDao timetableDao = this.db.getTimetableDao();
            ActionDao actionDao = this.db.getActionDao();

            timetableDao.insert(new Timetable(0, "name", "description",new TreeMap<Integer, String>()));
            actionDao.insert(new Action(0, "action", 0, "desc_action", "8"));
        }
    }
}
