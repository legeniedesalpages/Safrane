package fr.lgda.safrane;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.mikepenz.iconics.IconicsColor;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.IconicsSize;
import com.mikepenz.iconics.typeface.library.ionicons.Ionicons;

public class TestIcon extends View implements View.OnTouchListener {

    private Paint paint = new Paint();

    public TestIcon(Context context) {
        super(context);

        setLayoutParams(new ViewGroup.LayoutParams(6830, 6920));
        this.setBackgroundColor(0x00000000);
        this.setOnTouchListener(this);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1);
    }

    @Override
    public void onDraw(Canvas canvas) {
       // canvas.drawRect(0.0f, 0.0f, 683, 392, paint);

        for (int i=0; i<Ionicons.Icon.values().length; i++) {
            Ionicons.Icon value = Ionicons.Icon.values()[i];
            IconicsDrawable icon = new IconicsDrawable(this.getContext()).icon(value);
            icon.color(IconicsColor.colorInt(0xffffffff));
            icon.size(IconicsSize.px(30));
            int v =
                    31;
            canvas.drawBitmap(icon.toBitmap(), 32 * (i%v) , 32 * (i /v), paint);
        }
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            this.setBackgroundColor(0x33FFFFFF);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            this.setBackgroundColor(0x00000000);
        }
        return true;
    }
}