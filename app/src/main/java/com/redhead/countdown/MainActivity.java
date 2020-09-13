package com.redhead.countdown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.iwgang.countdownview.CountdownView;

import static java.text.DateFormat.FULL;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDatePicker = findViewById(R.id.btnDatePicker);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePickerDialog = new DatePickerFragment();
                datePickerDialog.show(getSupportFragmentManager(), "date picker");

            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String pickerDateString = DateFormat.getDateInstance(FULL).format(calendar.getTime());
            TextView tvDatePicker = findViewById(R.id.textViewContent);
            CountdownView myCountDownView = findViewById(R.id.countdownView);

            try{
                tvDatePicker.setText(pickerDateString);
                Date now = new Date();

                long currentDate = now.getTime();
                long pickerDate = calendar.getTimeInMillis();
                long countDownToPickerDate = pickerDate - currentDate;
                myCountDownView.start(countDownToPickerDate);
            }catch (Exception e){
                e.printStackTrace();
                }
            }
        }

