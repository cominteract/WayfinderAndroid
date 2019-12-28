package com.wayfinder.wayfinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SchedFri extends Activity {
	int count = 0;
	Button first,second,third,fourth,push;
	int[] arrswipe = {R.drawable.merleecomplete,R.drawable.cheukcomplete,R.drawable.simoncomplete,R.drawable.arielcomplete};
	int[] arrselected = {R.drawable.merleesel,R.drawable.cheuksel,R.drawable.simonsel,R.drawable.arielsel};
	int[] arrunselected = {R.drawable.merleeunsel,R.drawable.cheukunsel,R.drawable.simonunsel,R.drawable.arielunsel};
	int[] arrbutton = {R.id.first_button,R.id.second_button,R.id.third_button,R.id.fourth_button};
	LinearLayout profile,back,next;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sched_fri);
			back = (LinearLayout)findViewById(R.id.prevsel);
			next = (LinearLayout)findViewById(R.id.nextsel);
		 	first = (Button)findViewById(R.id.first_button);
		    second = (Button)findViewById(R.id.second_button);
	        third = (Button)findViewById(R.id.third_button);
	        fourth = (Button)findViewById(R.id.fourth_button);
	        profile = (LinearLayout)findViewById(R.id.ft2);
	        
	        next.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                Intent intent = new Intent(SchedFri.this,Sched.class);
	            	startActivity(intent);
	            }
	        });
	        back.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                Intent intent = new Intent(SchedFri.this,SchedThurs.class);
	            	startActivity(intent);
	            }
	        });
	        
	        
	        profile.setOnTouchListener(new SwipeClass(null) {

	            public void onSwipeRight() {
	            	count++;
            		if(count>3)
	            	count = 0;	
            		setSelected();
	            }
	            public void onSwipeLeft() {
	            	count--;
            		if(count<0)
            		count = 3;	
            		setSelected();
	            }
	

	        public boolean onTouch(View v, MotionEvent event) {
	            return gestureDetector.onTouchEvent(event);
	        }
	        });
	        
	        
	        first.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	            	
	            	count = 0;
	            	setSelected();
	            }
	        });
	 
	        second.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	            	count = 1;
	            	setSelected();

	            }
	        });

	      
	        third.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	            	count = 2;
	            	setSelected();
	            }
	        });
	        
	        fourth.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	            	count = 3;
	            	setSelected();

	            }
	        });
	}

	public void setSelected()
	{
	   	for(int c1 = 0;c1<4;c1++)
    	{
    		push = (Button)findViewById(arrbutton[c1]);
    		push.setBackgroundResource(arrunselected[c1]);
    	}
		profile.setBackgroundResource(arrswipe[count]);
		push = (Button)findViewById(arrbutton[count]);
		push.setBackgroundResource(arrselected[count]);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sched_fri, menu);
		return true;
	}

}
