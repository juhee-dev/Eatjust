package ddwucom.mobile.eatjust;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FoodInformationDBManager {
    FoodInformationDBHelper informationDBHelper = null;
    Cursor cursor = null;

    public FoodInformationDBManager(Context context) {
        informationDBHelper = new FoodInformationDBHelper(context);
    }
    public ArrayList<FoodInformation> getFoodByName(String foodName) {
        ArrayList<FoodInformation> inList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = informationDBHelper.getReadableDatabase();
        String[] columns = null;
        String whereClause = informationDBHelper.COL_NAME + "=?";
        String[] whereArgs = new String[]{foodName};
        Cursor cursor = sqLiteDatabase.query(informationDBHelper.TABLE_NAME, columns, whereClause, whereArgs, null, null, null, null);
        while(cursor.moveToNext()) {
            //String id = cursor.getString(cursor.getColumnIndex(FoodInformationDBHelper.COL_ID));
            //String name = cursor.getString(cursor.getColumnIndex(FoodInformationDBHelper.COL_NAME));
            String name = cursor.getString(cursor.getColumnIndex(FoodInformationDBHelper.COL_NAME));
            int serving = cursor.getInt(cursor.getColumnIndex(FoodInformationDBHelper.COL_SERVING));
            float calorie = cursor.getFloat(cursor.getColumnIndex(FoodInformationDBHelper.COL_CALORIE));
            float carbonhydrate = cursor.getFloat(cursor.getColumnIndex(FoodInformationDBHelper.COL_CARBOHYDRATE));
            float protein = cursor.getFloat(cursor.getColumnIndex(FoodInformationDBHelper.COL_PROTEIN));
            float fat = cursor.getFloat(cursor.getColumnIndex(FoodInformationDBHelper.COL_FAT));
            //inList.add( new FoodInformation(id, image, name, author, publisher, price, rating));
            inList.add(new FoodInformation(name, serving, calorie, carbonhydrate, protein, fat));
        }
        cursor.close();
        informationDBHelper.close();
        return inList;
    }
}
