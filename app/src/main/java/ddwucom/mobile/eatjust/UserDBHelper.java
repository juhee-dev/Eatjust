package ddwucom.mobile.eatjust;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class UserDBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "user.db";
    public final static String TABLE_NAME = "user_table";
    UserDBHelper userDBHelper = null;
    Cursor cursor = null;

    public final static String COL_ID = "_id";
    public final static String COL_AGE = "age";
    public final static String COL_HEIGHT = "height";
    public final static String COL_WEIGHT = "weight";
    public final static String COL_PREGNANCY = "pregnancy";
    public final static String COL_CYCLE = "cycle";
    public final static String COL_LATEST = "latest";
    public final static String COL_PCALORIE = "pCalorie";

    public UserDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

//    DB 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_AGE + " TEXT, " + COL_HEIGHT + " TEXT, " + COL_WEIGHT + " TEXT, " +
                COL_PREGNANCY + " TEXT, " + COL_CYCLE + " TEXT, " + COL_LATEST + " TEXT, " + COL_PCALORIE + " TEXT)";
        db.execSQL(sql);
    }

//    DB 업데이트
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
