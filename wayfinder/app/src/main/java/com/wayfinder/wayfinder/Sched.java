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


public class Sched extends Activity {
	int count = 0;
	int[] arrswipe = {R.drawable.charlescomplete,R.drawable.emilycomplete,R.drawable.tomcomplete};
	int[] arrselected = {R.drawable.charlessel,R.drawable.emilysel,R.drawable.tomsel};
	int[] arrunselected = {R.drawable.charlesunsel,R.drawable.emilyunsel,R.drawable.tomunsel};
	int[] arrbutton = {R.id.first_button,R.id.second_button,R.id.third_button};
	Button first,second,third,push;
	LinearLayout profile,back,home;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sched);
		back = (LinearLayout)findViewById(R.id.prevsel);
		home = (LinearLayout)findViewById(R.id.homesel);
	    first = (Button)findViewById(R.id.first_button);
	    second = (Button)findViewById(R.id.second_button);
        third = (Button)findViewById(R.id.third_button);
        profile = (LinearLayout)findViewById(R.id.ft2);
        
        
        home.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Sched.this,Home.class);
            	startActivity(intent);
            }
        });
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Sched.this,SchedFri.class);
            	startActivity(intent);
            }
        });
        
        
        
        profile.setOnTouchListener(new SwipeClass(null) {
            public void onSwipeRight() {
            	count++;
        		if(count>2)
            	count = 0;	
            	setSelected();
            }
            public void onSwipeLeft() {
            	count--;
        		if(count<0)
        		count = 2;	
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

	}
	public void setSelected()
	{
	   	for(int c1 = 0;c1<3;c1++)
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
		getMenuInflater().inflate(R.menu.sched, menu);
		return true;
	}

}
