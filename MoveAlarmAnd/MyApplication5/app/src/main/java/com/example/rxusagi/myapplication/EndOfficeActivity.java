package com.example.rxusagi.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.rxusagi.myapplication.model.AlarmManagement;

public class EndOfficeActivity extends AppCompatActivity {
    private AlarmManagement alarmManagement;
    private TextView hr;
    private TextView mn;
    private int hrStop;
    private int mnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_office);
        alarmManagement = AlarmManagement.Instance();
        hr = (TextView)findViewById(R.id.hrCID);
        mn = (TextView)findViewById(R.id.mnCID);
        hrStop = alarmManagement.alarmState.getStopofficetimehr();
        mnStop = alarmManagement.alarmState.getStopofficetimemn();
    }

    @Override
    protected void onResume() {
        super.onResume();
        change();
    }

    private void change(){
        String hrs = "";
        String mns = "";
        if(alarmManagement.alarmState.getStopofficetimehr()<10){
            hrs = "0";
        }
        if(alarmManagement.alarmState.getStopofficetimemn()<10){
            mns = "0";
        }
        hr.setText(hrs + alarmManagement.alarmState.getStopofficetimehr());
        mn.setText(mns + alarmManagement.alarmState.getStopofficetimemn());
    }

    public void onHrUp(View v){
        alarmManagement.alarmState.setStopofficetimehr(alarmManagement.alarmState.getStopofficetimehr() + 1);
        change();
    }
    public void onHrDown(View v){
        alarmManagement.alarmState.setStopofficetimehr(alarmManagement.alarmState.getStopofficetimehr() - 1);
        change();
    }
    public void onMnUp(View v){
        alarmManagement.alarmState.setStopofficetimemn(alarmManagement.alarmState.getStopofficetimemn() + 1);
        change();
    }
    public void onMnDown(View v){
        alarmManagement.alarmState.setStopofficetimemn(alarmManagement.alarmState.getStopofficetimemn() - 1);
        change();
    }


    public  void submit(View v){
        alarmManagement.alarmState.update();
        finish();
    }
    public void onBackClick(View v){
        alarmManagement.alarmState.setStopofficetimehr(hrStop);
        alarmManagement.alarmState.setStopofficetimemn(mnStop);
        finish();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
}
