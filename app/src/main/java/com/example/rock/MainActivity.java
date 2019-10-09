package com.example.rock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editChoice;
    TextView tv_start;
    ImageView rock,scissor,paper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editChoice=(EditText) findViewById(R.id.choiceText);
        tv_start=(TextView)findViewById(R.id.textView2);
        tv_start.setOnClickListener(this);

        rock=(ImageView)findViewById(R.id.rock);
        scissor=(ImageView)findViewById(R.id.Scissor);
        paper=(ImageView)findViewById(R.id.paper);

        rock.setOnClickListener(this);
        scissor.setOnClickListener(this);
        paper.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.textView2){
            String userChoice;int choice;
            userChoice=editChoice.getText().toString();

            if(userChoice.length()>0) {
                choice=Integer.parseInt(userChoice);
                if (choice > 0 && choice <4) {
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("choice", choice);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "1~3사이의 숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
            else
                Toast.makeText(this, "가위(1) 바위(2) 보(3)를 선택해 주세요", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.Scissor){
            editChoice.setText("1");
            Toast.makeText(this, "가위를 선택하셨습니다", Toast.LENGTH_SHORT).show();
        }

        else if(v.getId()==R.id.rock){
            editChoice.setText("2");
            Toast.makeText(this, "바위를 선택하셨습니다", Toast.LENGTH_SHORT).show();
        }

        else if(v.getId()==R.id.paper){
            editChoice.setText("3");
            Toast.makeText(this, "보를 선택하셨습니다", Toast.LENGTH_SHORT).show();
        }

    }
}
