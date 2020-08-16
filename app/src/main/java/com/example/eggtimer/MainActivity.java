package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean flag;
    int A,B=0,C=0;

    public void randomGenerator(){

        TextView textView = (TextView)findViewById(R.id.textView4);
        Button b1 = (Button)findViewById(R.id.b1);
        Button b2 = (Button)findViewById(R.id.b2);
        Button b3 = (Button)findViewById(R.id.b3);
        Button b4 = (Button)findViewById(R.id.b4);
        int a=random();
        int b=random();
        int idx;
        Button randButton;

        textView.setText("  "+Integer.toString(a)+" + "+Integer.toString(b));

        List<Button> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        Random rand = new Random();
        randButton=list.get(rand.nextInt(list.size()));
        randButton.setText(Integer.toString(a+b));
        A=a+b;
        idx=list.indexOf(randButton);
        for (int j = 0; j < list.size(); j++){
            if((j!=idx)) {
                Random rand1 = new Random();
                list.get(j).setText(Integer.toString(rand1.nextInt(40) + 1));
            }
        }
    }


    public void score(boolean flag1){
        if (flag1 == true) {
            C++;
            B++;
            show(true);
        }
        else{
            C++;
            show(false);
        }

    }

    public void show(boolean flag2){
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setText(Integer.toString(B)+"/"+Integer.toString(C));
        if(flag2==true){
            TextView textView=(TextView)findViewById(R.id.textView);
            textView.setText("  Correct!");
            randomGenerator();
        }
        else{
            TextView textView=(TextView)findViewById(R.id.textView);
            textView.setText("  Wrong :(");
            randomGenerator();
        }
    }




    public void press(View v){
        Button b = (Button)v;
        int buttonText = Integer.parseInt(b.getText().toString());
        if(buttonText==A){
            flag=true;
            score(flag);
        }
        else{
            flag=false;
            score(flag);
        }
    }


    public int random(){

        int randomNumber;
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
        return randomNumber;
    }


    public void gameStart(View view){
        final Button goButton = (Button)findViewById(R.id.button);
        final Button button2 = (Button)findViewById(R.id.button2);
        final Button button4 = (Button)findViewById(R.id.button4);
        final Button button3 = (Button)findViewById(R.id.button3);
        final TextView textView = (TextView)findViewById(R.id.textView4);
        final Button b1 = (Button)findViewById(R.id.b1);
        final Button b2 = (Button)findViewById(R.id.b2);
        final Button b3 = (Button)findViewById(R.id.b3);
        final Button b4 = (Button)findViewById(R.id.b4);
        goButton.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);


        new CountDownTimer(31000,1000){

            public void onTick(long millis){
                //Log.i("time",String.valueOf(millis/1000));
                Button button2 = (Button)findViewById(R.id.button2);
                button2.setText(String.valueOf(millis/1000));
            }

            @Override
            public void onFinish() {
                button4.setText("Final Score:\n"+button3.getText());
                button4.setVisibility(View.VISIBLE);
                goButton.setText("Play Again");
                goButton.setVisibility(View.VISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
                b4.setVisibility(View.INVISIBLE);
                TextView textView=(TextView)findViewById(R.id.textView);
                textView.setVisibility(View.INVISIBLE);
                //Log.i("time","finished");
            }
        }.start();


        randomGenerator();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}