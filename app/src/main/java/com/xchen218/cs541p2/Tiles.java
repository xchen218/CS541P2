package com.xchen218.cs541p2;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Tiles extends FrameLayout {
    private int num = 0;
    public Tiles(Context context) {
        super(context);

        label = new TextView(getContext());
        label.setTextSize(48);

        LayoutParams lp = new LayoutParams(-1,-1);
        addView(label, lp);
        setNum(0);
    }
    public int getNum(){
        return num;
    }
    public void setNum(int n){
        this.num = n;
        label.setText(num+"");
    }

    public boolean collapse(Tiles t){
        return getNum() == t.getNum();
    }

    private TextView label;
}