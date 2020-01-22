package fr.lgda.safrane;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static android.graphics.Paint.ANTI_ALIAS_FLAG;

public class BoutonDate extends View implements View.OnTouchListener {

    private static final int WIDTH = 683;
    private static final int HEIGHT = 392;

    private final Paint paintBordure;
    private final Paint paintTexteMoyen;
    private final Paint paintTexteGros;
    private final Timer timer;
    private final SimpleDateFormat simpleDateFormatDate;
    private final SimpleDateFormat simpleDateFormatHeure;

    public BoutonDate(Context context) {
        super(context);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 0, 1000);

        simpleDateFormatDate = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.FRENCH);
        simpleDateFormatHeure = new SimpleDateFormat("HH:mm:ss", Locale.FRENCH);

        setLayoutParams(new ViewGroup.LayoutParams(WIDTH, HEIGHT));
        this.setBackgroundColor(0x00000000);
        this.setOnTouchListener(this);

        paintBordure = new Paint();
        paintBordure.setStyle(Paint.Style.STROKE);
        paintBordure.setColor(Color.WHITE);
        paintBordure.setStrokeWidth(1);

        paintTexteMoyen = new Paint(ANTI_ALIAS_FLAG);
        paintTexteMoyen.setStyle(Paint.Style.FILL);
        paintTexteMoyen.setColor(Color.WHITE);
        paintTexteMoyen.setTextSize(25);
        paintTexteMoyen.setTypeface(Typeface.SANS_SERIF);

        paintTexteGros = new Paint(ANTI_ALIAS_FLAG);
        paintTexteGros.setStyle(Paint.Style.FILL);
        paintTexteGros.setColor(Color.WHITE);
        paintTexteGros.setTextSize(40);
        paintTexteGros.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, WIDTH, HEIGHT, paintBordure);
        drawCenterDate(canvas, simpleDateFormatDate.format(new Date()));
        drawCenterHeure(canvas, simpleDateFormatHeure.format(new Date()));
    }

    private void drawCenterDate(Canvas canvas, String texteDate) {
        RectF bounds = new RectF(canvas.getClipBounds());
        bounds.right = paintTexteMoyen.measureText(texteDate, 0, texteDate.length());
        bounds.bottom = paintTexteMoyen.descent() - paintTexteMoyen.ascent();
        bounds.left += (WIDTH - bounds.right) / 2.0f;
        bounds.top += (HEIGHT - bounds.bottom) / 2.0f;
        canvas.drawText(texteDate, bounds.left, bounds.top - paintTexteMoyen.ascent() + 20, paintTexteMoyen);
    }

    private void drawCenterHeure(Canvas canvas, String texteHeure) {
        RectF bounds = new RectF(canvas.getClipBounds());
        bounds.right = paintTexteGros.measureText(texteHeure, 0, texteHeure.length());
        bounds.bottom = paintTexteGros.descent() - paintTexteGros.ascent();
        bounds.left += (WIDTH - bounds.right) / 2.0f;
        bounds.top += (HEIGHT - bounds.bottom) / 2.0f;
        canvas.drawText(texteHeure, bounds.left, bounds.top - paintTexteGros.ascent() - 20, paintTexteGros);
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