package com.lnp.draganddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class BoxDrawingView extends View {
    private Ellipse mCurrentEllipse;
    private List<Ellipse> mEllipsen = new ArrayList<>();
    private Paint mEllipse;
    private Paint mBackgroundPaint;
    private static final String TAG = "EllipseDrawingView";

    public BoxDrawingView(Context context) {
        this(context, null);
    }

    public BoxDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mEllipse = new Paint();
        mEllipse.setColor(0x221e1e1e);
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0xffff7256);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(mBackgroundPaint);

        for (Ellipse eps : mEllipsen) {
            float left = Math.min(eps.getOrigin().x, eps.getCurrent().x);
            float right = Math.max(eps.getOrigin().x, eps.getCurrent().x);
            float top = Math.min(eps.getOrigin().y, eps.getCurrent().y);
            float bottom = Math.max(eps.getOrigin().y, eps.getCurrent().y);
            canvas.drawOval(left, top, right, bottom, mEllipse);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                mCurrentEllipse = new Ellipse(current);
                mEllipsen.add(mCurrentEllipse);
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                if (mCurrentEllipse != null) {
                    mCurrentEllipse.setCurrent(current);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                mCurrentEllipse = null;
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                mCurrentEllipse = null;
                break;
        }
        Log.i(TAG, action + " at x = " + current.x + ", y = " + current.y);
        return true;
    }
}
