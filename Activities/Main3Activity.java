package com.example.android.quizzsuper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.quizzsuper.Activities.Main2Activity;
import com.example.android.quizzsuper.Activities.MainActivity;

public class Main3Activity extends AppCompatActivity {
    String name;
    String finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        name = getIntent().getExtras().getString("UserName2");
        TextView nameTxtView = (TextView) findViewById(R.id.finish_name);
        nameTxtView.setText(" " + name);

        finalScore = getIntent().getExtras().getString("score");
        TextView scoreTxtView = (TextView) findViewById(R.id.finish_score);
        scoreTxtView.setText(" " + finalScore);
    }

//this method is called to reset the app
    public void startOver (View view){
        Intent myIntent = new Intent(Main3Activity.this, Main2Activity.class);
        Main3Activity.this.startActivity(myIntent);
    }

}
