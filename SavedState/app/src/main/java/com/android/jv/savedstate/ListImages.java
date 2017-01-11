package com.android.jv.savedstate;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by josevictor on 10/01/17.
 */

public class ListImages implements Serializable {

    public ArrayList<Bitmap> images;

    public ListImages(ArrayList<Bitmap> images) {
        this.images = images;
    }
}
