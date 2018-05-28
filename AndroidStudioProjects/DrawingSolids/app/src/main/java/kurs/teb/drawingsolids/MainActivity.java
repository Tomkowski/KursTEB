package kurs.teb.drawingsolids;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Drawing(this));
    }



    private class Drawing extends View{   //klasa View umożliwia użycie metody onDraw

        public Drawing(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);

            //rysowanie

            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG); //rozmycie krawędzi

            p.setStyle(Paint.Style.FILL);

            p.setARGB(80,264  ,80,21);

            canvas.drawCircle
                    (getWidth()/2
                    ,getHeight()/2,100,p);

            canvas.drawCircle
                    (getWidth()/2
                    ,getHeight()/2 + 200,100,
                    new Paint(Paint.SUBPIXEL_TEXT_FLAG));


            canvas.drawRect(new Rect(0,0,getWidth(),getHeight()),p);

            //koniec rysowania
        }
    }

}

