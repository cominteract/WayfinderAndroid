package com.wayfinder.wayfinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.MotionEvent;
public class SchedThurs extends Activity {

	Button first,second,third,fourth,fifth,sixth,push;
	int count = 5;
	int[] arrswipe = {R.drawable.louiecomplete,R.drawable.chotcomplete,R.drawable.marcuscomplete,R.drawable.sandipancomplete,R.drawable.boycomplete,R.drawable.dickcomplete};
	int[] arrselected = {R.drawable.louiesel,R.drawable.chotsel,R.drawable.marcussel,R.drawable.sandipansel,R.drawable.boysel,R.drawable.dicksel};
	int[] arrunselected = {R.drawable.louieunsel,R.drawable.chotunsel,R.drawable.marcusunsel,R.drawable.sandipanunsel,R.drawable.boyunsel,R.drawable.dickunsel};
	int[] arrbutton = {R.id.first_button,R.id.second_button,R.id.third_button,R.id.fourth_button,R.id.fifth_button,R.id.sixth_button};
	LinearLayout profile,home,next;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sched_thurs);
			home = (LinearLayout)findViewById(R.id.homesel);
	    	next = (LinearLayout)findViewById(R.id.nextsel);
			first = (Button)findViewById(R.id.first_button);
		    second = (Button)findViewById(R.id.second_button);
	        third = (Button)findViewById(R.id.third_button);
	        fourth = (Button)findViewById(R.id.fourth_button);
	        fifth = (Button)findViewById(R.id.fifth_button);
	        sixth = (Button)findViewById(R.id.sixth_button);
	        profile = (LinearLayout)findViewById(R.id.ft2);
	        
	        next.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                Intent intent = new Intent(SchedThurs.this,SchedFri.class);
	            	startActivity(intent);
	            }
	        });
	        home.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                Intent intent = new Intent(SchedThurs.this,Home.class);
	            	startActivity(intent);
	            }
	        });
	        
	        
	        
	        profile.setOnTouchListener(new SwipeClass(null) {
	            public void onSwipeRight() {
	            		count++;
	            		if(count>5)
		            	count = 0;
	            		setSelected();
	            }
	            public void onSwipeLeft() {
	            		count--;
	            		if(count<0)
	            		count = 5;
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
	        fifth.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	            	count = 4;
	            	setSelected();
	            }
	        });
	        sixth.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	            	count = 5;
		            setSelected();

	            }
	        });
	}

	public void setSelected()
	{
	   	for(int c1 = 0;c1<6;c1++)
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
		getMenuInflater().inflate(R.menu.sched_thurs, menu);
		return true;
	}

}
