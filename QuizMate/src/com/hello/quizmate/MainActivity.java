package com.hello.quizmate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	public EditText mEdit;
	public String input;
	boolean delete;
	//File myfile=new File("/sdcard/answer/answer.txt");
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBotton=new Button(this);
        Button mButton = (Button)findViewById(R.id.button1);
        mEdit   = (EditText)findViewById(R.id.editText1);

        mButton.setOnClickListener(
            new View.OnClickListener()
            {
                public void onClick(View view)
                {
                     input=mEdit.getText().toString();
                     try{

                         File file = new File("/sdcard/answer/answer.txt");
                         delete=file.delete();
                         BufferedWriter writer = new BufferedWriter(new FileWriter("/sdcard/answer/answer.txt",true));

                         writer.write(input);
                         writer.newLine();
                         writer.flush();
                         writer.close();
                         }

                         catch (IOException e) {
                             e.printStackTrace();
                         }
                     Intent intent=new Intent(MainActivity.this,Quiz.class);
                     startActivity(intent);
                }
            });
        
        
        
    }
    
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
}
