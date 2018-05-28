package kurs.teb.actovities;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TopFragment extends Fragment{

    TextView result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view
      = inflater.inflate(R.layout.activity_top_fragment,container,false); //wskazanie na używany fragment

        result = view.findViewById(R.id.resultView);


        return view;
    }

    public void setResultText(String s){
        result.setText(s);
    }

    public TextView getResult(){
        return result;
    }
}
