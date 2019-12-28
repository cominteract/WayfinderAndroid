package com.wayfinder.wayfinder;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class Home extends Activity {
	Button sched,adsummit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		 //ImageView img = (ImageView)findViewById(R.id.imgflare);
		LinearLayout img = (LinearLayout)findViewById(R.id.imghead);
		LinearLayout home = (LinearLayout)findViewById(R.id.linearhome);
		 Animation myFadeInAnimation = AnimationUtils.loadAnimation(Home.this, R.anim.tweenbut);
		 
		 Animation myFadeInAnimation2 = AnimationUtils.loadAnimation(Home.this, R.anim.tweenbut2);
		 Animation myFadeInAnimation3 = AnimationUtils.loadAnimation(Home.this, R.anim.tweenhead);
        sched = (Button)findViewById(R.id.sched);
        sched.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(Home.this,ImageMap.class);
            	startActivity(intent);
            }
        });
      
        adsummit = (Button)findViewById(R.id.adsummit);
        adsummit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(Home.this,ScheduleViewActivity.class);
            	startActivity(intent);
            }
        });
        adsummit.startAnimation(myFadeInAnimation);
        sched.startAnimation(myFadeInAnimation2);
        img.startAnimation(myFadeInAnimation3);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
