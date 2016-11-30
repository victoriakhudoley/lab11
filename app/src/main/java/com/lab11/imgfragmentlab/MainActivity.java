package com.lab11.imgfragmentlab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Paint p;
    CustomCanvas cCanvas;
    Bitmap iface;
    Rect tmpRect1, tmpRect2;

    class CustomCanvas extends View {

        public CustomCanvas(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Log.d("app", "width is" + iface.getWidth() + " d = " + iface.getDensity());
            tmpRect1 = new Rect(155, 0, 310, 230);
            tmpRect2 = new Rect(250, 250, 250+(310-155)*2, 250+230*2);
            canvas.drawBitmap(iface, tmpRect1, tmpRect2, p);
            tmpRect1 = new Rect(100, 300, 200, 400);
            tmpRect2 = new Rect(250-50, 250+60, 250-50+100*2, 250+60+100*2);
            canvas.drawBitmap(iface, tmpRect1, tmpRect2, p);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cCanvas = new CustomCanvas(this);
        setContentView(cCanvas);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;
        iface = BitmapFactory.decodeResource(getResources(), R.drawable.ui, opts);
    }
}
