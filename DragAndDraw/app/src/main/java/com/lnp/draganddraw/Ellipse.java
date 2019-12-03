package com.lnp.draganddraw;

import android.graphics.PointF;

public class Ellipse {
    private PointF mOrigin;
    private PointF mCurrent;
    public Ellipse(PointF origin) {
        mOrigin = origin;
        mCurrent = origin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF mCurrent) {
        this.mCurrent = mCurrent;
    }

    public PointF getOrigin() {
        return mOrigin;
    }
}
