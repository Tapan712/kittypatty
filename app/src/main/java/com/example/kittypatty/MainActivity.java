package com.example.kittypatty;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String prevStarted = "appStart";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);

        Boolean isStarted = sharedpreferences.getBoolean(prevStarted, false);


        if(!isStarted) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
            Intent intent = new Intent(MainActivity.this, SplashScreenActivity.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }
    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(false);
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(prevStarted, Boolean.FALSE);
        editor.apply();
        finishAffinity();
    }
}