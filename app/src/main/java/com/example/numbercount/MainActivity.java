package com.example.numbercount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView countView;
    public Button button;
    public Button button2;
    public Handler handler;
    public int count;
    public updateCount update;
    public boolean on;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView = findViewById(R.id.countView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        handler = new Handler();
        count = 0;
        on = false;
        update = new updateCount();


    }

    public void buttonPressed(View v){
        if(on){
            on = false;
            handler.removeCallbacks(update);

        }else {
            on = true;
            handler.postDelayed(update, 1000);
        }

    }


    private class updateCount implements Runnable{

        public void run(){
            if(button.isPressed()) {
                count++;
                countView.setText(count + "");
                handler.postDelayed(update, 1000);
            }else{
                count--;
                countView.setText(count + "");
                handler.postDelayed(update, 1000);

            }
        }

    }



}
