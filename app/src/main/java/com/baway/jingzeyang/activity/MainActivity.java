package com.baway.jingzeyang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.baway.jingzeyang.R;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Intent it=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(it);
            }
        };
        timer.schedule(timerTask,2000);
    }
}
