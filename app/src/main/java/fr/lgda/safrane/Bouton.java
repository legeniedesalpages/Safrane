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
import com.mikepenz.iconics.typeface.IIcon;

public class Bouton extends View implements View.OnTouchListener {

    private Paint paint = new Paint();
    private IconicsDrawable icon;

    public Bouton(Context context, IIcon fontIcon) {
        super(context);

        setLayoutParams(new ViewGroup.LayoutParams(342, 392));

        this.setBackgroundColor(0x00000000);
        this.setOnTouchListener(this);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1);

        icon = new IconicsDrawable(context).icon(fontIcon);
        icon.color(IconicsColor.colorInt(0xffffffff));
        icon.size(IconicsSize.px(100));
    }

    @Override
    public void onDraw(Canvas canvas) {

        canvas.drawRect(0.0f, 0.0f, 341, 392, paint);
        canvas.drawBitmap(icon.toBitmap(), 120, 130, paint);
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