package kurs.teb.actovities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    Button changeActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,SecondActivty.class); //intent pozwala na połączenie różnych aktywności i przesył danych pmiędzy nimi.

        changeActivityButton = findViewById(R.id.acitivityButton);


        changeActivityButton.setOnClickListener
                (v -> startActivity(intent));


        /*changeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }

        });
*/
    }

}
