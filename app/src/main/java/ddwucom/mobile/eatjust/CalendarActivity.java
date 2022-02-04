package ddwucom.mobile.eatjust;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    PieChart pieChart;
    Food food;
    CalendarView calendar;
    TextView forDate;
    TextView forCalorie;
    FoodDBManager foodDBManager;
    String date2;

    int totalCalorie, fat, protein, car;
    double fatP, proteinP, carP;

    Date mDate = new Date(System.currentTimeMillis());

    SimpleDateFormat simpleDate = new SimpleDateFormat("M/dd");
    String getTime = simpleDate.format(mDate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        pieChart = findViewById(R.id.pieChart);

        calendar = findViewById(R.id.calendarView);
        forDate = findViewById(R.id.textView1);
        forCalorie = findViewById(R.id.textView2);

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        foodDBManager = new FoodDBManager(this);

        date2 = year + "-" + (month + 1) + "-" + day;
        food = foodDBManager.getFood(date2);
        totalCalorie = food.getbCalorie() + food.getlCalorie() + food.getdCalorie();
        forCalorie.setText(String.valueOf(totalCalorie) + "kcal");

        forDate.setText(getTime);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (month + 1) + "/" + dayOfMonth;
                forDate.setText(date);

                date2 = year + "-" + (month + 1) + "-" + dayOfMonth;
                food = foodDBManager.getFood(date2);
                int totalCalorie = food.getbCalorie() + food.getlCalorie() + food.getdCalorie();
                forCalorie.setText(String.valueOf(totalCalorie) + "kcal");

                pieChart.setUsePercentValues(true);
                pieChart.getDescription().setEnabled(false);
                pieChart.setExtraOffsets(5,10,5,5);

                pieChart.setDragDecelerationFrictionCoef(0.95f);

//        pieChart.setDrawHoleEnabled(false); //가운데에 빈공간 만들것인
                pieChart.setHoleColor(Color.WHITE);
                pieChart.setTransparentCircleRadius(61f);

                ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

                fat = food.getbFat() + food.getlFat() + food.getdFat();
                fatP = ((double)((double)(fat * 9) / (double)totalCalorie) * 100);
                protein = food.getbProtein() + food.getlProtein() + food.getdProtein();
                proteinP = ((double)((double)(protein * 4) / (double)totalCalorie) * 100);
                car = food.getbCarbohydrate() + food.getlCarbohydrate() + food.getdCarbohydrate();
                carP = ((double)((double)(car * 4) / (double)totalCalorie) * 100);

                yValues.add(new PieEntry((float) fatP,"fat"));
                yValues.add(new PieEntry((float) proteinP,"protein"));
                yValues.add(new PieEntry((float) carP,"car"));

                pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

                PieDataSet dataSet = new PieDataSet(yValues,"");
                dataSet.setSliceSpace(3f);
                dataSet.setSelectionShift(5f);
                dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

                PieData data = new PieData((dataSet));
                data.setValueTextSize(10f);
                data.setValueTextColor(Color.YELLOW);

                pieChart.setData(data);
            }
        });

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

//        pieChart.setDrawHoleEnabled(false); //가운데에 빈공간 만들것인
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        fat = food.getbFat() + food.getlFat() + food.getdFat();
        fatP = ((double)((double)(fat * 9) / (double)totalCalorie) * 100);
        protein = food.getbProtein() + food.getlProtein() + food.getdProtein();
        proteinP = ((double)((double)(protein * 4) / (double)totalCalorie) * 100);
        car = food.getbCarbohydrate() + food.getlCarbohydrate() + food.getdCarbohydrate();
        carP = ((double)((double)(car * 4) / (double)totalCalorie) * 100);

        yValues.add(new PieEntry((float) fatP,"fat"));
        yValues.add(new PieEntry((float) proteinP,"protein"));
        yValues.add(new PieEntry((float) carP,"car"));

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues,"");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);
    }

}