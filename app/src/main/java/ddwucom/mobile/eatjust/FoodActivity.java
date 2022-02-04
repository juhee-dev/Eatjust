package ddwucom.mobile.eatjust;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class FoodActivity extends AppCompatActivity {

    static final int RESULT_LOAD_IMAGE = 1;
    ImageView imageView;
    EditText etFood_1, etFood_2, etFood_3, etFood_4;
    TextView tvServing_1, tvServing_2, tvServing_3, tvServing_4;
    TextView tvKcal_1, tvKcal_2, tvKcal_3, tvKcal_4;
    TextView tvCarb_1, tvCarb_2, tvCarb_3, tvCarb_4;
    TextView tvProtein_1, tvProtein_2, tvProtein_3, tvProtein_4;
    TextView tvFat_1, tvFat_2, tvFat_3, tvFat_4;
    TextView tvTotalKcal, tvTotalCarb, tvTotalProtein, tvTotalFat;
    Button btnCamera, btnSubmit;

    FoodDBHelper foodDBHelper = null;
    SQLiteDatabase db;
    SQLiteStatement p;
    String foodName1, foodName2, foodName3, foodName4;
    FoodInformationDBManager foodInformationDBManager;
    Intent intent;

    float totalKcal = 0, totalCarb = 0, totalProtein = 0, totalFat = 0;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        foodDBHelper = new FoodDBHelper(this);

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        date = year + "-" + (month + 1) + "-" + day;

        etFood_1 = findViewById(R.id.etFood_1);
        etFood_2 = findViewById(R.id.etFood_2);
        etFood_3 = findViewById(R.id.etFood_3);
        etFood_4 = findViewById(R.id.etFood_4);
        tvServing_1 = findViewById(R.id.tvServing_1);
        tvServing_2 = findViewById(R.id.tvServing_2);
        tvServing_3 = findViewById(R.id.tvServing_3);
        tvServing_4 = findViewById(R.id.tvServing_4);
        tvKcal_1 = findViewById(R.id.tvKcal_1);
        tvKcal_2 = findViewById(R.id.tvKcal_2);
        tvKcal_3 = findViewById(R.id.tvKcal_3);
        tvKcal_4 = findViewById(R.id.tvKcal_4);
        tvCarb_1 = findViewById(R.id.tvCarb_1);
        tvCarb_2 = findViewById(R.id.tvCarb_2);
        tvCarb_3 = findViewById(R.id.tvCarb_3);
        tvCarb_4 = findViewById(R.id.tvCarb_4);
        tvProtein_1 = findViewById(R.id.tvProtein_1);
        tvProtein_2 = findViewById(R.id.tvProtein_2);
        tvProtein_3 = findViewById(R.id.tvProtein_3);
        tvProtein_4 = findViewById(R.id.tvProtein_4);
        tvFat_1 = findViewById(R.id.tvFat_1);
        tvFat_2 = findViewById(R.id.tvFat_2);
        tvFat_3 = findViewById(R.id.tvFat_3);
        tvFat_4 = findViewById(R.id.tvFat_4);
        tvTotalKcal = findViewById(R.id.tvTotalKcal);
        tvTotalCarb = findViewById(R.id.tvTotalCarb);
        tvTotalProtein = findViewById(R.id.tvTotalProtein);
        tvTotalFat = findViewById(R.id.tvTotalFat);
        btnCamera = findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    public void onClick(View v){
        foodInformationDBManager = new FoodInformationDBManager(this);
        switch (v.getId()) {
            case R.id.btnFoodSubmit:
                totalKcal = 0;
                totalCarb = 0;
                totalProtein = 0;
                totalFat = 0;
                if (!etFood_1.getText().toString().equals("")) {
                    Log.d("mytag", "1");
                    foodName1 = etFood_1.getText().toString();
                    ArrayList<FoodInformation> searchInfo = foodInformationDBManager.getFoodByName(foodName1);
                    FoodInformation foodInformation = searchInfo.get(0);
                    Log.d("mytag", foodName1);
                    Log.d("mytag", String.valueOf(foodInformation.getCalorie()));
                    tvServing_1.setText(String.valueOf(foodInformation.getServing()));
                    tvKcal_1.setText(String.valueOf(foodInformation.getCalorie()));
                    tvCarb_1.setText(String.valueOf(foodInformation.getCarbohydrate()));
                    tvProtein_1.setText(String.valueOf(foodInformation.getProtein()));
                    tvFat_1.setText(String.valueOf(foodInformation.getFat()));
                    totalKcal += foodInformation.getCalorie();
                    totalCarb += foodInformation.getCarbohydrate();
                    totalProtein += foodInformation.getProtein();
                    totalFat += foodInformation.getFat();
                }
                if (!etFood_2.getText().toString().equals("")) {
                    Log.d("mytag", "2");
                    foodName2 = etFood_2.getText().toString();
                    ArrayList<FoodInformation> searchInfo = foodInformationDBManager.getFoodByName(foodName2);
                    FoodInformation foodInformation = searchInfo.get(0);
                    Log.d("mytag", String.valueOf(foodInformation.getCalorie()));
                    tvServing_2.setText(Integer.toString(foodInformation.getServing()));
                    tvKcal_2.setText(String.valueOf(foodInformation.getCalorie()));
                    tvCarb_2.setText(String.valueOf(foodInformation.getCarbohydrate()));
                    tvProtein_2.setText(String.valueOf(foodInformation.getProtein()));
                    tvFat_2.setText(String.valueOf(foodInformation.getFat()));
                    totalKcal += foodInformation.getCalorie();
                    totalCarb += foodInformation.getCarbohydrate();
                    totalProtein += foodInformation.getProtein();
                    totalFat += foodInformation.getFat();
                }
                if (!etFood_3.getText().toString().equals("")) {
                    Log.d("mytag", "3");
                    foodName3 = etFood_3.getText().toString();
                    ArrayList<FoodInformation> searchInfo = foodInformationDBManager.getFoodByName(foodName3);
                    FoodInformation foodInformation = searchInfo.get(0);
                    Log.d("mytag", String.valueOf(foodInformation.getCalorie()));
                    tvServing_3.setText(Integer.toString(foodInformation.getServing()));
                    tvKcal_3.setText(String.valueOf(foodInformation.getCalorie()));
                    tvCarb_3.setText(String.valueOf(foodInformation.getCarbohydrate()));
                    tvProtein_3.setText(String.valueOf(foodInformation.getProtein()));
                    tvFat_3.setText(String.valueOf(foodInformation.getFat()));
                    totalKcal += foodInformation.getCalorie();
                    totalCarb += foodInformation.getCarbohydrate();
                    totalProtein += foodInformation.getProtein();
                    totalFat += foodInformation.getFat();
                }
                if (!etFood_4.getText().toString().equals("")) {
                    Log.d("mytag", "4");
                    foodName4 = etFood_4.getText().toString();
                    ArrayList<FoodInformation> searchInfo = foodInformationDBManager.getFoodByName(foodName4);
                    FoodInformation foodInformation = searchInfo.get(0);
                    Log.d("mytag", String.valueOf(foodInformation.getCalorie()));
                    tvServing_4.setText(Integer.toString(foodInformation.getServing()));
                    tvKcal_4.setText(String.valueOf(foodInformation.getCalorie()));
                    tvCarb_4.setText(String.valueOf(foodInformation.getCarbohydrate()));
                    tvProtein_4.setText(String.valueOf(foodInformation.getProtein()));
                    tvFat_4.setText(String.valueOf(foodInformation.getFat()));
                    totalKcal += foodInformation.getCalorie();
                    totalCarb += foodInformation.getCarbohydrate();
                    totalProtein += foodInformation.getProtein();
                    totalFat += foodInformation.getFat();
                }
                tvTotalKcal.setText(Float.toString(totalKcal));
                tvTotalCarb.setText(Float.toString(totalCarb));
                tvTotalProtein.setText(Float.toString(totalProtein));
                tvTotalFat.setText(Float.toString(totalFat));
                break;
            case R.id.btnSubmit:
                SQLiteDatabase db = foodDBHelper.getWritableDatabase();
                ContentValues value = new ContentValues();
                intent = getIntent();
                if(intent.getStringExtra("when").equals("B")) {
                    value.put(foodDBHelper.COL_DATE, date);
                    value.put(foodDBHelper.COL_BCALORIE, tvTotalKcal.getText().toString());
                    value.put(foodDBHelper.COL_BCARBOHYDRATE, tvTotalCarb.getText().toString());
                    value.put(foodDBHelper.COL_BPROTEIN, tvTotalProtein.getText().toString());
                    value.put(foodDBHelper.COL_BFAT, tvTotalFat.getText().toString());
                } else if(intent.getStringExtra("when").equals("L")) {
                    value.put(foodDBHelper.COL_DATE, date);
                    value.put(foodDBHelper.COL_LCALORIE, tvTotalKcal.getText().toString());
                    value.put(foodDBHelper.COL_LCARBOHYDRATE, tvTotalCarb.getText().toString());
                    value.put(foodDBHelper.COL_LPROTEIN, tvTotalProtein.getText().toString());
                    value.put(foodDBHelper.COL_LFAT, tvTotalFat.getText().toString());
                } else {
                    value.put(foodDBHelper.COL_DATE, date);
                    value.put(foodDBHelper.COL_DCALORIE, tvTotalKcal.getText().toString());
                    value.put(foodDBHelper.COL_DCARBOHYDRATE, tvTotalCarb.getText().toString());
                    value.put(foodDBHelper.COL_DPROTEIN, tvTotalProtein.getText().toString());
                    value.put(foodDBHelper.COL_DFAT, tvTotalFat.getText().toString());
                }
                Cursor cursor = db.rawQuery("SELECT * FROM " + FoodDBHelper.TABLE_NAME + " WHERE DATE = '" + date + "';", null);
                cursor.moveToFirst();
                if (cursor.getCount() == 0) {// 오늘 날짜의 데이터가 없으면 raw 생성
                    db.insert(FoodDBHelper.TABLE_NAME, null, value);
                    Log.d("FoodDB", "count: "+ cursor.getCount());
                } else {
                    db.update(foodDBHelper.TABLE_NAME, value, "DATE = ?", new String[]{date});
                    Log.d("FoodDB", "count: " + cursor.getCount());
                }

                    Toast.makeText(FoodActivity.this, "식단 입력 완료!", Toast.LENGTH_SHORT).show();

                cursor.close();
                foodDBHelper.close();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            imageView = (ImageView) findViewById(R.id.imageView);

            Bitmap bmp = null;
//            byte[] bytes = null;

            try {
                bmp = getBitmapFromUri(selectedImage);
//                db 저장.. 사진 db를 따로 만드는게 좋을듯. 근데 날짜별로 db를 어케 만들지 흐으므므으음
//                bytes = getByteFromBitmap(bmp);
//                p = db.compileStatement("INSERT INTO "+ foodDBHelper.TABLE_NAME +" values(?);");
//                p.bindBlob(1, bytes);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imageView.setImageBitmap(bmp);
        }
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();

        return image;
    }

    public byte[] getByteFromBitmap(Bitmap bmp) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] data = stream.toByteArray();

        return data;
    }
}
