 package com.hello.quizmate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Quiz extends Activity {

	Vector<String> v=new Vector<String>(1);
	public String input;
	boolean delete;
	//int flag=0;
	int temp=0;
	TextView tv;
	CheckBox cb;
	String line;
	int linenumber=1;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //opening questions folder from sd card to read the questions
        
        
        	try{
        		
        		File file = new File("/sdcard/blutooth/questions/questions.txt");
        		BufferedReader reader = new BufferedReader(new FileReader("/sdcard/bluetooth/questions/questions.txt"));
        		
        		line=reader.readLine();
        		while(line!=null){
        			v.addElement(line);
        			line=reader.readLine();
        			linenumber++;
        		}
        	}

            catch (IOException e) {
                e.printStackTrace();
            }
        	
        
        
        setContentView(R.layout.quiz);
        
        tv=(TextView) findViewById(R.id.textView1);
        tv.setText(v.elementAt(temp));
        cb=(CheckBox)findViewById(R.id.checkBox1);
        cb.setText(v.elementAt(temp+1));
        cb=(CheckBox)findViewById(R.id.checkBox2);
        cb.setText(v.elementAt(temp+2));
        cb=(CheckBox)findViewById(R.id.checkBox3);
        cb.setText(v.elementAt(temp+3));
        cb=(CheckBox)findViewById(R.id.checkBox4);
        cb.setText(v.elementAt(temp+4));
        
        //first=Integer.parseInt(v.elementAt(0));
        
	}
	
	public void next(View view)
	{
		temp=temp+5;
		/*Intent intent=new Intent(Quiz.this,Quiz.class);
		startActivity(intent);*/
		if((temp+5)<linenumber)
		{
			tv=(TextView) findViewById(R.id.textView1);
			tv.setText(v.elementAt(temp));
			cb=(CheckBox)findViewById(R.id.checkBox1);
	        if (cb.isChecked()) {
	            cb.setChecked(false);
	        }
	        cb.setText(v.elementAt(temp+1));
	        cb=(CheckBox)findViewById(R.id.checkBox2);
	        if (cb.isChecked()) {
	            cb.setChecked(false);
	        }
	        cb.setText(v.elementAt(temp+2));
	        cb=(CheckBox)findViewById(R.id.checkBox3);
	        if (cb.isChecked()) {
	            cb.setChecked(false);
	        }
	        cb.setText(v.elementAt(temp+3));
	        cb=(CheckBox)findViewById(R.id.checkBox4);
	        if (cb.isChecked()) {
	            cb.setChecked(false);
	        }
	        cb.setText(v.elementAt(temp+4));
	        
	        
	     }
		else
		{
			Intent intent=new Intent(Quiz.this,Submit.class);
			startActivity(intent);
		}
		
	}

	public void prev(View view)
	{
	
			temp=temp-5;
			if(temp>=0){
			
			tv=(TextView) findViewById(R.id.textView1);
	        tv.setText(v.elementAt(temp));
	        CheckBox cb=(CheckBox)findViewById(R.id.checkBox1);
	        if (cb.isChecked()) {
	            cb.setChecked(false);
	        }
	        cb.setText(v.elementAt(temp+1));
	        CheckBox cb1=(CheckBox)findViewById(R.id.checkBox2);
	        if (cb1.isChecked()) {
	            cb1.setChecked(false);
	        }
	        cb1.setText(v.elementAt(temp+2));
	        CheckBox cb2=(CheckBox)findViewById(R.id.checkBox3);
	        if (cb2.isChecked()) {
	            cb2.setChecked(false);
	        }
	        cb2.setText(v.elementAt(temp+3));
	        CheckBox cb3=(CheckBox)findViewById(R.id.checkBox4);
	        if (cb3.isChecked()) {
	            cb3.setChecked(false);
	        }
	        cb3.setText(v.elementAt(temp+4));
	        }
			
	}
	
	public void cb1(View view) {
	    // Is the view now checked?
	    boolean checked = ((CheckBox) view).isChecked();
	    
	    // Check which checkbox was clicked
	    switch(view.getId()) 
	    {
	        case R.id.checkBox1:
	            if (checked)
	            {
	            	try{

                        File file = new File("/sdcard/answer/answer.txt"); 
                        BufferedWriter writer = new BufferedWriter(new FileWriter("/sdcard/answer/answer.txt",true));
						writer.write("1");
                        writer.newLine();
                        writer.flush();
                        writer.close();
                        }

                        catch (IOException e) {
                            e.printStackTrace();
                        }
	            }
	                // Put some meat on the sandwich
	           /* else
	            { 
	            	try{

                        File file = new File("/sdcard/answer/answer.txt"); 
                        BufferedWriter writer = new BufferedWriter(new FileWriter("/sdcard/answer/answer.txt",true));
						writer.write("0");
                        writer.newLine();
                        writer.flush();
                        writer.close();
                        }

                        catch (IOException e) {
                            e.printStackTrace();
                        }
	            }
	            break;*/
	        case R.id.checkBox2:
	            if (checked)
	            {   
	            	try{

                        File file = new File("/sdcard/answer/answer.txt"); 
                        BufferedWriter writer = new BufferedWriter(new FileWriter("/sdcard/answer/answer.txt",true));
						writer.write("2");
                        writer.newLine();
                        writer.flush();
                        writer.close();
                        }

                        catch (IOException e) {
                            e.printStackTrace();
                        }
	            }
	        
	        case R.id.checkBox3:
	            if (checked)
	            {
	            	try{

                        File file = new File("/sdcard/answer/answer.txt"); 
                        BufferedWriter writer = new BufferedWriter(new FileWriter("/sdcard/answer/answer.txt",true));
						writer.write("3");
                        writer.newLine();
                        writer.flush();
                        writer.close();
                        }

                        catch (IOException e) {
                            e.printStackTrace();
                        }
	            }
	                // Put some meat on the sandwic
	            
	        case R.id.checkBox4:
	            if (checked)
	            {
	            	try{

                        File file = new File("/sdcard/answer/answer.txt"); 
                        BufferedWriter writer = new BufferedWriter(new FileWriter("/sdcard/answer/answer.txt",true));
						writer.write("4");
                        writer.newLine();
                        writer.flush();
                        writer.close();
                        }

                        catch (IOException e) {
                            e.printStackTrace();
                        }
	            }
	                // Put some meat on the sandwich
	            
	        // TODO: Veggie sandwich
	    }
	}
}
