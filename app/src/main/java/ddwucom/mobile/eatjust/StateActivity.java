package ddwucom.mobile.eatjust;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import ddwucom.mobile.eatjust.FoodDBManager;
import ddwucom.mobile.eatjust.Food;
import ddwucom.mobile.eatjust.FoodDBHelper;
import ddwucom.mobile.eatjust.RandomText;
import ddwucom.mobile.eatjust.User;
import ddwucom.mobile.eatjust.UserDBHelper;

public class StateActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    TextView textView3;
    UserDBHelper userDBHelper;
    FoodDBManager foodDBManager;
    SQLiteDatabase db = null;
    Cursor cursor1;
    RandomText randomText;
    Food food;

//    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        User use;
        Calendar now = Calendar.getInstance();
//        now.setTime(date);
        textView = (TextView) findViewById(R.id.textView3);
        textView2 = (TextView)findViewById(R.id.textView14);
        textView3 = (TextView)findViewById(R.id.textView15);
        userDBHelper = new UserDBHelper(this);
        db = userDBHelper.getReadableDatabase();
        foodDBManager = new FoodDBManager(this);
        food = foodDBManager.getFood(now.toString());
        Random r = new Random();

        cursor1 = db.rawQuery("SELECT * FROM " + UserDBHelper.TABLE_NAME, null);
        cursor1.moveToFirst();
        if (cursor1.getCount() > 0) {
            Log.v("test", "3");
            String age = cursor1.getString(1);
            String height = cursor1.getString(2);
            String weight = cursor1.getString(3);
            int pregnancy = cursor1.getInt(4);
            String cycle = cursor1.getString(5);
            String latest = cursor1.getString(6);
            Log.v("test", "4");
            use = new User(age, height, weight, pregnancy, cycle, latest);
            use.setPCalorie(use.calcPCalorie());
        } else {
            use = new User("0", "0", "0", 0, "0", "0");
        }

        long diffSec, diffSec2;
        long diffDays, diffDays2;
        int cabSum, fatSum, proSum; //각각 탄단지 합임.
        int calSum = 0;//칼로리합
        double stWeight = (Integer.parseInt(use.getHeight()) * Integer.parseInt(use.getHeight()) * 21) /100 ;
        Log.v("test", String.valueOf(stWeight));

