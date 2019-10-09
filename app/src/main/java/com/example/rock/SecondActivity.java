package com.example.rock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView playerImg;
    ImageView comImg;
    TextView resultText;
    Button regameBtn;
    int userChoice,comChoice;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        comChoice = (int) (1+3*Math.random());
        Log.d("random", "onCreate"+comChoice);
        userChoice= getIntent().getIntExtra("choice",0);
        playerImg=(ImageView)findViewById(R.id.userImg);
        comImg=(ImageView)findViewById(R.id.comImg);
        resultText=(TextView)findViewById(R.id.ResultText);
        regameBtn=(Button)findViewById(R.id.RegameBtn);

        setImage(playerImg,userChoice);
        setImage(comImg,comChoice);


        switch(userChoice){
            case 1:
                if(comChoice==1)
                    result="비겼습니다";
                else if(comChoice==2){
                    result="당신의 패배입니다";
                }
                else if(comChoice==3){
                    result="당신의 승리입니다";
                }break;

            case 2:
                if(comChoice==1)
                    result="당신의 승리입니다";
                else if(comChoice==2){
                    result="비겼습니다";
                }
                else if(comChoice==3) {
                    result = "당신의 패배입니다";
                }break;

            case 3:
                if(comChoice==1)
                    result="당신의 패배입니다";
                else if(comChoice==2){
                    result="당신의 승리입니다.";
                }
                else if(comChoice==3) {
                    result = "비겼습니다";
                }break;

        }

        resultText.setText(result);
        regameBtn.setOnClickListener(this);
    }
    public void setImage(ImageView v,int choice){
        switch(choice){
            case 1:
                v.setImageResource(R.drawable.math_img_1);
                break;
            case 2:
                v.setImageResource(R.drawable.math_img_2);
                break;
            case 3:
                v.setImageResource(R.drawable.math_img_3);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.RegameBtn){
            finish();
           /* Intent i=new Intent(this,MainActivity.class);
            startActivity(i);*/
        }

    }
}
