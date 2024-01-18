package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText amount_editText;
    EditText custom_editText;
    Button tip_button;
    Button total_button;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount_editText = (EditText) findViewById(R.id.amount_editText);
        custom_editText = (EditText) findViewById(R.id.custom_editText);
        tip_button = (Button) findViewById(R.id.tip_button);
        total_button = (Button) findViewById(R.id.total_button);

        TipButtonHandler tiphandler = new TipButtonHandler();
        tip_button.setOnClickListener(tiphandler);

        TotalButtonHandler totalhandler = new TotalButtonHandler();
        total_button.setOnClickListener(totalhandler);

        builder = new AlertDialog.Builder(MainActivity.this);
    }

    public class TipButtonHandler implements View.OnClickListener {
        public void onClick(View view) {
            try {
                float amount = Float.parseFloat(amount_editText.getText().toString());
                float custom = Float.parseFloat(custom_editText.getText().toString())/100;
                if(custom<=0.3) {
                    float tip = amount * custom;
                    float total = amount + tip;
                    builder.setTitle("Tip");
                    builder.setMessage(String.format("%.2f", tip));
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else
                {
                    Toast toast = Toast.makeText(MainActivity.this , "小費不能超過30%", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }catch (NumberFormatException e){
                Toast toast = Toast.makeText(MainActivity.this , "欄位不能空白", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    public class TotalButtonHandler implements View.OnClickListener{
        public void onClick(View view) {
            try {
                float amount = Float.parseFloat(amount_editText.getText().toString());
                float custom = Float.parseFloat(custom_editText.getText().toString())/100;
                if(custom<=0.3) {
                    float tip = amount * custom;
                    float total = amount + tip;
                    builder.setTitle("Total");
                    builder.setMessage(String.format("%.2f", total));
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else
                {
                    Toast toast = Toast.makeText(MainActivity.this , "小費不能超過30%", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }catch (NumberFormatException e){
                Toast toast = Toast.makeText(MainActivity.this , "欄位不能空白", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}