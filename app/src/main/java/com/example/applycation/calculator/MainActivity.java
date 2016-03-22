package com.example.applycation.calculator;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.applycation.calculator.expression.Check;
import com.example.applycation.calculator.expression.Expression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String string_Text = "";
    String string_SmallText = "";
    TextView text_Result,text_smallResult;
    Button numpad0,numpad1,numpad2,numpad3,numpad4,numpad5,numpad6,numpad7,numpad8,numpad9,numpadDot;
    Button math_Plus,math_Minus,math_Multi,math_Divide,math_Mod;
    Button action_Equal,action_CE,action_C, action_Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attachIdToView();
        attachOnClickListener();

        text_Result.setText("0");
        text_smallResult.setText("");
    }
    //gan View vao cac doi tuong
    public void attachIdToView(){

        //text
        text_Result = (TextView)findViewById(R.id.text_Result);
        text_smallResult = (TextView)findViewById(R.id.text_SmallResult);

        //numpad
        numpad0 = (Button)findViewById(R.id.button_numpad_0);
        numpad1 = (Button)findViewById(R.id.button_numpad_1);
        numpad2 = (Button)findViewById(R.id.button_numpad_2);
        numpad3 = (Button)findViewById(R.id.button_numpad_3);
        numpad4 = (Button)findViewById(R.id.button_numpad_4);
        numpad5 = (Button)findViewById(R.id.button_numpad_5);
        numpad6 = (Button)findViewById(R.id.button_numpad_6);
        numpad7 = (Button)findViewById(R.id.button_numpad_7);
        numpad8 = (Button)findViewById(R.id.button_numpad_8);
        numpad9 = (Button)findViewById(R.id.button_numpad_9);
        numpadDot = (Button)findViewById(R.id.button_numpad_dot);

        //math
        math_Plus = (Button)findViewById(R.id.button_Math_plus);
        math_Minus = (Button)findViewById(R.id.button_Math_minus);
        math_Multi = (Button)findViewById(R.id.button_Math_multiply);
        math_Divide = (Button)findViewById(R.id.button_Math_divide);
        math_Mod = (Button)findViewById(R.id.button_Math_mod);

        //action
        action_Equal = (Button)findViewById(R.id.button_action_equal);
        action_CE = (Button)findViewById(R.id.button_action_CE);
        action_C = (Button)findViewById(R.id.button_action_C);
        action_Back = (Button)findViewById(R.id.button_action_back);
    }
    //gan Listener vao cac doi tuong
    public void attachOnClickListener(){

        //numpad
        numpad0.setOnClickListener(this);
        numpad1.setOnClickListener(this);
        numpad2.setOnClickListener(this);
        numpad3.setOnClickListener(this);
        numpad4.setOnClickListener(this);
        numpad5.setOnClickListener(this);
        numpad6.setOnClickListener(this);
        numpad7.setOnClickListener(this);
        numpad8.setOnClickListener(this);
        numpad9.setOnClickListener(this);
        numpadDot.setOnClickListener(this);

        //math
        math_Plus.setOnClickListener(this);
        math_Minus.setOnClickListener(this);
        math_Multi.setOnClickListener(this);
        math_Divide.setOnClickListener(this);
        math_Mod.setOnClickListener(this);

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

    //cai dat Listener
    @Override
    public void onClick(View v) {
        if(Expression.containEqual(text_smallResult.getText().toString())){
            /*String temp = Expression.getLastNumber(text_smallResult.getText().toString());
            text_smallResult.setText(temp);
            text_Result.setText(temp);*/
            text_smallResult.setText(text_Result.getText());
        }
        //Neu bieu thuc o smallResult chua dau = thi moi lan goi Listener se gan lai ket qua o Result cho smallResult

        /*if(!Check.isOperator(Expression.getLastString(text_smallResult.getText().toString()))){
            text_smallResult.setText("");
        }*/
        //Neu phan tu cuoi cung khong phai la toan tu thi xoa smallResult va nhap lai.

        switch (v.getId()){

            //Numpad
            case R.id.button_numpad_0 :
                addText(text_Result,"0");
                addText(text_smallResult,"0");
                break;
            case R.id.button_numpad_1 :
                addText(text_Result,"1");
                addText(text_smallResult,"1");
                break;
            case R.id.button_numpad_2 :
                addText(text_Result,"2");
                addText(text_smallResult,"2");
                break;
            case R.id.button_numpad_3 :
                addText(text_Result,"3");
                addText(text_smallResult,"3");
                break;
            case R.id.button_numpad_4 :
                addText(text_Result,"4");
                addText(text_smallResult,"4");
                break;
            case R.id.button_numpad_5 :
                addText(text_Result,"5");
                addText(text_smallResult,"5");
                break;
            case R.id.button_numpad_6 :
                addText(text_Result,"6");
                addText(text_smallResult,"6");
                break;
            case R.id.button_numpad_7 :
                addText(text_Result,"7");
                addText(text_smallResult,"7");
                break;
            case R.id.button_numpad_8 :
                addText(text_Result,"8");
                addText(text_smallResult,"8");
                break;
            case R.id.button_numpad_9 :
                addText(text_Result,"9");
                addText(text_smallResult,"9");
                break;
            case R.id.button_numpad_dot:
                addText(text_Result,".");
                addText(text_smallResult,".");
                break;

            //Math
            case R.id.button_Math_plus:
                addText(text_smallResult," + ");
                text_Result.setText("");
                break;
            case R.id.button_Math_minus:
                addText(text_smallResult," - ");
                text_Result.setText("");
                break;
            case R.id.button_Math_multiply:
                addText(text_smallResult," * ");
                text_Result.setText("");
                break;
            case R.id.button_Math_divide:
                addText(text_smallResult," / ");
                text_Result.setText("");
                break;
            case R.id.button_Math_mod:
                addText(text_smallResult," % ");
                text_Result.setText("");
                break;

            //Action
            //Xu li dau =
            //*******************************************************************************
            case R.id.button_action_equal:

                Expression expression = new Expression(text_smallResult.getText().toString());
                if(!Expression.containEqual(expression.getExpression())) {
                    expression.solve();
                    addText(text_smallResult, " = " + expression.getValue());
                    text_Result.setText((int) expression.getValue() + "");
                }
                else{
                    text_smallResult.setText(text_Result.getText());
                }
                break;
            //********************************************************************************


            case R.id.button_action_back:
                string_Text = text_Result.getText().toString();
                string_SmallText = text_smallResult.getText().toString();
                //String str_Back = string_Text.substring(0,string_Text.length()-2).toString();
                //text_Result.setText(str_Back);
                if(string_Text.length()>1){
                    String str_Back = string_Text.substring(0,string_Text.length()-1).toString();
                    String str_BackSmall = string_SmallText.substring(0,string_SmallText.length()-1).toString();
                    text_Result.setText(str_Back);
                    text_smallResult.setText(str_BackSmall);
                }
                else{
                    text_Result.setText("0");
                }
                break;
            case R.id.button_action_CE:
                //text_smallResult.setText("");
                text_Result.setText("0");
                break;
            case R.id.button_action_C:
                text_smallResult.setText("");
                text_Result.setText("0");
                break;
            default:
                break;
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
