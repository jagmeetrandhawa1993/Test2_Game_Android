package com.example.test2_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.View;

import java.util.logging.LogRecord;

public class GameBoard extends View {

    private Bitmap player1;
    private Bitmap player2;
    private Bitmap background;
    private Bitmap ball;
    private Paint score1 = new Paint();
    private Paint score2 = new Paint();
    int ballX = 450;
    int ballY ;
    int ballSpeed = -5;
    int gameState = 0;
    private Handler h;
    private final int FRAME_RATE = 30;
    private int yVelocity = 10;



    private int canvasWidth, canvasHeight;


    public GameBoard(Context context) {
        super(context);

        player1 = BitmapFactory.decodeResource(getResources(), R.drawable.player1);
        player2 = BitmapFactory.decodeResource(getResources(), R.drawable.player2);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.splash);


        ball = BitmapFactory.decodeResource(getResources(), R.drawable.red);
        score1.setColor(Color.BLACK);
        score1.setTextSize(70);
        score1.setTypeface(Typeface.DEFAULT_BOLD);
        score1.setAntiAlias(true);
        score2.setColor(Color.BLACK);
        score2.setTextSize(70);
        score2.setTypeface(Typeface.DEFAULT_BOLD);
        score2.setAntiAlias(true);
        h = new Handler();
    }
    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // canvasHeight = canvas.getHeight();
        //   canvasWidth = canvas.getWidth();
        // ballX =  canvasWidth/2 - ball.getWidth()/2;
        //   ballY = canvasHeight/2 - ball.getHeight();


        // canvas.drawBitmap(background, 0, 0, null);
        canvas.drawBitmap(player1, 0, 700, null);
        canvas.drawBitmap(player2, 800, 700, null);

        if (ballY < 0) {

            ballY = this.getHeight() / 2;
        } else {

            ballY += yVelocity;

            if ((ballY > this.getHeight() - ball.getHeight()) || (ballY < 0)) {
                yVelocity = yVelocity * -1;
            }
        }



        canvas.drawBitmap(ball, ballX, ballY, null);
        h.postDelayed(r, FRAME_RATE);



        canvas.drawText("PlayerA:", 20, 60, score1);
        canvas.drawText("PlayerB:", 700, 60, score2);

    }
}