//        switch문 대신 if문을 쓴 이유: 임신했을 때, 현재 월경주기인 경우, 월경이 아닌 경우로 단축됨
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat: 날짜 받는 포맷을 정해준다.
        if (use.getPregnancy() == 1) {
            int p = r.nextInt(3);
            String preg = "";
            String[] pregnancy = {"임신 초기에는 단백질 섭취가 필수적입니다. 두부나 흰살 생선, 지방이 들어가지 않은 육류를 추천드립니다.\n 지방없는 육류에는 여성에게 필요한 철분, 아연, 비타민도 풍부하니 섭취해주세요.",
                    "임신 중에 칼슘이 아기의 뼈 형성에 도움을 주면서 임산부에게 결핍되기 쉽습니다. 우유나 유제품에 칼슘이 풍부하니 섭취하시는 것을 추천드립니다.\n",
                    "임신 중기에는 철분이 절대적으로 필요합니다. 소나 돼지의 간, 닭고기, 달걀 노른자, 건포도에 철분이 많이 함유되어 있습니다. \n 참고하시고 섭취해주세요.\n"
            };

            preg = " 임신중이시네요. "+ pregnancy[p];
            Log.v("state", String.valueOf(use.getPregnancy()));
            textView3.setText(preg);
        } else {
//            *주의: 정확하지 않은 결과 값이 나올 것 같다. ex)월경 주기가 30일(31) 한달 미만이거나 한달 초과 시 정확한 결과가 나오지 않음.
            try {
//                Date today = new Date(String.valueOf(sdf.parse(db2.query("user_table", new String[]{"COL_DATE"}, null, null, null, null, null).toString())));
                Date d = new Date(String.valueOf(sdf.parse(use.getLatest())));
                Calendar latest = Calendar.getInstance();
                Calendar td = Calendar.getInstance();
//                td.setTime(today);
                latest.setTime(d);
                String monthly = "";

                diffSec = (cal.getTimeInMillis() - latest.getTimeInMillis()) / 1000;
                diffDays = diffSec / (24 * 60 * 60); //일자수 차이

                diffSec2 = (cal.getTimeInMillis() - td.getTimeInMillis()) / 1000;
                diffDays2 = diffSec2 / (24 * 60 * 60);

                int cycle = Integer.parseInt(use.getCycle());
                Log.v("state", String.valueOf(diffDays)); //31
                Log.v("state", String.valueOf(cycle)); //30
                if ((cycle <= diffDays ) && (diffDays <= cycle + 5)) {
                    Log.v("state", String.valueOf(diffDays));
                    Log.v("state", String.valueOf(cycle));


                    String[] month = {
                            "철분은 월경 중 가장 많이 손실됩니다. 브로콜리, 양배추, 닭고기에 철분이 많아서 회복에 많은 도움이 됩니다.\n 특히 브로콜리에는 섬유질, 마그네슘, 칼륨도 풍부해서 소화력과 근육 이완에 도움을 줍니다.\n",
                            "바나나는 칼륨, 마그네슘, 섬유질이 많아 간식으로 먹으면 좋아요.\n 불규칙한 배변, 식사 후 간식 관리하는 데 도움이 됩니다.\n",
                            "고등어 구이는 오메가3, 마그네슘를 함유하고 있습니다.\n 월경 주간 동안 고등어 구이를 섭취하면 염증도 줄고 경련을 완화시킬 수 있어요.\n",
                            // "생강은 염증 억제 및 생리통 완화에 도움을 줍니다. 복부가 불편하다면 생강차를 드시는 것을 권장드려요.\n",
                            "감귤류의 과일은 비타민 외에도 섬유질과 수분이 많아 수분 충전 및 소화 기능 개선에 도움이 됩니다.\n 출혈이 심한 경우 이를 줄이는 효과도 있어요.\n",
                            "꾸준한 수분 섭취가 필요합니다. 물을 자주 마시고, 수분이 많은 음식 중에 수박과 오이가 있으니 참고하고 섭취해주세요.\n",
                            "견과류에는 단백질과 마그네슘, 비타민이 함유되어 있어 간식으로 섭취하시면 좋습니다.\n ",
                            "요거트에는 마그네슘과 칼륨이 풍부합니다. 월경 중에 섭취하면 염증 완화에 도움이 됩니다.\n",
                            "두부에는 철과 마그네슘, 칼슘이 들어 있습니다. 월경통 완화와 철분 회복에 도움을 줍니다.\n"
                    };
                    int m = r.nextInt(8);

                    monthly = "지금 월경 주기시겠군요." + month[m] + "\n\n";
//                        monthly += "현재 체중은 " + use.getWeight()+"이고, 표준 체중과 조정 체중은 각각 " +stWeight + ", " +(stWeight + (Double.parseDouble((use.getWeight())) - stWeight * 0.25))+ "입니다. 권장 칼로리는 " + use.calcPCalorie() + "칼로리 입니다. 앞으로 식단 관리를 잇저스트와 함께해요'-'!";
                    textView2.setText(monthly);
                }
            } catch (NullPointerException | ParseException e) {
                e.printStackTrace();
            }

            String hello;
//                     신규 가입자인 경우
            if(food.getbCalorie() == 0 || food.getlCalorie() == 0 || food.getdCalorie() == 0) {
                hello = "안녕하세요 나이는 "+ use.getAge() +", 키는 "+ use.getHeight() +", 몸무게는 " + use.getWeight() + "입니다.\n권장 칼로리는 " + use.calcPCalorie() + "칼로리 입니다.\n 앞으로 식단 관리를 잇저스트와 함께해요'-'!";
                Log.v("test", String.valueOf((stWeight + (Double.parseDouble((use.getWeight())) - stWeight * 0.25))));
                Log.v("test", String.valueOf(use.calcPCalorie()));

                textView.setText(hello);
            }
            else if(food.getbCalorie() != 0 && food.getlCalorie() != 0 && food.getdCalorie() != 0){
                calSum = food.getbCalorie() + food.getlCalorie() + food.getdCalorie();
                cabSum = food.getbCarbohydrate() + food.getlCarbohydrate() + food.getdCarbohydrate();
                proSum = food.getbProtein() + food.getlProtein() + food.getdProtein();
                fatSum = food.getbFat() + food.getlFat() + food.getdFat();

//                칼로리 가이드
                hello = "오늘 식단의 칼로리는" +calSum + "탄수화물, 단백질, 지방은 각각 " + cabSum + ", " + proSum + "," + fatSum
                        +"입니다.";
                if((cabSum <= proSum) && (fatSum <= proSum)){
                    if(cabSum <= fatSum){
                        hello += "현재 탄수화물 섭취량이 가장 적고, 단백질 섭취량이 많습니다.";
                    }
                    else{
                        hello += "현재 지방 섭취량이 가장 적고, 단백질 섭취량이 많습니다.";
                    }
                }
                else if((proSum <= cabSum) && (fatSum <= cabSum)){
                    if(proSum <= fatSum){
                        hello += "현재 단백질 섭취량이 가장 적고, 탄수화물 섭취량이 많습니다. 탄수화물 섭취량 조절이 필요합니다.";
                    }
                    else{
                        hello += "현재 지방 섭취량이 가장 적고, 탄수화물 섭취량이 많습니다. 탄수화물 섭취량 조절이 필요합니다.";
                    }
                }
                else{
                    if(cabSum <= proSum){
                        hello += "현재 탄수화물 섭취량이 가장 적고, 지방 섭취량이 많습니다. 지방 섭취량 조절이 필요합니다.";
                    }
                    else
                        hello += "현재 단백질 섭취량이 가장 적고, 지방 섭취량이 많습니다. 지방 섭취량을 줄이고 단백질 섭취량을 늘려주세요.";
                }
                textView.setText(hello);
            }
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGoToCalendar:
                Intent intent1 = new Intent(StateActivity.this, CalendarActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnGoToFood:
                final PopupMenu popupMenu = new PopupMenu(getApplicationContext(), v);
                getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    Intent intent;

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.mnB) {
                            intent = new Intent(StateActivity.this, FoodActivity.class);
                            intent.putExtra("when", "B");
                            startActivity(intent);
                        } else if (item.getItemId() == R.id.mnL) {
                            intent = new Intent(StateActivity.this, FoodActivity.class);
                            intent.putExtra("when", "L");
                            startActivity(intent);
                        } else {
                            intent = new Intent(StateActivity.this, FoodActivity.class);
                            intent.putExtra("when", "D");
                            startActivity(intent);
                        }
                        return true;
                    }
                });
                break;
        }
    }
}