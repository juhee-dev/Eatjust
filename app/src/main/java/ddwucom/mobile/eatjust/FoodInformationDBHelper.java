package ddwucom.mobile.eatjust;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodInformationDBHelper extends SQLiteOpenHelper {
    final static String TAG = "FoodInformationDBHelper";

    final static String DB_NAME = "information.db";
    public final static String TABLE_NAME = "information_table";

    public final static String COL_ID = "_id";
    public final static String COL_NAME = "name";
    public final static String COL_SERVING = "serving";
    public final static String COL_CALORIE= "calorie";
    public final static String COL_CARBOHYDRATE = "carbohydrate";
    public final static String COL_PROTEIN = "protein";
    public final static String COL_FAT = "fat";

    public FoodInformationDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_NAME + " TEXT, " + COL_SERVING + " TEXT, " + COL_CALORIE + " TEXT, " +
                COL_CARBOHYDRATE + " TEXT, " + COL_PROTEIN  + " TEXT, " + COL_FAT + " TEXT )";
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, '쌀밥', 100, 145.7, 33.20, 3.00, 0.10);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '육개장', 440, 130.33, 6.54, 16.21, 4.37);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '삼겹살', 200, 933.53, 0.69, 45.11, 83.37);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '연어초밥', 250, 447.34, 71.04, 18.88, 9.74);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '햄치즈샌드위치', 240, 433.09, 45.79, 21.15, 18.37);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '양상추샐러드', 150, 189.01, 5.13, 7.36, 15.45);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '작곡밥', 200, 292.62, 58.65, 10.59, 1.74);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '육회비빔밥', 300, 442.31, 68.76, 19.16, 10.07);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '물회', 700, 528.9, 55.3, 34.4, 18.9);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '육회', 150, 195.08, 12.18, 14.9, 9.64);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '돼지곱창순대볶음', 230, 299.11, 42.59, 16.64, 6.91);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '쌀국수', 600, 320.6, 55.1, 15.6, 4.2);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '제육볶음', 250, 487.99, 11.82, 30.37, 35.27);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '돈까스', 200, 463.96, 11.82, 30.37, 35.47);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '고등어구이', 200, 551.75, 0.4, 47.65, 39.95);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '비빔국수', 500, 512.43, 102.36, 14.06, 4.75);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '라면', 550, 450.92, 75.08, 9.48, 12.52);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '잔치국수', 700, 310.17, 56.34, 13.53, 3.41);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '떡볶이', 180, 260, 46.72, 6.31, 5.32);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '치즈케이크', 100, 329.15, 28.64, 7.23, 20.63);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '후라이드치킨', 200, 530.07, 21.29, 35.47, 33.67);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '토마토소스스파게티', 500, 642.55, 93.2, 24.35, 19.15);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '냉면', 700, 384.01, 72.15, 13.75, 4.49);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '전주비빔밥', 450, 691.2, 98.7, 24.6, 22);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '참치마요삼각김밥', 200, 398.69, 50.89, 11.86, 16.41);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '김밥', 230, 322.59, 45.95, 11.14, 10.47);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '라볶이', 200, 268.45, 40.28, 5.65, 9.41);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '차돌박이', 100, 389.26, 0, 16.45, 35.94);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '꽃등심', 100, 320.61, 0, 17.76, 27.73);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '식빵토스트', 100, 365.65, 51.47, 8.78, 13.85);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '핫도그', 100, 267.19, 34.97, 9.09, 10.55);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '햄버거', 200, 527.67, 43.34, 25.69, 27.95);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '감자튀김', 150, 467.75, 52.72, 6.82, 25.51);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '와플', 100, 290.1, 32.9, 7.9, 14.1);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우유', 100, 64.32, 5.53, 3.08, 3.32);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '초코파이', 100, 427.65, 67.59, 4.29, 15.57);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '시리얼(건조과일)', 100, 394.73, 84.66, 5.81, 3.65);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '삶은달걀', 100, 136.25, 2.19, 13.94, 7.97);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '닭가슴살', 100, 120.73, 0, 28.09, 0.93);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}