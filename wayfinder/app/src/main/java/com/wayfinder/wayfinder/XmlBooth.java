package com.wayfinder.wayfinder;


import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;


/*
 * SAX parser to parse booth 
 */
public class XmlBooth extends DefaultHandler
{

	
	List<XmlValuesModel> list=null;
	
	// string builder acts as a buffer
	StringBuilder builder;

	XmlValuesModel boothsValues=null;
	
	/**
	 * Initialize the arraylist
	 * @throws SAXException
	 */
	@Override
	public void startDocument() throws SAXException {
		
		/******* Create ArrayList To Store XmlValuesModel object ******/
		list = new ArrayList<XmlValuesModel>();
	}

	/**
	 * Initialize the temp XmlValuesModel object which will hold the parsed info
	 * and the string builder that will store the read characters
	 * @param uri
	 * @param localName ( Parsed Node name will come in localName  )
	 * @param qName
	 * @param attributes
	 * @throws SAXException
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		/********  When New XML Node initiating to parse this function called *******/
		
		//Create StringBuilder object to store xml node value
		builder=new StringBuilder();
		
		if(localName.equals("boothlist")){
			
			//Log.i("parse","====login=====");
		}
		else if(localName.equals("booths")){
			
		}
		else if(localName.equals("booth")){
			
			//Log.i("parse","----booth start----");
			/********** Create Model Object  *********/
			boothsValues = new XmlValuesModel();
		}
	}
	
	
	/**
	 * Finished reading the login tag, add it to arraylist
	 * @param uri
	 * @param localName
	 * @param qName
	 * @throws SAXException
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		
		
		if(localName.equals("booth")){
			/************* finished reading a booth xml node, add it to the arraylist ********/
			list.add(boothsValues);
			
		}
		else  if(localName.equalsIgnoreCase("id")){  		
    		boothsValues.setid(Integer.parseInt(builder.toString()));
       	}
    	else if(localName.equalsIgnoreCase("company")){
    		boothsValues.setcompany(builder.toString());
    	}
    	else if(localName.equalsIgnoreCase("xaxis")){
    		boothsValues.setxaxis(Integer.parseInt(builder.toString()));
    	}
    	else if(localName.equalsIgnoreCase("yaxis")){
    		boothsValues.setyaxis(Integer.parseInt(builder.toString()));
    	}
       	else if(localName.equalsIgnoreCase("drawable")){
    		boothsValues.setdrawable(Integer.parseInt(builder.toString()));
    	}
    	
    	
    	
		//Log.i("parse",localName.toString()+"========="+builder.toString());
	}

	/**
	 * Read the value of each xml NODE
	 * @param ch
	 * @param start
	 * @param length
	 * @throws SAXException
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// read the characters and append them to the buffer
		String tempString=new String(ch, start, length);
		 builder.append(tempString);
	}
}