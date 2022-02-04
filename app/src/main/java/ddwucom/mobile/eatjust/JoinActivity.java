package ddwucom.mobile.eatjust;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class JoinActivity extends AppCompatActivity {
    final int STATE_CODE = 300;

    EditText etAge, etHeight, etWeight, etCycle;
    RadioGroup rg;
    RadioButton rbX, rbO;
    CalendarView calendarView;
    Button btnNext;

    User user;
    UserDBHelper userDBHelper = null;

    int isChecked;
    String latest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        userDBHelper = new UserDBHelper(this);

        etAge = findViewById(R.id.etAge);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        rbX = findViewById(R.id.rbO);
        rbO = findViewById(R.id.rbX);
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rbX.isChecked() == true) {
                    isChecked = 1;
                } else {
                    isChecked = 0;
                }
                Toast.makeText(JoinActivity.this, "isChecked: "+ isChecked, Toast.LENGTH_SHORT).show();
            }
        });
        etCycle = findViewById(R.id.etCycle);
        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                latest = year +"-"+ (month+1) +"-"+ dayOfMonth;
            }
        });

        btnNext = findViewById(R.id.btnNext);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNext:
                user = new User(etAge.getText().toString(), etHeight.getText().toString(),
                        etWeight.getText().toString(), isChecked, etCycle.getText().toString(), latest);
                user.setPCalorie(user.calcPCalorie());

                if (!isTextInputted(user)) {
                    Toast.makeText(JoinActivity.this, "필수 항목을 입력하세요!", Toast.LENGTH_SHORT).show();
                    break;
                }

                SQLiteDatabase db = userDBHelper.getWritableDatabase();
                ContentValues value = new ContentValues();
                value.put(userDBHelper.COL_AGE, user.getAge());
                value.put(userDBHelper.COL_HEIGHT, etHeight.getText().toString());
                value.put(userDBHelper.COL_WEIGHT,  etWeight.getText().toString());
                value.put(userDBHelper.COL_PREGNANCY, isChecked);
                value.put(userDBHelper.COL_CYCLE, etCycle.getText().toString());
                value.put(userDBHelper.COL_LATEST, latest);
                value.put(userDBHelper.COL_PCALORIE, user.getPCalorie());

                long result = db.insert(UserDBHelper.TABLE_NAME, null, value);

                if (result > 0) {
                    Intent intent = new Intent(JoinActivity.this, StateActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                } else {        // 이상에 따른 처리
                    Toast.makeText(this, "리뷰 추가 실패!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    // 필수 항목을 입력하지 않은 상태면 false 반환
    public boolean isTextInputted(User user) {
        if ((user.getAge().length() == 0) || (user.getHeight().length() == 0) || (user.getWeight().length() == 0) || (user.getCycle().length() == 0))
            return false;
        return true;
    }
}