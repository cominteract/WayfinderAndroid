package com.wayfinder.wayfinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ImageMap extends Activity {
	Bitmap mapImageBitmap,blockDrawableBitmap,img3;
	ImageView home;
	ProgressDialog dialog;
	ListAdapter adapter = null;
	ImageView imgx;
	private ListView listView1;
	final ArrayList<String> list = new ArrayList<String>();
	String[] arrlist = {"EXIST EXHIBIT SYSTEMS TECHNOLOGY CORP.",
						"GREEN LITE",
						"SPIN MANILA",
						"MEGA MOBILE",
						"MBC",
						"ABS CBN",
						"MOBEXT",
						"FILIPINO STAR NGAYON",
						"ADOBO",
						"M3",
						"MANILA NORTH TOLLWAYS CORPORATION",
						"NONE",
						"BROTHER",
						"MEGAWORLD",
						"M1",
						"ALVEO LAND",
						"SM LIFESTYLE",
						"M2",
						"WI FUN",
						"VITAL STRATS",
						"CCI",
						"BIG PIX",
						"OMAG",
						"SMX",
						"URLED ENTERPRISE",
						"SBMA",
						"MANILA BULLETIN",
						"I ACADEMY",
						"PLDT",
						"NET PLAY INC",
						"VIDEO SONIC",
						"NONE",
						"ALC",
						"UNITED PRINT MEDIA GROUP (UPMG)",
						"NONE",
						"RCBC",
						"V CARGO",
						"CPE METROBANK",
						"PINOY XTREME",
						"MANILA NATURES",
						"SMART/TV 5",
						"PUREFOODS",
						"SECRETARIAT",
						"ASAP & HAND CREATIVE",
						"AIR21",
						"BOMBORADYO"};
	final ArrayList<Integer> listx = new ArrayList<Integer>();
	final ArrayList<Integer> listy = new ArrayList<Integer>();
	final ArrayList<Integer> listdrawable = new ArrayList<Integer>();
	final ArrayList<Integer> listedx = new ArrayList<Integer>();
	final ArrayList<Integer> listedy = new ArrayList<Integer>();
	final ArrayList<Integer> listeddrawable = new ArrayList<Integer>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_create);
		mapImageBitmap = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.mapimagebackground);

		home = (ImageView) findViewById(R.id.home);
		home.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	ImageMap.this.finish();
            }
        });

		listView1 = (ListView) findViewById(R.id.listbooth);
		listView1.setDivider(null);
		listView1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		/* companies */

		DisplayMetrics dm = getApplicationContext()
				.getResources().getDisplayMetrics();
		float width = dm.widthPixels ;
		float height = dm.heightPixels;
		int imageheight = (int) (.6 * height);
		int headerheight = (int) (.1 * height);
		Configuration config = getResources().getConfiguration();

		Log.d( " Screen Size " , " Screen H " + height + " Screen W " + width +
				" Config smallest screen " + config.smallestScreenWidthDp + " Width " + dm.widthPixels + " Height " + dm.heightPixels);


		//Width 1080:  Height 1776 ImageHeight 1065 Header Height 177
		//Width 1080:  Height 1776 ImageHeight 1065 Header Height 177
		/* x axis */
		//int initx = 87;
		float divisor;
		if(width>height)
			divisor = height;
		else
			divisor = width;
		float ratio = divisor/(float) config.smallestScreenWidthDp;

		Log.d(" Width " + width, " Height " + height + " ImageHeight " + imageheight + " Header Height " + headerheight + " Ratio " + ratio);


		/* drawables */

		iterateDrawables();

		/* x axis */
		iterateXAxis(width);

		/* y axis */
		iterateYAxis(height);
		
		



		
		/* end lists */
		final ArrayList<String> position_array = new ArrayList<String>();
		Log.d(" size dapat 45 ", " draw " + listdrawable.size() + " x " + listx.size() + " y " + listy.size());
		for(int lli = 0;lli < listdrawable.size();lli++)
		{
			
			if(!arrlist[lli].equals("NONE"))
			{
				list.add(arrlist[lli]);
				position_array.add(arrlist[lli]);
				listedx.add(listx.get(lli));
				listedy.add(listy.get(lli));
				listeddrawable.add(listdrawable.get(lli));
			}
			
		}

		Collections.sort(list);
		adapter = new ArrayAdapter<String>(this, R.layout.blacktext_list,R.id.list_content, list);
		listView1.setAdapter(adapter);

		
		/*final Typeface fonttype=Typeface.createFromAsset(getAssets(),"fonts/Novecentowide-DemiBold 2.ttf");*/
	
		

		listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


			@SuppressWarnings("deprecation")
			@Override
		      public void onItemClick(AdapterView<?> parent, final View view,
		          int position, long id) {
				
				int oldposition = 0;
				for(int countl = 0;countl<list.size();countl++)
				{
					if(list.get(position)== position_array.get(countl))
					{
						oldposition = countl;
						break;
					}
				}
		    	int x = listedx.get(oldposition);
	            int y = listedy.get(oldposition);
	      		blockDrawableBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),
	    				listeddrawable.get(oldposition));
	       		Drawable d = new BitmapDrawable(getResources(),combineImages(mapImageBitmap,blockDrawableBitmap,x,y));
        		ImageView mapImageView = (ImageView)findViewById(R.id.mapImageView);
				mapImageView.setBackgroundDrawable(d);
	            /*ImageView imgx = (ImageView)findViewById(R.id.cube);
	            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
	            lp.setMargins(listx.get(position), listy.get(position), 0,0);
	            imgx.setLayoutParams(lp);*/
        			    for(int a = 0; a < parent.getChildCount(); a++)
        	            {
        	                parent.getChildAt(a).setBackgroundColor(Color.TRANSPARENT);
        	            }
        			    Log.d(" position clicked ",x + " x " + y + " y ");
        			    listView1.setItemChecked(position, true);
		      }
		});
	}

	private void iterateXAxis(float width)
	{
		int initx = (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(0)).getWidth() * 3.1);
		//Log.d(" Initx width" + initx, " Init y " + (int) (.0822 * height));
		int offset;
		if(width > 768)
			offset = 8;
		else if(width > 480 && width <= 768)
			offset = 5;
		else
			offset = 4;


		for(int ax = 0;ax<9;ax++)
		{
			listx.add(initx);
			initx+= BitmapFactory.decodeResource(getApplicationContext().getResources(),
						listdrawable.get(0)).getWidth() + offset;

		}
