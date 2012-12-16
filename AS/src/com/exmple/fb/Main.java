package com.exmple.fb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Main extends Activity {
	Intent intent;
	
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //custom
       /* button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);
        button6=(Button) findViewById(R.id.button6);
        button7=(Button) findViewById(R.id.button7);*/
        
       
        /*button2.setOnClickListener(new View.OnClickListener()
        {
			public void onClick(View v) 
			{
				setContentView(R.layout.dedays);
			}
		}
        );
        
        
        button4.setOnClickListener(new View.OnClickListener()
        {
			public void onClick(View v) 
			{
				setContentView(R.layout.mechdays);
			}
		}
        );
        
        
        button5.setOnClickListener(new View.OnClickListener()
        {
			public void onClick(View v) 
			{
				setContentView(R.layout.chdays);
			}
		}
        );
        
        button6.setOnClickListener(new View.OnClickListener()
        {
			public void onClick(View v) 
			{
				setContentView(R.layout.cidays);
			}
		}
        );
        
        button7.setOnClickListener(new View.OnClickListener()
        {
			public void onClick(View v) 
			{
				setContentView(R.layout.mncdays);
			}
		}
        );*/
        
    }
    
    /** Called when the user clicks the Send button */
    public void click1(View view) {
        // Do something in response to button
    	intent=new Intent(Main.this,Cse.class);
    	startActivity(intent);
    }
    
    
    public void click2(View view) {
        // Do something in response to button
    	intent=new Intent(Main.this,ECE.class);
    	startActivity(intent);
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.days, menu);
        return true;
    }
    
}
