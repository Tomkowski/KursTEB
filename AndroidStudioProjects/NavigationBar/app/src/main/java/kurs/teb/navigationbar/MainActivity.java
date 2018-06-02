package kurs.teb.navigationbar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle aDrawerLayout;
    NavigationView navigationView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer1);

         textView = findViewById(R.id.project_title);

        navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(this);



    aDrawerLayout = new ActionBarDrawerToggle
    (this,drawerLayout,
     R.string.menu_drawer_layout,
     R.string.close_msg_drawer_layout);


    aDrawerLayout.syncState();

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

         if(aDrawerLayout.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.sign_in:
                Intent intent = new Intent(this, Sign_in_activity.class);
                startActivityForResult(intent,1);
                return true;
            case R.id.settings:
                return true;
            case R.id.log_out:
                return true;
            default:
        }

        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String email = data.getExtras().getString("email");

        String password = data.getExtras().getString("password");


        textView.setText(email+ "\n" +password);


    }
}
