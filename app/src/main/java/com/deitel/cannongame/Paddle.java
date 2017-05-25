package com.deitel.cannongame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by cisc on 5/16/2017.
 */
public class Paddle {
    private CannonView view;
    private Paint paint = new Paint();
    private Rect shape;
    private Cannonball ball;

    public Paddle(CannonView game, int x, int y, int width, int length) {
        this.view = game;
        paint.setColor(Color.BLACK);
        shape = new Rect(x, y, x + width, y + length);
    }

    // draws the Paddle on the Canvas
    public void draw(Canvas canvas) {
        canvas.drawRect(shape, paint);
    }

    // returns the ball that the paddle launched
    public Cannonball getCannonball() {
        return ball;
    }

    // removes the Cannonball from the game
    public void removeBCannonball() {
        ball = null;
    }
}
