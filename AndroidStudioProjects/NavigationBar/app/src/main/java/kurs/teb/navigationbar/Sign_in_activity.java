package kurs.teb.navigationbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sign_in_activity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button signButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_activity);

        init();
    }

    public void signInClick(View view) {
        if(email.getText() != null && password.getText() != null){
            Intent intent = new Intent();

            intent.putExtra("email",email.getText().toString());
            intent.putExtra("password", password.getText().toString());

            setResult(RESULT_OK, intent);
            finish();
        }
    }


    private void init(){
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        signButton = findViewById(R.id.sign_in_button);
    }

}
