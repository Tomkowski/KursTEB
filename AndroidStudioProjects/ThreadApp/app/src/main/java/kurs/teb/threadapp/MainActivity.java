package kurs.teb.threadapp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    Button threadButton;

    int counter = 0;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(""+ counter);
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.threadView);

        threadButton = findViewById(R.id.threadButton);

        threadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Runnable r =  () -> {

                    try {
                        synchronized (this) {

                            wait(5000);
                            counter++;

                            handler.sendEmptyMessage(0);

                        }
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                                    };

                    Thread thread = new Thread(r);

                    thread.start();

            }
        });

    }
}
