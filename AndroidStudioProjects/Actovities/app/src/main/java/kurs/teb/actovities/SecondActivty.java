package kurs.teb.actovities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivty extends AppCompatActivity implements LettersPasser.LetterPasserManager {

    TopFragment display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activty);
        display = (TopFragment) getFragmentManager().findFragmentById(R.id.fragment);

    }


    @Override  // zaimplementowana z interfejsu metoda. Umożliwa komunikowanie się między fragmentami
    public void putLetter(String letter) {
    display.setResultText(display.getResult().getText().toString() + letter);
    }
}
