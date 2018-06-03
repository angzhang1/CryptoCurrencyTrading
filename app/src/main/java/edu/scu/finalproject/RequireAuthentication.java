package edu.scu.finalproject;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RequireAuthentication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.require_authentication);

        String[] auth_settings_array = getResources().getStringArray(
                R.array.auth_time);

        Toolbar myToolbar = findViewById(R.id.require_auth_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

        ListView auth_times = findViewById(R.id.auth_time_settings);
        auth_times.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter auth_adapter = new ArrayAdapter<>(this, R.layout.authentication_item, auth_settings_array);
        auth_times.setAdapter(auth_adapter);

        auth_times.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Selected the authentication time setting
                if (i == 0) {
                    setAuthenticationMinutes(1);
                } else if (i == 1) {
                    setAuthenticationMinutes(5);
                } else if (i == 2) {
                    setAuthenticationMinutes(15);
                } else if (i == 3) {
                    setAuthenticationMinutes(60);
                } else if (i == 4) {
                    setAuthenticationMinutes(240);
                }
            }
        });
    }

    // TODO: Save the authentication time to database.
    private void setAuthenticationMinutes(int minutes) {
        Toast.makeText(this,"Set to " + minutes + " minutes", Toast.LENGTH_LONG).show();
    }
}
