package com.example.android.quizzsuper.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.quizzsuper.Main3Activity;
import com.example.android.quizzsuper.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final EditText editTextName = (EditText) findViewById(R.id.name);

        Button startButton = (Button) findViewById(R.id.start_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextName.getText().toString();
                Intent passName_intent = new Intent(Main2Activity.this, MainActivity.class);
                passName_intent.putExtra("UserName", userName);
                startActivity(passName_intent);


            }


        });


    }


}



