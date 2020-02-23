package com.example.test2_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private  GameBoard gameBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        gameBoard = new GameBoard(this);
        setContentView(gameBoard);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable(){

                    public void run()
                    {
                        gameBoard.invalidate();
                    }
                });
            }
        }, 0);
    }
}
