package com.mhellar.tutorial2D;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


public class Tutorial2D extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new Panel(this));
    }

	class Panel extends View {
		public Panel(Context context) {
			super(context);
		}
	
	@Override
	public void onDraw(Canvas canvas) {
		Bitmap _scratch = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
		canvas.drawColor(Color.BLACK);
		canvas.drawBitmap(_scratch, 10, 10, null);
		}
	}
}
