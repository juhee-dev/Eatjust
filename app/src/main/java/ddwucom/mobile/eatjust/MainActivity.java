package ddwucom.mobile.eatjust;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final int REQ_CODE = 100;
    final int JOIN_CODE = 200;
    final int STATE_CODE = 300;
    final int CALENDAR_CODE = 400;
    final int FOOD_CODE = 500;

    Button btnStart;

    UserDBHelper userDBHelper;
    SQLiteDatabase db;
    User user;
    Cursor cursor1;
    public int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDBHelper = new UserDBHelper(this);
        db = userDBHelper.getReadableDatabase();

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;

                db = userDBHelper.getReadableDatabase();
                cursor1 = db.rawQuery("SELECT * FROM " + UserDBHelper.TABLE_NAME, null);
                cursor1.moveToFirst();

                if (cursor1.getCount() > 0) { // 데이터 존재하면 상태화면
                        String age = cursor1.getString(1);
                        String height = cursor1.getString(2);
                        String weight = cursor1.getString(3);
                        int pregnancy = cursor1.getColumnIndex(UserDBHelper.COL_PREGNANCY);
                        String cycle = cursor1.getString(5);
                        String latest = cursor1.getString(6);

                        user = new User(age, height, weight, pregnancy, cycle, latest);
                        user.setPCalorie(user.calcPCalorie());

                        intent = new Intent(MainActivity.this, StateActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                } else { // 데이터 존재하지 않으면 가입화면
                    intent = new Intent(MainActivity.this, JoinActivity.class);
                    startActivityForResult(intent, JOIN_CODE);
                }
                cursor1.close();
                userDBHelper.close();
            }
        });
    }
}
