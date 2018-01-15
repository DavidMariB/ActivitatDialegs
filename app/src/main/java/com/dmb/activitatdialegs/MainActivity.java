package com.dmb.activitatdialegs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.text.TimeZoneFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvDate, tvHour, tvColor;
    private Calendar myCalendar;
    private DatePickerDialog date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCalendar = Calendar.getInstance();
        tvDate = findViewById(R.id.tvDate);
        tvHour = findViewById(R.id.tvHour);
        tvColor = findViewById(R.id.tvColor);

    }

    public void datePicker(View v) {
        date = new DatePickerDialog(this);
        date.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {

          @Override
          public void onDateSet(DatePicker view, int year, int monthOfYear,
                                int dayOfMonth) {
              // TODO Auto-generated method stub
              myCalendar.set(Calendar.YEAR, year);
              myCalendar.set(Calendar.MONTH, monthOfYear);
              myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
              updateLabel();
          }
        }

        );

        date.show();
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);

        tvDate.setText("Fecha: "+sdf.format(myCalendar.getTime()));
    }

    public void dialogHourPicker(View v) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        final String curTime = String.format("%02d:%02d", hourOfDay, minute);
                        tvHour.setText("Hora: "+curTime);
                    }
                } ,hour, minute, true);
        timePickerDialog.show();
    }

    public void dialogColors(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Elige un Color")
                .setItems(R.array.colores, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialeg, int posicio) {
                        tvColor.setText("Color: "+getResources().getStringArray(R.array.colores)[posicio]);
                    }
                });

        builder.create().show();
    }
}