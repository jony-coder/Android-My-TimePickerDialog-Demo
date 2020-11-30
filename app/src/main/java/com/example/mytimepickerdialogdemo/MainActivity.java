package com.example.mytimepickerdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showButton;
    private TextView textView;
    private TimePickerDialog timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showButton =(Button)findViewById(R.id.buttonId);
        textView=(TextView)findViewById(R.id.textViewId);
        showButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        TimePicker timePicker =  new TimePicker(this);
        int currentHour = timePicker.getCurrentHour();
        int currentMinute=timePicker.getCurrentMinute();

        timePickerDialog = new TimePickerDialog(MainActivity.this,

                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        textView.setText(hour+":"+minute);
                    }
                },currentHour, currentMinute, true);

        timePickerDialog.show();

    }
}