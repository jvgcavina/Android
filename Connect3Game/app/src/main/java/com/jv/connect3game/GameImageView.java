package com.jv.connect3game;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by josevictor on 14/06/2018.
 */

public class GameImageView extends android.support.v7.widget.AppCompatImageView {

    private int value;

    public GameImageView(Context context) {
        super(context);
        this.value = 0;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                (int)context.getResources().getDimension(R.dimen.imageview_dimention),
                (int)context.getResources().getDimension(R.dimen.imageview_dimention));
        lp.setMargins(
                (int)context.getResources().getDimension(R.dimen.imageview_margin),
                (int)context.getResources().getDimension(R.dimen.imageview_margin),
                (int)context.getResources().getDimension(R.dimen.imageview_margin),
                (int)context.getResources().getDimension(R.dimen.imageview_margin)
        );

        this.setLayoutParams(lp);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
