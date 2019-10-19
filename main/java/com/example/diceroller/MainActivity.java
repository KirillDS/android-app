package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //by Kirill David Sorokin


        /*This will initialise all of the variables and call the
        * objects from the 'activity_main.xml'.
        */
        final Random rand = new Random();
        Button generateButton = findViewById(R.id.generateButton);
        final TextView outPutTextView = findViewById(R.id.outputTextView);
        final TextView congratsTextView = findViewById(R.id.congratsTextView);
        final TextView hiddenTextView = findViewById(R.id.hiddenTextView);
        final TextView scoreTextView = findViewById(R.id.scoreTextView);


        /*This will create new variables and be used to compare the
        * guessed value and the generated value.
        */
        String hiddenText = (String) hiddenTextView.getText();
        final int guessNum = Integer.parseInt(hiddenText);
        String outText = (String) outPutTextView.getText();
        final int generatedNum = Integer.parseInt(outText);


        /*These are variables for the number buttons on the application.*/
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);


        /*These functions/methods will set the text of 'hiddenTextView'
        * will a value; each button is assigned a different value
        * 1 - 6.
        */
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                hiddenTextView.setText(String.valueOf(1));
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                hiddenTextView.setText(String.valueOf(2));
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                hiddenTextView.setText(String.valueOf(3));
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                hiddenTextView.setText(String.valueOf(4));
            }
        });
        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                hiddenTextView.setText(String.valueOf(5));
            }
        });
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                hiddenTextView.setText(String.valueOf(6));
            }
        });


        /*This function/method will generate the number based from 0 to 6,
        * as well as compare the guessed value to the generated value,
        * if equals to each other, then the score variable will increment,
        * if not equals to, then it will be restart to 0.
        */
        generateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                outPutTextView.setText(String.valueOf(rand.nextInt(7)));
                int score = 0;
                if (guessNum == generatedNum){
                    congratsTextView.setVisibility(View.VISIBLE);
                    score = score + 1;  //score++ doesn't work
                    scoreTextView.setText(score);
                }
                else {
                    congratsTextView.setVisibility(View.INVISIBLE);
                    score = 0;
                    scoreTextView.setText(Integer.toString(score));
                }
            }
        });
    }
}
