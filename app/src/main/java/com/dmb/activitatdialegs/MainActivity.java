package com.dmb.activitatdialegs;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvDate, tvHour, tvColor;
    private Calendar myCalendar;
    private DatePickerDialog date;
    private Button btnDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCalendar = Calendar.getInstance();
        tvDate = findViewById(R.id.tvDate);
        tvHour = findViewById(R.id.tvHour);
        tvColor = findViewById(R.id.tvColor);
        btnDate = findViewById(R.id.btnDate);

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

    }

    public void datePicker(View v) {
        date.show();
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);

        tvDate.setText(sdf.format(myCalendar.getTime()));
    }



    public void dialogHourPicker(View v) {
        
    }

    public void dialogColors(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Elige un Color")
                .setItems(R.array.colores, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialeg, int posicio) {
                        switch (posicio) {
                            case 0:
                                tvColor.setText("Color: Rojo");
                                break;
                            case 1:
                                tvColor.setText("Color: Azul");
                                break;
                            case 2:
                                tvColor.setText("Color: Verde");
                                break;
                            case 3:
                                tvColor.setText("Color: Negro");
                                break;
                            case 4:
                                tvColor.setText("Color: Blanco");
                                break;
                        }
                    }
                });

        builder.create().show();
    }
}