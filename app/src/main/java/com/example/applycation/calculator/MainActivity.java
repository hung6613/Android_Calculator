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
import com.example.applycation.calculator.memory.Memory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Memory M = new Memory();
    //*********************************************************************************************
    String string_Text = "";
    String expressionString = "";
    TextView text_Result,text_smallResult;
    Button numpad[],numpadDot;
    Button math_Plus,math_Minus,math_Multi,math_Divide,math_Mod;
    Button action_Equal,action_CE,action_C, action_Back;

    Button m_Plus, m_Minus, m_Clear, m_Result, m_Save, m_Memory;
    Button math_MotphanX,math_SQRT;

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
        math_MotphanX= (Button) findViewById(R.id.button_Math_1phanX);
        math_SQRT= (Button) findViewById(R.id.button_Math_sqrt);

        //action
        action_Equal = (Button)findViewById(R.id.button_action_equal);
        action_CE = (Button)findViewById(R.id.button_action_CE);
        action_C = (Button)findViewById(R.id.button_action_C);
        action_Back = (Button)findViewById(R.id.button_action_back);
        //M
        m_Clear = (Button)findViewById(R.id.buttonMC);
        m_Memory = (Button)findViewById(R.id.buttonMScroll);
        m_Minus = (Button)findViewById(R.id.buttonMMinus);
        m_Plus = (Button)findViewById(R.id.buttonMPlus);
        m_Result = (Button)findViewById(R.id.buttonMR);
        m_Save = (Button)findViewById(R.id.buttonMS);

    }
    //gan Listener vao cac doi tuong
    public void attachOnClickListener(){

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
        math_MotphanX.setOnClickListener(this);

        //action
        action_Equal.setOnClickListener(this);
        action_CE.setOnClickListener(this);
        action_C.setOnClickListener(this);
        action_Back.setOnClickListener(this);

        //M
        m_Save.setOnClickListener(this);
        m_Minus.setOnClickListener(this);
        m_Result.setOnClickListener(this);
        m_Memory.setOnClickListener(this);
        m_Clear.setOnClickListener(this);
        m_Plus.setOnClickListener(this);

    }
    //Them noi dung vao TextView
    public void addText(TextView textView,String content){
        String oldText = textView.getText().toString();
        textView.setText(oldText + content);
    }

    //cai dat Listener
    @Override
    public void onClick(View v) {
        //*
        //khong dung cho truong button equal
        //Neu bieu thuc o smallResult chua dau = thi moi lan goi Listener se gan lai ket qua o Result cho smallResult

        if(     v.getId()!=R.id.button_action_equal
                &&  Expression.containEqual(text_smallResult.getText().toString())
                ){
            expressionString = text_Result.getText().toString();
            text_smallResult.setText(expressionString);
        }

        //Khong su dung
        //*
        //Neu phan tu cuoi cung khong phai la toan tu thi xoa smallResult va nhap lai.
        /*if(!Check.isOperator(Expression.getLastString(text_smallResult.getText().toString()))){
            text_smallResult.setText("");
        }*/

        //Listener cho tung nut
        switch (v.getId()){

            //Numpad
            case R.id.button_numpad_0 :
                addText(text_Result,"0");
                expressionString += "0";
                break;
            case R.id.button_numpad_1 :
                addText(text_Result,"1");
                expressionString += "1";
                break;
            case R.id.button_numpad_2 :
                addText(text_Result,"2");
                expressionString += "2";
                break;
            case R.id.button_numpad_3 :
                addText(text_Result,"3");
                expressionString += "3";
                break;
            case R.id.button_numpad_4 :
                addText(text_Result,"4");
                expressionString += "4";
                break;
            case R.id.button_numpad_5 :
                addText(text_Result,"5");
                expressionString += "5";
                break;
            case R.id.button_numpad_6 :
                addText(text_Result,"6");
                expressionString += "6";
                break;
            case R.id.button_numpad_7 :
                addText(text_Result,"7");
                expressionString += "7";
                break;
            case R.id.button_numpad_8 :
                addText(text_Result,"8");
                expressionString += "8";
                break;
            case R.id.button_numpad_9 :
                addText(text_Result,"9");
                expressionString += "9";
                break;
            case R.id.button_numpad_dot:
                addText(text_Result,".");
                expressionString += ".";
                break;

            //Math
            case R.id.button_Math_plus:
                expressionString += " + ";
                text_smallResult.setText(expressionString);
                text_Result.setText("");
                break;
            case R.id.button_Math_minus:
                expressionString += " - ";
                text_smallResult.setText(expressionString);
                text_Result.setText("");
                break;
            case R.id.button_Math_multiply:
                expressionString += " * ";
                text_smallResult.setText(expressionString);
                text_Result.setText("");
                break;
            case R.id.button_Math_divide:
                expressionString += " / ";
                text_smallResult.setText(expressionString);
                text_Result.setText("");
                break;
            case R.id.button_Math_mod:
                expressionString += " % ";
                text_smallResult.setText(expressionString);
                text_Result.setText("");
                break;

            //Action
            //Xu li dau =
            //*******************************************************************************
            case R.id.button_action_equal:

                if(     !Expression.containEqual(expressionString)   //neu ko co dau = thi moi chay
                        &&  Expression.containOperator(expressionString) //neu bieu thuc chi co 1 so thi ko chay

                        ) {
                    Expression expression = new Expression(expressionString);
                    expression.solve();
                    expressionString += " = " + expression.solve();
                    text_Result.setText((int) expression.getValue() + "");
                }
                else{
                    expressionString = text_Result.getText().toString();
                }
                text_smallResult.setText(expressionString);
                break;
            //********************************************************************************

           /* case R.id.button_Math_1phanX:
                double x=1/ Double.parseDouble(text_Result.getText()+"");
               // expressionString
                text_Result.setText(x+"");*/

            //case R.id.button_Math_sqrt:

            case R.id.button_action_back:
                string_Text = text_Result.getText().toString();
                expressionString = text_smallResult.getText().toString();
                //String str_Back = string_Text.substring(0,string_Text.length()-2).toString();
                //text_Result.setText(str_Back);
                if(string_Text.length()>1){
                    String str_Back = string_Text.substring(0,string_Text.length()-1).toString();
                    String str_BackSmall = expressionString.substring(0, expressionString.length()-1).toString();
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
