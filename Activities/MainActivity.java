package com.example.android.quizzsuper.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizzsuper.Main3Activity;
import com.example.android.quizzsuper.Models.Question;
import com.example.android.quizzsuper.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Question> questions = new ArrayList<Question>();
    private int currentQuestion = 0;
    String name;

    TextView textViewQuestion;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    int grade = 0;
    String finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        showCurrentStep();

    }
    //this method is to position the questios and the answers in the activity
    private void showCurrentStep() {
         Question cQuestion = questions.get(currentQuestion);

        textViewQuestion.setText(cQuestion.getQuestion());
        button1.setText(cQuestion.getAnswer(0));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerClick(0);

            }
        });
        button2.setText(cQuestion.getAnswer(1));
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerClick(1);
            }
        });
        button3.setText(cQuestion.getAnswer(2));
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerClick(2);
            }
        });
        button4.setText(cQuestion.getAnswer(3));
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerClick(3);
            }
        });

    }

    private void initViews(){
         textViewQuestion = (TextView) findViewById(R.id.question_text);
         button1 = (Button) findViewById(R.id.button1);
         button2 = (Button) findViewById(R.id.button2);
         button3 = (Button) findViewById(R.id.button3);
         button4 = (Button) findViewById(R.id.button4);
    }
//the questions and answers
    public void initData(){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("Indigo");
        answers.add("Turquoise");//correct answer
        answers.add("Teal");
        answers.add("Navy");
        questions.add(new Question("What is my favorite shade of blue ?", answers, 1));

        answers = new ArrayList<String>(); //this  erase the previous answers list
        answers.add("Mediterranean");
        answers.add("Spanish");
        answers.add("Mexican");
        answers.add("Italian");//correct answer good job
        questions.add(new Question("What is my favorite type of food?", answers, 3));

        answers = new ArrayList<String>(); //this  erase the previous answers list
        answers.add("Diving");
        answers.add("Singing");
        answers.add("Dancing"); //correct answer wrong
        answers.add("Snowboarding");
        questions.add(new Question("What is my favorite hobby?", answers, 2));

        answers = new ArrayList<String>(); //this  erase the previous answers list
        answers.add("Dolphin");//correct answer
        answers.add("Cat");
        answers.add("Dog");
        answers.add("Starfish");
        questions.add(new Question("What is my favorite animal?", answers, 0));

        answers = new ArrayList<String>(); //this  erase the previous answers list
        answers.add("Lilly");//correct answer
        answers.add("Carnation");
        answers.add("Tulip");
        answers.add("Blue Roses");
        questions.add(new Question("What is my favorite flower?", answers, 0));

        answers = new ArrayList<String>(); //this  erase the previous answers list
        answers.add("8yrs");
        answers.add("12yrs");//correct answer im impressed
        answers.add("18yrs");
        answers.add("21yrs");
        questions.add(new Question("At what age I started dancing?", answers, 1));

        answers = new ArrayList<String>(); //this  erase the previous answers list
        answers.add("Virginia");
        answers.add("Hawaii");
        answers.add("New Mexico");
        answers.add("California");//correct answer goof job
        questions.add(new Question("What states I haven't visited yet?", answers, 3));

        answers = new ArrayList<String>(); //this  erase the previous answers list
        answers.add("None");
        answers.add("1");
        answers.add("3");//correct answer
        answers.add("4");
        questions.add(new Question("How many time i needed stitches?", answers, 2));

        answers = new ArrayList<String>(); //this  erase the previous answers list
        answers.add("Environmental Science");//correct answer
        answers.add("Biology");
        answers.add("Environmental Engineering");
        answers.add("Ecology");
        questions.add(new Question("What is her College Major?", answers, 0));

        answers = new ArrayList<String>(); //this  erase the previous answers list
        answers.add("Dog");
        answers.add("Rabbit");//correct answer
        answers.add("Cat");
        answers.add("Hamster");
        questions.add(new Question("In fourth grade, Stella fractured her tibia trying to save what animal?", answers, 1));


    }
//correct toast method
    public void correctToast (){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.correct_toast, (ViewGroup)findViewById(R.id.correct_toast_layout));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.FILL,0,0);
        toast.setDuration(toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }
    //incorrect toast method
    public void incorrectToast (){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.incorrect_toast, (ViewGroup)findViewById(R.id.incorrect_toast_layout));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.FILL,0,0);
        toast.setDuration(toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }



    //this method is for the score during the test
    private void answerClick(int answerPosition){
        Question q = questions.get(currentQuestion);
        q.selectedAnswer = answerPosition;
        if(q.isCorrect()){
            correctToast();
            grade= grade+1;
        } else {
            incorrectToast();
        }
        if(!isLastQuestion()){
            currentQuestion++;
            showCurrentStep();
        } else {

            TextView textViewScore = (TextView) findViewById(R.id.submit);
            textViewScore.setText("Submmit" );


        }



    }
    //this is to pass the score that the user got during the test to the next activity
    public void checkScore (View view){
        //TextView scoreText = (TextView) findViewById(R.id.score);
        finalScore = "Your score is: " + grade;
        name = getIntent().getExtras().getString("UserName");

        Intent myIntent = new Intent(MainActivity.this, Main3Activity.class);
        myIntent.putExtra("score", finalScore);
        myIntent.putExtra("UserName2", name );

        MainActivity.this.startActivity(myIntent);

    }





    private boolean isLastQuestion(){
        return currentQuestion >= questions.size() - 1;
    }

}
