package com.example.applycation.calculator;


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

import com.example.applycation.calculator.expression.Check;
import com.example.applycation.calculator.expression.Expression;
import com.example.applycation.calculator.expression.BasicMath;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_main);

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

        if(action_Equal.getId()==v.getId()&&expressionString!=""){
            Expression e = new Expression(expressionString);
            try {
                e.solve();
                text_Result.setText(e.getValue() + "");
                text_smallResult.setText(expressionString + " = " + e.getValue());
                expressionString = e.getValue() + "";
            }catch (Exception ex){
                text_smallResult.setText("");
                text_Result.setText("LỖI");
                expressionString="invalid";
            }
            return;
        }
        for (int i = 0; i < numpad.length; i++) {
            if (numpad[i].getId() == v.getId()) {
                if(Expression.containEqual(text_smallResult.getText()+"")||expressionString.equals("invalid")){
                    expressionString="";
                    text_Result.setText("");
                }
                expressionString += i + "";
                addText(text_Result, i + "");
                text_smallResult.setText(expressionString);
                isInputPhrase_Math=true;
            }
        }
        if (v.getId()==R.id.button_numpad_dot) {
            expressionString += ".";
            addText(text_Result, ".");
            text_smallResult.setText(expressionString);
        }
        if(isInputPhrase_Math) {
            switch (v.getId()) {
                case R.id.button_Math_plus:
                    expressionString += " + ";
                    text_smallResult.setText(expressionString);
                    isInputPhrase_Math = false;
                    break;
                case R.id.button_Math_minus:
                    expressionString += " - ";
                    text_smallResult.setText(expressionString);
                    isInputPhrase_Math = false;
                    break;
                case R.id.button_Math_multiply:
                    expressionString += " * ";
                    text_smallResult.setText(expressionString);
                    isInputPhrase_Math = false;
                    break;
                case R.id.button_Math_divide:
                    expressionString += " / ";
                    text_smallResult.setText(expressionString);
                    isInputPhrase_Math = false;
                    break;
                case R.id.button_Math_mod:
                    expressionString += " % ";
                    text_smallResult.setText(expressionString);
                    isInputPhrase_Math = false;
                    break;
                case R.id.button_Math_1phanX:
                    String tempX_str = Expression.getLastString(expressionString);
                    double tempX = Double.parseDouble(tempX_str);
                    if (tempX == 0) break;
                    tempX = 1 / tempX;
                    int temp_length = tempX_str.length();
                    expressionString = expressionString.substring(0, expressionString.length() - temp_length) + tempX;
                    text_smallResult.setText(expressionString);
                    text_Result.setText(Expression.getLastString(expressionString));
                    break;
                case R.id.button_Math_xmu2:
                    String tempMu_str = Expression.getLastString(expressionString);
                    double tempMu = Double.parseDouble(tempMu_str);
                    if (tempMu == 0) break;
                    tempMu = BasicMath.xMu2(tempMu);
                    int tempMu_length = tempMu_str.length();
                    expressionString = expressionString.substring(0, expressionString.length() - tempMu_length) + tempMu;
                    text_smallResult.setText(expressionString);
                    text_Result.setText(Expression.getLastString(expressionString));
                    break;
                case R.id.button_Math_sqrt:
                    String tempSQRT_str = Expression.getLastString(expressionString);
                    double tempSQRT = Double.parseDouble(tempSQRT_str);
                    if (tempSQRT == 0) break;
                    tempSQRT = BasicMath.sqrtX(tempSQRT);
                    int tempSQRT_length = tempSQRT_str.length();
                    expressionString = expressionString.substring(0, expressionString.length() - tempSQRT_length) + tempSQRT;
                    text_smallResult.setText(expressionString);
                    text_Result.setText(Expression.getLastString(expressionString));
                    break;
                case R.id.button_Math_DaoDau:
                    String tempDD_str = Expression.getLastString(expressionString);
                    double tempDD = Double.parseDouble(tempDD_str);
                    if (tempDD == 0) break;
                    tempDD = BasicMath.reverse(tempDD);
                    int tempDD_length = tempDD_str.length();
                    expressionString = expressionString.substring(0, expressionString.length() - tempDD_length) + tempDD;
                    text_smallResult.setText(expressionString);
                    text_Result.setText(Expression.getLastString(expressionString));
                    break;
            }
        }
        switch (v.getId()){
            //xoa tat ca
            case R.id.button_action_C:
                expressionString="";
                text_smallResult.setText("");
                text_Result.setText("");
                break;
            //xoa phan tu cuoi
            case R.id.button_action_CE:
                if(expressionString.equals("invalid")) expressionString="";
                if(expressionString.equals("")||expressionString.equals("0")) break;
                String temp = Expression.getLastString(expressionString);
                if(Check.isNumber(temp)){
                    int temp_length = temp.length();
                    expressionString = expressionString.substring(0,expressionString.length()-temp_length);
                }
                else{
                    expressionString = expressionString.substring(0,expressionString.length()-3);
                }
                text_smallResult.setText(expressionString);
                break;
            case R.id.button_action_back:
                if(expressionString.equals("")||expressionString.equals("0")) break;
                if(Check.isNumber(Expression.getLastString(expressionString)))
                    expressionString=expressionString.substring(0,expressionString.length()-1);
                else
                    expressionString=expressionString.substring(0,expressionString.length()-3);
                text_smallResult.setText(expressionString);
                text_Result.setText(Expression.getLastString(expressionString));
                break;
        }
        if(!Check.isNumber(Expression.getLastString(expressionString))){
            text_Result.setText("");
        }
        if(expressionString.contains("invalid")) expressionString="";
        expressionString=Expression.wipeDuplicateZero(expressionString);
        text_smallResult.setText(expressionString);
        text_Result.setText(Expression.getLastString(expressionString));
        if(expressionString==""){
            expressionString="0";
            text_Result.setText(expressionString);
            text_smallResult.setText(expressionString);
        }

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
