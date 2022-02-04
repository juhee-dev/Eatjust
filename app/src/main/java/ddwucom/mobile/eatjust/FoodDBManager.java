package ddwucom.mobile.eatjust;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FoodDBManager {

    FoodDBHelper foodDBHelper = null;
    Cursor cursor = null;

    public FoodDBManager(Context context) {
        foodDBHelper = new FoodDBHelper(context);
    }

    //    DB의 해당 날짜 food를 반환
    public Food getFood(String date2) {
        Food food;
        SQLiteDatabase db = foodDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + FoodDBHelper.TABLE_NAME + " WHERE date='" + date2 + "';", null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0) {
            long id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
            String date = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_DATE));
            int bCalorie = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_BCALORIE));
            int bFat = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_BFAT));
            int bProtein = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_BPROTEIN));
            int bCarbohydrate = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_BCARBOHYDRATE));

            int lCalorie = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_LCALORIE));
            int lFat = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_LFAT));
            int lProtein = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_LPROTEIN));
            int lCarbohydrate = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_LCARBOHYDRATE));

            int dCalorie = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_DCALORIE));
            int dFat = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_DFAT));
            int dProtein = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_DPROTEIN));
            int dCarbohydrate = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_DCARBOHYDRATE));

            food = new Food(id, date, bCalorie, bFat, bProtein, bCarbohydrate, lCalorie, lFat, lProtein, lCarbohydrate, dCalorie, dFat, dProtein, dCarbohydrate);
        } else {
            food = new Food(0, "0", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        }
        cursor.close();
        foodDBHelper.close();
        return food;
    }

    //    close 수행
    public void close() {
        if (foodDBHelper != null) foodDBHelper.close();
        if (cursor != null) cursor.close();
    };
}



