package com.hmartinez.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar abAbout = (Toolbar)findViewById(R.id.tbGeneral);
        setSupportActionBar(abAbout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