//		initx -= .0018518 * width;
//		listx.add(initx);
		// next row //
		initx = (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(0)).getWidth() * 3.1) - (offset + 4);
		for(int bx = 0;bx<2;bx++)
		{
			listx.add(initx);
		}
		initx += (int) ((BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth()+ offset) * 2) ;
		for(int cx = 0;cx<3;cx++)
		{
			listx.add(initx);
		}
		initx += (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth() ;
		for(int dx = 0;dx<3;dx++)
		{
			listx.add(initx);
		}

		initx += (int) ((BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth() + offset) * 2) ;
		listx.add(initx);
		initx += (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth() + ( offset * 2);
		for(int ex = 0;ex<2;ex++)
		{
			listx.add(initx);
		}
		initx += (int) ((BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth()) * 2) ;
		for(int fx = 0;fx<2;fx++)
		{
			listx.add(initx);
		}
		initx += (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth();
		listx.add(initx);

		//third row//

		initx = (int) ((BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(0)).getWidth() * 3.1) - (offset + 4) +  (int) ((BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth()+ (offset + 1)) * 3));

		for(int gx=0;gx<2;gx++)
		{
			listx.add(initx);
			initx += (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listx.size()-1)).getWidth();

		}
		initx -= (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth() * 2 ;
		for(int hx=0;hx<2;hx++)
		{
			listx.add(initx);
			initx+= (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listx.size()-1)).getWidth();
		}
		initx-=  (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth()  * 2 ;
		for(int ix=0;ix<2;ix++)
		{
			listx.add(initx);
			initx+= (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listx.size()-1)).getWidth();
		}
		initx += (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth();
		listx.add(initx);

		// fourth row //
		initx = (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(0)).getWidth() * 3.1) - (offset + 4);
		for(int jx = 0;jx<3;jx++)
		{
			listx.add(initx);
		}


		initx += (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth() + offset)* 2;
		for(int kx = 0;kx<3;kx++)
		{
			listx.add(initx);
		}
		initx += (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth();
		listx.add(initx);
		initx += (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth() + offset + 2) * 2;
		for(int lx = 0;lx<2;lx++)
		{
			listx.add(initx);
		}
		initx+= (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth();
		listx.add(initx);
		initx += (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listx.size()-1)).getWidth() ) * 2 - offset;
		listx.add(initx);
		// fifth row
		initx = (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(0)).getWidth() * 3.1) - (offset + 4);
		for(int mx = 0;mx<5;mx++)
		{
			listx.add(initx);
			initx+= (int) BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listx.size()-1)).getWidth() - (offset * 2);
		}
	}

	private void iterateYAxis(float height)
	{
		//int inity = 49;
		int inity = (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(0)).getHeight() * 1.666666);

		for(int ay=0;ay<9;ay++)
		{
			listy.add(inity);
		}

		int offset = 6;
		if(height < 900)
			offset = 3;
		// next row //
		//inity = (int) (.173986486 * height);
		int nextRowValue = (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(9)).getHeight() + BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(0)).getHeight()) + inity + (offset * 2);
		inity = nextRowValue;



		for(int yy = 0; yy< 2;yy++) {
			listy.add(inity);
			inity+= BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listy.size()-1)).getHeight();
		}


		inity = nextRowValue;

		for(int by = 0;by<3;by++)
		{
			listy.add(inity);
			inity+= (int)BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listy.size()-1)).getHeight();
		}
		inity = nextRowValue;

		for(int cy = 0;cy<3;cy++)
		{
			listy.add(inity);
			inity+= (int)BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listy.size()-1)).getHeight();
		}
		inity = nextRowValue;

		listy.add(inity);
		for(int dy = 0;dy<2;dy++)
		{
			listy.add(inity);
			inity+= (int)BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listy.size()-1)).getHeight();
		}
		inity = nextRowValue;

		for(int ey = 0;ey<2;ey++)
		{
			listy.add(inity);
			inity+= (int)BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listy.size()-1)).getHeight();
		}
		inity = nextRowValue;
		listy.add(inity);


		//third row//
		int thirdRowValue = (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(23)).getHeight() + BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(41)).getHeight() )  + inity - offset ;

		inity =  thirdRowValue;
		for(int gy = 0;gy<2;gy++)
		{
			listy.add(inity);
		}
		inity+= (int)BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listy.size()-1)).getHeight();
		for(int hy = 0;hy<2;hy++)
		{
			listy.add(inity);
		}
		inity+= (int)BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listy.size()-1)).getHeight();
		for(int iy = 0;iy<2;iy++)
		{
			listy.add(inity);
		}
		inity =  thirdRowValue;
		listy.add(inity);

		// fourth row //

		int fourthRowValue = (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(29)).getHeight() + BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(9)).getHeight() )  + inity + offset;
		Log.d( "size ng cube",  BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(0)).getHeight() + " height ng cube no width " + " inity " + inity  + " fourthrow " + fourthRowValue );
		inity = fourthRowValue;
		for(int jy = 0;jy<3;jy++)
		{
			listy.add(inity);
			inity+= (int)BitmapFactory.decodeResource(getApplicationContext().getResources(),
					listdrawable.get(listy.size()-1)).getHeight();
		}
		inity = fourthRowValue;


		for(int ky = 0;ky<4;ky++)
		{
			listy.add(inity);
			if(ky<2)
				inity+= (int)BitmapFactory.decodeResource(getApplicationContext().getResources(),
						listdrawable.get(listy.size()-1)).getHeight();
		}
		inity = fourthRowValue;
		listy.add(inity);
		inity+= (int)BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(listy.size()-1)).getHeight();
		listy.add(inity);
		inity = fourthRowValue;
		listy.add(inity);
		inity = fourthRowValue;
		listy.add(inity);

		// fifth row //

		int fifthRowValue = (int) (BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(40)).getHeight() + BitmapFactory.decodeResource(getApplicationContext().getResources(),
				listdrawable.get(9)).getHeight() )  + inity;
		inity = fifthRowValue;
		for(int my = 0;my<5;my++)
		{
			listy.add(inity);
		}
	}

	private void iterateDrawables()
	{
		for(int ad = 0;ad<8;ad++)
		{
			listdrawable.add(R.drawable.ncube2);
		}
		listdrawable.add(R.drawable.lcube);
		// next row //

		listdrawable.add(R.drawable.scube);

		listdrawable.add(R.drawable.icubes);


		for(int cd = 0;cd<3;cd++)
		{
			listdrawable.add(R.drawable.scube);
		}
		for(int dd = 0;dd<3;dd++)
		{
			listdrawable.add(R.drawable.scube);
		}
		listdrawable.add(R.drawable.icube);
		for(int ed = 0;ed<2;ed++)
		{
			listdrawable.add(R.drawable.ncube2);
		}
		for(int fd = 0;fd<2;fd++)
		{
			listdrawable.add(R.drawable.ncube2);
		}
		listdrawable.add(R.drawable.icube2);

		// third row //

		for(int gd = 0;gd<2;gd++)
		{
			listdrawable.add(R.drawable.icube2);
		}
		for(int hd = 0;hd<4;hd++)
		{
			listdrawable.add(R.drawable.ncube2);
		}
		listdrawable.add(R.drawable.hcube);


		// fourth row //
		listdrawable.add(R.drawable.scube);

		listdrawable.add(R.drawable.scube);

		listdrawable.add(R.drawable.scube);

		listdrawable.add(R.drawable.icubeh);

		listdrawable.add(R.drawable.icubeh);



		listdrawable.add(R.drawable.scube);
		listdrawable.add(R.drawable.scube);

		listdrawable.add(R.drawable.scube);
		/*for(int kd = 0;kd<5;kd++)
		{
			if(kd==0)
			listdrawable.add(R.drawable.icubeh);
			else
			listdrawable.add(R.drawable.scube);
		}*/


		listdrawable.add(R.drawable.icubes);
		listdrawable.add(R.drawable.icube2);
		listdrawable.add(R.drawable.hmcube);

		for(int md = 0;md<5;md++)
		{
			listdrawable.add(R.drawable.icube2h);
		}
	}

	public Bitmap combineImages(Bitmap c, Bitmap s, int x,int y) { // can add a 3rd parameter 'String loc' if you want to save the new image - left some code to do that at the bottom 
	    Bitmap cs = null;
	    int width, height = 0;
	    if(c.getWidth() > s.getWidth()) { 
	      width = c.getWidth();
	    } else { 
	      width = s.getWidth();
	    }
	    cs = Bitmap.createBitmap(width, c.getHeight(), Bitmap.Config.ARGB_8888);
	    Canvas comboImage = new Canvas(cs);
	    comboImage.drawBitmap(c, 0f, 0f, null); 
	    comboImage.drawBitmap(s, x, y, null);
	    // this is an extra bit I added, just incase you want to save the new image somewhere and then return the location
	    /*String tmpImg = String.valueOf(System.currentTimeMillis()) + ".png";

	    OutputStream os = null;
	    try {
	      os = new FileOutputStream(loc + tmpImg);
	      cs.compress(CompressFormat.PNG, 100, os);
	    } catch(IOException e) {
	      Log.e("combineImages", "problem combining images", e);
	    }*/

	    return cs; 
	  } 

	
	
	 private class StableArrayAdapter extends ArrayAdapter<String> {

		    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		    public StableArrayAdapter(Context context, int textViewResourceId,
		        List<String> objects) {
		      super(context, textViewResourceId, objects);
		      for (int i = 0; i < objects.size(); ++i) {
		        mIdMap.put(objects.get(i), i);
		      }
		    }

		    @Override
		    public long getItemId(int position) {
		      String item = getItem(position);
		      return mIdMap.get(item);
		    }

		    @Override
		    public boolean hasStableIds() {
		      return true;
		    }

		  }
	 

}
