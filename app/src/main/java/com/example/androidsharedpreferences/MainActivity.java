package com.example.androidsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button storeinformation, showinformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeinformation = findViewById(R.id.button_store);
        showinformation = findViewById(R.id.button_show);
        textView = findViewById(R.id.show_info);

        storeinformation.setOnClickListener(this);
        showinformation.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_store:
                Intent intent = new Intent(MainActivity.this, PrefsActivity.class);
                startActivity(intent);
                break;
            case R.id.button_show:
                displaySharedPreferences();
                break;
            default:
                break;
        }
        
    }

    private void displaySharedPreferences() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = prefs.getString("username", "Default Name");
        String passw = prefs.getString("password", "Default Password");
        boolean checkBox = prefs.getBoolean("checkBox", false);
        String listPrefs = prefs.getString("listpref", "Default list Items");

        StringBuilder builder = new StringBuilder();
        builder.append("Username: " + username + "\n");
        builder.append("Password: " + passw + "\n");
        builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
        builder.append("List preference: " + listPrefs);
        textView.setText(builder.toString());

    }
}