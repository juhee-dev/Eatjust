package ddwucom.mobile.eatjust;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodDBHelper extends SQLiteOpenHelper {
    final static String TAG = "FoodDBHelper";

    final static String DB_NAME = "food.db";
    public final static String TABLE_NAME = "food_table";

    public final static String COL_ID = "_id";
    public final static String COL_DATE = "date";

    public final static String COL_BPHOTO = "bPhoto";
    public final static String COL_BCALORIE = "bCalorie";
    public final static String COL_BCARBOHYDRATE = "bCarbohydrate";
    public final static String COL_BPROTEIN = "bProtein";
    public final static String COL_BFAT= "bFat";

    public final static String COL_LPHOTO = "lPhoto";
    public final static String COL_LCALORIE = "lCalorie";
    public final static String COL_LCARBOHYDRATE = "lCarbohydrate";
    public final static String COL_LPROTEIN = "lProtein";
    public final static String COL_LFAT= "lFat";

    public final static String COL_DPHOTO = "dPhoto";
    public final static String COL_DCALORIE = "dCalorie";
    public final static String COL_DCARBOHYDRATE = "dCarbohydrate";
    public final static String COL_DPROTEIN = "dProtein";
    public final static String COL_DFAT= "dFat";

    FoodDBHelper foodDBHelper = null;
    SQLiteDatabase db;

    public FoodDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_DATE + " TEXT, " + COL_BPHOTO + " BLOB, " + COL_BCALORIE + " TEXT, " +
                COL_BCARBOHYDRATE + " TEXT, " + COL_BPROTEIN + " TEXT, " + COL_BFAT  + " TEXT, " +
                COL_LPHOTO + " BLOB, " + COL_LCALORIE + " TEXT, " + COL_LCARBOHYDRATE + " TEXT, " +
                COL_LPROTEIN + " TEXT, " + COL_LFAT  + " TEXT, " +
                COL_DPHOTO + " BLOB, " + COL_DCALORIE + " TEXT, " + COL_DCARBOHYDRATE + " TEXT, " +
                COL_DPROTEIN + " TEXT, " + COL_DFAT  + " TEXT )";
        db.execSQL(sql);
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
//                COL_DATE + " TEXT, " + COL_BCALORIE + " TEXT, " + COL_BFAT + " TEXT, " +
//                COL_BPROTEIN + " TEXT, " + COL_BCARBOHYDRATE  + " TEXT, " +
//                COL_LCALORIE + " TEXT, " + COL_LFAT + " TEXT, " +
//                COL_LPROTEIN + " TEXT, " + COL_LCARBOHYDRATE  + " TEXT, " +
//                COL_DCALORIE + " TEXT, " + COL_DFAT + " TEXT, " +
//                COL_DPROTEIN + " TEXT, " + COL_DCARBOHYDRATE  + " TEXT )";
//        db.execSQL(sql);
//
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '2021-8-8', 900, 20, 90, 90, 900, 40, 80, 80, 1000, 80, 35, 35);");
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '2021-8-9', 1250, 50, 50, 150, 1500, 100, 100, 50, 1500, 100, 50, 100);");
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '2021-8-10', 1500, 100, 50, 100, 1250, 50, 50, 150, 1500, 100, 100, 50);");
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '2021-8-11', 1500, 100, 100, 50, 1500, 100, 50, 100, 1250, 50, 50, 150);");
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '2021-8-12', 1250, 50, 50, 150, 1500, 100, 100, 50, 1500, 100, 50, 100);");
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '2021-8-13', 1500, 100, 50, 100, 1250, 50, 50, 150, 1500, 100, 100, 50);");
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
