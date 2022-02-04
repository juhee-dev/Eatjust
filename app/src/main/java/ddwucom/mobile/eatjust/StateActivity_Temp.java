package ddwucom.mobile.eatjust;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StateActivity_Temp extends AppCompatActivity {
    UserDBHelper userDBHelper = null;
    SQLiteDatabase db;
    User user = null;

    TextView tvAge, tvHeight, tvWeight, tvPCalorie;
    Button btnToFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_temp);

        userDBHelper = new UserDBHelper(this);

        tvAge = findViewById(R.id.tvAge);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);
        tvPCalorie = findViewById(R.id.tvPCalorie);
        btnToFood = findViewById(R.id.btnToFood);
        btnToFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StateActivity_Temp.this, FoodActivity.class));
            }
        });

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");

        tvAge.setText(user.getAge());
        tvHeight.setText(user.getHeight());
        tvWeight.setText(user.getWeight());
        tvPCalorie.setText(String.valueOf(user.getPCalorie()));
    }


}
