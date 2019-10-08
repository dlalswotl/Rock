package com.example.rock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editChoice;
    TextView tv_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editChoice=(EditText) findViewById(R.id.choiceText);
        tv_start=(TextView)findViewById(R.id.textView2);
        tv_start.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.textView2){
            String userChoice;int choice;
            userChoice=editChoice.getText().toString();
            choice=Integer.parseInt(userChoice);
            if(choice>0&&choice<4) {
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("choice",choice);
                startActivity(intent);
            }
        }
    }
}
