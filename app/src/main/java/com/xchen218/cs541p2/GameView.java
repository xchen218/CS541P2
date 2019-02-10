package com.xchen218.cs541p2;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class GameView<tilematrix> extends GridLayout {

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
        setBackgroundColor(0xffbbada0);
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
        start();
    }

    private void addtile(int cardwidth, int cardheight){
        Tiles t;
        for(int j = 0; j < 4; j++){
            for(int i = 0; i < 4; i++){
                t = new Tiles(getContext());
                t.setNum(0);
                addView(t, cardwidth, cardheight);
                board[i][j] = t;
            }
        }
    }
//random number generator
    private void rng(){
        nullpoints.clear();
        for(int j = 0; j < 4; j++){
            for(int i = 0; i < 4; i++){
                if(board[i][j].getNum() <= 0) {
                    nullpoints.add(new Point(i,j));
                }
            }
        }
        Point p = nullpoints.remove((int)(Math.random()*nullpoints.size()));
        board[p.x][p.y].setNum(Math.random()>0.1?2:4);
    }
    private void start() {
        for(int j = 0; j < 4; j++){
            for(int i = 0; i < 4; i++){
                board[i][j].setNum(0);
            }
        }
        rng();
        rng();
    }
    private Tiles[][] board = new Tiles[4][4];
    private List<Point> nullpoints = new ArrayList<>();
}
