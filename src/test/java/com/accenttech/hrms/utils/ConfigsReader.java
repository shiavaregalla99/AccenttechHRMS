package com.accenttech.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	/*
	 * this method will read the properties file 
	 * and here we are passing the
	 * parameter file path
	 */
	public static Properties prop;
	public static void readProperties(String filePath) {
		try {
			FileInputStream fis= new FileInputStream(filePath);
		     prop=new Properties();
		     prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * this method will return the value of 
	 * the specifed key
	 * @param String key
	 * 
	 * @return String value
	 */
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
		
	}
	
}
