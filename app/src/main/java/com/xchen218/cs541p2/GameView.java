package com.xchen218.cs541p2;

import android.content.Context;
import android.util.AttributeSet;
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

    }
}
