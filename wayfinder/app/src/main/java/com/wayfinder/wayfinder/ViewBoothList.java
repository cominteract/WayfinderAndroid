package com.wayfinder.wayfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;




import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewBoothList extends Activity {
	StableArrayAdapter adapter = null;
	Button push;
	List<XmlValuesModel> myData = null;
	BoothClass[] fav = new BoothClass[2];
	private ListView listView1;
	final ArrayList<String> list = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_booth_list);
		listView1 = (ListView) findViewById(R.id.listView1);
		push = (Button) findViewById(R.id.push);

		ImageView img = (ImageView) findViewById(R.id.img);

		File sdcard = Environment.getExternalStorageDirectory();
		
		//Get the text file
		File file = new File(sdcard,"/xml/boothxml.txt");

		//Read text from file
		StringBuilder text = new StringBuilder();
		String fulltext = "";
		if(file.exists())      
			Toast.makeText(getApplicationContext(), "there ", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(getApplicationContext(), file.toString(), Toast.LENGTH_LONG).show();	
		try {
		

		    BufferedReader br = new BufferedReader(new FileReader(file));
		    String line;

		    while ((line = br.readLine()) != null) {
		        text.append(line);
		        text.append('\n');
		        fulltext += line;
		    }
		}
		catch (IOException e) {
		    //You'll need to add proper error handling here
		}

		
		//Static XML data 
		final String XMLData = fulltext;

		
		String dataToBeParsed = "Click on button to parse XML.\n\n XML DATA : \n\n"+XMLData;

				try{
					
					BufferedReader br=new BufferedReader(new StringReader(XMLData));
					InputSource is=new InputSource(br);
					
					//Create XML Parser
					XmlBooth parser=new XmlBooth();
					
					SAXParserFactory factory=SAXParserFactory.newInstance();
			   		SAXParser sp=factory.newSAXParser();
			   		XMLReader reader=sp.getXMLReader();
			   		reader.setContentHandler(parser);
			   		reader.parse(is);
			   		
			   		myData=parser.list;
			   		
			   		if(myData!=null){
			   			
			   			String OutputData = "";
			   			
			    	    for (XmlValuesModel xmlRowData : myData) {
						  if(xmlRowData!=null)
						  {  
							  
							  
							int     id 			= xmlRowData.getid();
				    	    String  company 	= xmlRowData.getcompany();
					        int  xaxis		= xmlRowData.getxaxis();
					        int  yaxis		= xmlRowData.getyaxis();
					        int  drawable		= xmlRowData.getdrawable();
	
					        
					    	list.add(company);
					        OutputData += "Booth Node : \n\n "+ company +" | "
					                                       + xaxis +" \n\n ";
					    	
						  }
						  else
							  Log.e("Booth", "Booths value null");
					    }			    	
			   		}
			   	
				}
			   	catch(Exception e){Log.e("Booth", "Exception parse xml :"+e);}
		
		

		adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
		listView1.setAdapter(adapter);
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
	    public int getColour( int x, int y)
	    {
	        ImageView img = (ImageView) findViewById(R.id.img);
	        img.setDrawingCacheEnabled(true); 
	        Bitmap hotspots=Bitmap.createBitmap(img.getDrawingCache()); 
	        img.setDrawingCacheEnabled(false);
	        return hotspots.getPixel(x, y);
	    }
	  }

}
