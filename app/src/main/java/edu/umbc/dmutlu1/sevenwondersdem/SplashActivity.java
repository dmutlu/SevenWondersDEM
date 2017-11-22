package edu.umbc.dmutlu1.sevenwondersdem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                // Start home activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));

                // close splash activity
                finish();
            }
        };

        Timer launch = new Timer();
        launch.schedule(task,2000);
    }
}