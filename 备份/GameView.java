package com.xchen218.cs541p2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

public class GameView extends GridLayout {

    public GameView(Context context) {
        super(context);
        initialize();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }


    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public void initialize(){

        setColumnCount(4);
        setOnTouchListener(new View.OnTouchListener() {

            private float startposx, startposy, distx, disty;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startposx = event.getX();
                        startposy = event.getY();
                        Log.v("mytag0","left");
                        System.out.println("clicked");
                        break;
                    case MotionEvent.ACTION_UP:
                        distx = event.getX() - startposx;
                        disty = event.getY() - startposy;

                        if(Math.abs(distx) > Math.abs(disty)){
                            if(distx < -5){
                                System.out.println("");
                                System.out.println("left");
                                Log.v("mytag","left");//left
                            }else if(distx > 5){
                                Log.d("testtag2","right");//right
                            }
                        }else{
                            if(disty < -5){
                                Log.d("testtag3","up");//up
                            }else if(disty > 5){
                                Log.d("testtag4","down");//down
                            }
                        }
                        break;

                }
                return true;
            }
        });
    }
    @Override
    protected void onSizeChanged(int width, int height, int oldwidth, int oldheight){
        super.onSizeChanged(width, height, oldwidth, oldheight);
        int cardwidth = (Math.min(width, height) - 10)/4;
        addtile(cardwidth,cardwidth);
    }

    private void addtile(int cardwidth, int cardheight){
        Tiles t;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                t = new Tiles(getContext());
                t.setNum(2);
                addView(t, cardwidth, cardheight);
            }
        }
    }
}
