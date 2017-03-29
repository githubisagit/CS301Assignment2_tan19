package com.example.tan19.assignment2hw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by tan19 on 3/27/2017.
 */
public class Wall {

    private float left, top, right, bottom ;
    Paint color ;

    public Wall(float initLeft, float initTop, float initRight, float initBottom, Paint initColor) {
        left = initLeft;
        top = initTop;
        right = initRight;
        bottom = initBottom ;


        color = initColor ;
    }

    public void draw(Canvas canvas){//a wall knows how to draw itself on a given canvas.

        canvas.drawRect(left, top, right, bottom, color);
    }
}
