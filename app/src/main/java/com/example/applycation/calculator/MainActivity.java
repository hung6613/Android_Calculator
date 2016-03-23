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

    String expressionString = "";
    String resultString = "";
    TextView text_Result,text_smallResult;
    Button numpad[],numpadDot;
    Button math_Plus,math_Minus,math_Multi,math_Divide,math_Mod;
    Button action_Equal,action_CE,action_C, action_Back;

    Button m_Plus, m_Minus, m_Clear, m_Result, m_Save, m_Memory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attachIdToView();
        attachOnClickListener();

        text_Result.setText("");
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

        //Listener for numpad
        for(int i=0;i<numpad.length;i++){
            if(v.getId()==numpad[i].getId()){
                if(Expression.containEqual(text_smallResult.getText().toString())){
                    text_Result.setText(i+"");
                    text_smallResult.setText(i+"");
                    expressionString += i+"";
                }
                else {
                    addText(text_Result,i+"");
                    expressionString += i+"";
                }
            }
        }

        //Listener cho tung nut
        switch (v.getId()){

            case R.id.button_numpad_dot:
                addText(text_Result,".");
                expressionString += ".";
                break;

            //Math
            case R.id.button_Math_plus:
                if(expressionString.equals("")){
                    expressionString = resultString;
                    expressionString += " + ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
                else{
                    expressionString += " + ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
                break;
            case R.id.button_Math_minus:
                if(expressionString.equals("")){
                    expressionString = resultString;
                    expressionString += " - ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
                else{
                    expressionString += " - ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
                break;
            case R.id.button_Math_multiply:
                if(expressionString.equals("")){
                    expressionString = resultString;
                    expressionString += " * ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
                else{
                    expressionString += " * ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
                break;
            case R.id.button_Math_divide:
                if(expressionString.equals("")){
                    expressionString = resultString;
                    expressionString += " / ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
                else{
                    expressionString += " / ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
                break;
            case R.id.button_Math_mod:
                if(expressionString.equals("")){
                    expressionString = resultString;
                    expressionString += " % ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
                else{
                    expressionString += " % ";
                    text_smallResult.setText(expressionString);
                    text_Result.setText("");
                }
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
                    resultString = expression.getValue()+"";
                    text_Result.setText((int) expression.getValue() + "");
                    //resultString = expressionString;
                }
                else{
                    expressionString = text_Result.getText().toString();
                    resultString = expressionString;
                }
                text_smallResult.setText(expressionString);
                expressionString = "";
                break;
            //********************************************************************************

            //xu li M
            // ********************************************************************************
            case R.id.buttonMPlus:
                expressionString = text_Result.getText().toString();
                M.Mplus(Double.parseDouble(expressionString));
                text_Result.setText("0");
                text_smallResult.setText(expressionString);
                break;
            case R.id.buttonMMinus:
                expressionString = text_Result.getText().toString();
                M.Mminus(Double.parseDouble(expressionString));
                text_Result.setText("0");
                text_smallResult.setText(expressionString);
                break;
            case R.id.buttonMS:
                expressionString = text_Result.getText().toString();
                M.MSave(Double.parseDouble(expressionString));
                text_Result.setText("0");
                text_smallResult.setText(expressionString);
                break;
            case R.id.buttonMR:
                expressionString = M.MResult()+"";
                text_Result.setText(expressionString);
                break;
            case R.id.buttonMC:
                M.MClear();
                text_Result.setText("0");
                break;

            //button Back
            case R.id.button_action_back:
                if(expressionString.length() < 2)  {
                    expressionString = "";
                    text_smallResult.setText(expressionString);
                    text_Result.setText(expressionString);
                }
                else{
                    if(!Expression.containEqual(expressionString)) {
                        if (Expression.containOperator(expressionString)) {
                            if(Expression.containOperator(Expression.getLastString(expressionString))){
                                expressionString = expressionString.substring(0, expressionString.length()-3);
                                text_smallResult.setText(expressionString);
                            }
                            else{
                                expressionString = expressionString.substring(0, expressionString.length()-1);
                                text_smallResult.setText(expressionString);
                                text_Result.setText(Expression.getLastString(expressionString));
                            }
                        }
                        else{
                            expressionString = expressionString.substring(0, expressionString.length()-1);
                            text_smallResult.setText(expressionString);
                            text_Result.setText(expressionString);
                        }
                    }
                }
                break;
            case R.id.button_action_CE:
                expressionString = "0";
                text_Result.setText(expressionString);
                break;
            case R.id.button_action_C:
                expressionString = "0";
                text_Result.setText(expressionString);
                expressionString = "";
                text_smallResult.setText(expressionString);
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
