package com.example.tan19.assignment2hw;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
/**
 * <!-- class MainActivity -->
 *
 * This class handles most of the functionality of the program, including
 * implementing listeners for our custom objects defined in the activity_main.XML
 *
 * @author Sean Tan
 * @version Spring 2017
 *
 */

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    //inst variables
    private SeekBar redSeekBar, blueSeekBar, greenSeekBar ;
    private EditText currElement;
    private CustomElement selectedElement ;
    PaintSurface mySurface ;


    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mySurface = (PaintSurface)this.findViewById(R.id.paintSurface);//my custom SurfaceView!

        mySurface.invalidate();
        mySurface.setOnTouchListener(this);

        //attatching instance variables to their proper widgets in the XML
        redSeekBar = (SeekBar)findViewById(R.id.redSeekBar);
        blueSeekBar = (SeekBar)findViewById(R.id.blueSeekBar);
        greenSeekBar = (SeekBar)findViewById(R.id.greenSeekBar);
        currElement = (EditText)findViewById(R.id.curElement);

        //registering the listeners.
        redSeekBar.setOnSeekBarChangeListener(this);
        blueSeekBar.setOnSeekBarChangeListener(this);
        greenSeekBar.setOnSeekBarChangeListener(this);



    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //get the coordinates of where the touch happened.
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        int initRed, initGreen, initBlue;

        /**
         * Each if statement calls the CustomElement's containsPoint method, sets the
         * selectedElement object to the most recently tapped on element, sets the EditText to the
         * selectedElement, extracts the RGB values from the selectedElement's color int, and finally
         * sets the progress of each seek bar to their corresponding RGB values.
         */
        if(mySurface.leftEye.containsPoint((int)touchX, (int)touchY)) {//Left Eye

            this.setSelectedElement(mySurface.leftEye);
            currElement.setText(this.getSelectedElement().getName());

            /**
             External Citation
             Date: 28 March 2017
             Problem: Did not know how to decode individual RGB values from a color int.
             Resource:
             https://developer.android.com/reference/android/graphics/Color.html
             Solution: I followed the android documentation.
             */
            initRed = (selectedElement.getColor() >> 16) & 0xff;//thanks android docs!
            initGreen = (selectedElement.getColor() >> 8) & 0xff;
            initBlue = (selectedElement.getColor()) & 0xff;

            redSeekBar.setProgress(initRed);
            greenSeekBar.setProgress(initGreen);
            blueSeekBar.setProgress(initBlue);//lets hope this works otherwise IDK



        }
        if(mySurface.rightEye.containsPoint((int)touchX, (int)touchY)) {//Right Eye

            this.setSelectedElement(mySurface.rightEye);
            currElement.setText(this.getSelectedElement().getName());

            initRed = (selectedElement.getColor() >> 16) & 0xff;//thanks android docs!
            initGreen = (selectedElement.getColor() >> 8) & 0xff;
            initBlue = (selectedElement.getColor()) & 0xff;

            redSeekBar.setProgress(initRed);
            greenSeekBar.setProgress(initGreen);
            blueSeekBar.setProgress(initBlue);

        }
        if(mySurface.nose.containsPoint((int)touchX, (int)touchY)){

            this.setSelectedElement(mySurface.nose);
            currElement.setText(this.getSelectedElement().getName());

            initRed = (selectedElement.getColor() >> 16) & 0xff;
            initGreen = (selectedElement.getColor() >> 8) & 0xff;
            initBlue = (selectedElement.getColor()) & 0xff;

            redSeekBar.setProgress(initRed);
            greenSeekBar.setProgress(initGreen);
            blueSeekBar.setProgress(initBlue);


        }
        if(mySurface.topMouth.containsPoint((int)touchX, (int)touchY)){

            this.setSelectedElement(mySurface.topMouth);
            currElement.setText(this.getSelectedElement().getName());

            initRed = (selectedElement.getColor() >> 16) & 0xff;
            initGreen = (selectedElement.getColor() >> 8) & 0xff;
            initBlue = (selectedElement.getColor()) & 0xff;

            redSeekBar.setProgress(initRed);
            greenSeekBar.setProgress(initGreen);
            blueSeekBar.setProgress(initBlue);

        }
        if(mySurface.midMouth.containsPoint((int)touchX, (int)touchY)){

            this.setSelectedElement(mySurface.midMouth);
            currElement.setText(this.getSelectedElement().getName());

            initRed = (selectedElement.getColor() >> 16) & 0xff;//thanks android docs!
            initGreen = (selectedElement.getColor() >> 8) & 0xff;
            initBlue = (selectedElement.getColor()) & 0xff;

            redSeekBar.setProgress(initRed);
            greenSeekBar.setProgress(initGreen);
            blueSeekBar.setProgress(initBlue);
        }
        if(mySurface.smashMouth.containsPoint((int)touchX, (int)touchY)){//i love this song!

            this.setSelectedElement(mySurface.smashMouth);
            currElement.setText(this.getSelectedElement().getName());

            initRed = (selectedElement.getColor() >> 16) & 0xff;//thanks android docs!
            initGreen = (selectedElement.getColor() >> 8) & 0xff;
            initBlue = (selectedElement.getColor()) & 0xff;

            redSeekBar.setProgress(initRed);
            greenSeekBar.setProgress(initGreen);
            blueSeekBar.setProgress(initBlue);
        }


        mySurface.invalidate();



        return false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        //This ensures the program doesn't crash when you move a seekBar at the start of the  program!
        if(selectedElement == null) return ;

        int newColor = 0;//because the compiler complained

        int initRed = (selectedElement.getColor() >> 16) & 0xff;//thanks android docs!
        int initGreen = (selectedElement.getColor() >> 8) & 0xff;
        int initBlue = (selectedElement.getColor()) & 0xff;

        /**
         * Each if statement checks to see which specific seekBar was changed, and uses the new Progress value (i)
         * to encode a new color int for the selectedElement.
         */
        if(seekBar.equals(redSeekBar)){
            newColor = (255 & 0xff) << 24 | (i & 0xff) << 16 | (initGreen & 0xff) << 8 | (initBlue & 0xff);
        }
        if(seekBar.equals(greenSeekBar)){
            newColor = (255 & 0xff) << 24 | (initRed & 0xff) << 16 | (i & 0xff) << 8 | (initBlue & 0xff) ;
        }
        if(seekBar.equals(blueSeekBar)){
            newColor = (255 & 0xff) << 24 | (initRed & 0xff) << 16 | (initGreen & 0xff) << 8 | (i & 0xff) ;
        }

        selectedElement.setColor(newColor);//to reflect the progress change from the seekBar.

        mySurface.invalidate();



    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {//no

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {//no


    }

    /**
     * setters and getters for this Activity's selectedElement
     *
     */
    public CustomElement getSelectedElement(){
       return this.selectedElement;
    }
    public void setSelectedElement(CustomElement selected){
        this.selectedElement = selected;
    }

}
