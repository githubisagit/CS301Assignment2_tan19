package com.example.tan19.assignment2hw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.SurfaceView;

/**
 * <!-- class PaintSurface -->
 *
 * This class is a custom SurfaceView that draws Six objects onto a SurfaceView
 *
 * @author Sean Tan
 * @version Spring 2017
 *
 */
public class PaintSurface extends SurfaceView {




    //initializing our original and elegant Custom Elements
    public CustomCircle leftEye = new CustomCircle("left eye",Color.BLACK ,300,100,50 );
    public CustomCircle rightEye = new CustomCircle("right eye", Color.BLACK, 400, 100, 50);
    public CustomCircle nose = new CustomCircle("nose", Color.BLUE, 350, 200, 25);
    public CustomRect topMouth = new CustomRect("topMouth", Color.RED, 300, 300, 400, 350 );
    public CustomRect midMouth = new CustomRect("midMouth", Color.WHITE,300,350,400,400);
    public CustomRect smashMouth = new CustomRect("smashMouth", Color.RED,300,400,400,450);//someBODY once told me....

    private void myInitializationStuff() {
        setWillNotDraw(false);
    }

    //ctors
    public PaintSurface(Context context) {
        super(context);
        myInitializationStuff();
    }

    public PaintSurface(Context context, AttributeSet set) {
        super(context, set);
        myInitializationStuff();
    }

    public PaintSurface(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        myInitializationStuff();
    }


    /**
     * this draw method literally draws the instance variables onto the canvas.
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.leftEye.drawMe(canvas);
        this.rightEye.drawMe(canvas);
        this.nose.drawMe(canvas);
        this.topMouth.drawMe(canvas);
        this.midMouth.drawMe(canvas);
        this.smashMouth.drawMe(canvas);


    }

}
