package kurs.teb.actovities;

import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LettersPasser extends Fragment{


    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonZ;

    LetterPasserManager ltm;

    interface LetterPasserManager{  // implementowany przez aktywność do wykonywania komunikowania się między fragmentami.
        void putLetter(String letter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_letters_passer,container,false); //wskazanie na używany fragment

        setUpButtons(view);

        setUpListener();



        return view;
    }

    @Override
    public void onAttach(Activity activity) {  //metoda wywołuje się w trakcie przyłączania fragmentu do aktywności
        super.onAttach(activity);

        try{
            ltm = (LetterPasserManager) activity; //ustawia przesłaną aktywność jako managera przycisków
        }
        catch(ClassCastException ex){
            Log.d("LetterParser","On:Attach"+activity.toString()); //TAG służy do filtrowania logów
        }
    }

    private void setUpButtons(View view){
        buttonA = view.findViewById(R.id.buttonA);

        buttonB = view.findViewById(R.id.buttonB);

        buttonC = view.findViewById(R.id.buttonC);

        buttonZ = view.findViewById(R.id.buttonZ);
    }

    private void setUpListener(){
        buttonA.setOnClickListener(v -> {ltm.putLetter("A");});

        buttonB.setOnClickListener(v -> {ltm.putLetter("B");});

        buttonC.setOnClickListener(v -> {ltm.putLetter("C");});

        buttonZ.setOnClickListener(v -> {ltm.putLetter("Z");});

    }
}
