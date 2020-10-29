package com.example.mobileprogramming_stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import java.util.Locale;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int sec = 0;
    private boolean run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    public void onClickStop(View view) {
        run = false;
    }

    public void onClickReset(View view) {
        run = false;
        sec = 0;
    }

    public void onClickStart(View view) {
        run = true;
    }

    private void runTimer(){
        final TextView viewTime = (TextView)findViewById(R.id.viewTime);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = sec/3600;
                int min = (sec%3600) /60;
                int seconds = sec%60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours,min,seconds);
                viewTime.setText(time);
                if(run){
                    sec++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }
}
