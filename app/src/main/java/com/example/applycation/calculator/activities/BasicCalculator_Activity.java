package com.example.applycation.calculator.activities;


import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.applycation.calculator.R;

public class BasicCalculator_Activity extends AppCompatActivity implements View.OnClickListener {

    String expressionString;

    TextView text_Result,text_smallResult;

    Button numpad[],numpadDot;

    Button math_Plus,math_Minus,math_Multi,math_Divide,math_Mod,math_DaoDau;

    Button action_Equal,action_CE,action_C, action_Back;

    Button math_sqrt,math_mu2,math_1chiaX;


    //FLAG
    private boolean isInputPhrase_Math;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basicCalculator_main);

        attachIdToView();
        attachOnClickListener();

        isInputPhrase_Math=true;

        expressionString="0";
        text_Result.setText("0");
        text_smallResult.setText("0");
    }
    //gan View vao cac doi tuong
    public void attachIdToView(){

        //text
        text_Result = (TextView)findViewById(R.id.text_Result);
        text_smallResult = (TextView)findViewById(R.id.text_SmallResult);

        //numpad
        numpad = new Button[10];
        numpad[0] = (Button)findViewById(R.id.button_numpad_0);
        numpad[1] = (Button)findViewById(R.id.button_numpad_1);
        numpad[2] = (Button)findViewById(R.id.button_numpad_2);
        numpad[3] = (Button)findViewById(R.id.button_numpad_3);
        numpad[4] = (Button)findViewById(R.id.button_numpad_4);
        numpad[5] = (Button)findViewById(R.id.button_numpad_5);
        numpad[6] = (Button)findViewById(R.id.button_numpad_6);
        numpad[7] = (Button)findViewById(R.id.button_numpad_7);
        numpad[8] = (Button)findViewById(R.id.button_numpad_8);
        numpad[9] = (Button)findViewById(R.id.button_numpad_9);
        numpadDot = (Button)findViewById(R.id.button_numpad_dot);

        //math
        math_Plus = (Button)findViewById(R.id.button_Math_plus);
        math_Minus = (Button)findViewById(R.id.button_Math_minus);
        math_Multi = (Button)findViewById(R.id.button_Math_multiply);
        math_Divide = (Button)findViewById(R.id.button_Math_divide);
        math_Mod = (Button)findViewById(R.id.button_Math_mod);
        math_sqrt = (Button)findViewById(R.id.button_Math_sqrt);
        math_mu2 = (Button)findViewById(R.id.button_Math_xmu2);
        math_1chiaX = (Button)findViewById(R.id.button_Math_1phanX);
        math_DaoDau = (Button)findViewById(R.id.button_Math_DaoDau);

        //action
        action_Equal = (Button)findViewById(R.id.button_action_equal);
        action_CE = (Button)findViewById(R.id.button_action_CE);
        action_C = (Button)findViewById(R.id.button_action_C);
        action_Back = (Button)findViewById(R.id.button_action_back);



    }
    //gan Listener vao cac doi tuong
    public void attachOnClickListener(){
        // hung chim to ok
        //numpad
        for(int i=0;i<numpad.length;i++){
            numpad[i].setOnClickListener(this);
        }
        numpadDot.setOnClickListener(this);

        //math
        math_Plus.setOnClickListener(this);
        math_Minus.setOnClickListener(this);
        math_Multi.setOnClickListener(this);
        math_Divide.setOnClickListener(this);
        math_Mod.setOnClickListener(this);
        math_sqrt.setOnClickListener(this);
        math_mu2.setOnClickListener(this);
        math_1chiaX.setOnClickListener(this);
        math_DaoDau.setOnClickListener(this);

        //action
        action_Equal.setOnClickListener(this);
        action_CE.setOnClickListener(this);
        action_C.setOnClickListener(this);
        action_Back.setOnClickListener(this);


    }
    //Them noi dung vao TextView
    public void addText(TextView textView,String content){
        String oldText = textView.getText().toString();
        textView.setText(oldText + content);
    }

    public void starColorAnimaton(View v,int color){
        int colorStar = Color.WHITE;
        int colorEnd = color;
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(
                v,"backgroundColor",colorStar,colorEnd
        );
        valueAnimator.setDuration(100);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }
    //cai dat Listener
    @Override
    public void onClick(View v) {

        starColorAnimaton(v, 0xFF55AAFF);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }
}
