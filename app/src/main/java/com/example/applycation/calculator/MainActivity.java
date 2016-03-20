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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text_Result,text_smallResult;
    Button numpad0,numpad1,numpad2,numpad3,numpad4,numpad5,numpad6,numpad7,numpad8,numpad9,numpadDot;

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
        text_Result = (TextView)findViewById(R.id.text_Result);
        text_smallResult = (TextView)findViewById(R.id.text_SmallResult);
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
    }
    //gan Listener vao cac doi tuong
    public void attachOnClickListener(){
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
    }
    //Them noi dung vao TextView
    public void addText(TextView textView,String content){
        String oldText = textView.getText().toString();
        textView.setText(oldText + content);
    }
    //cai dat Listener
    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
