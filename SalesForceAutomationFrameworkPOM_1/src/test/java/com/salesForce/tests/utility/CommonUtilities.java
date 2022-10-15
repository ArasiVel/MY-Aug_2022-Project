package com.salesForce.tests.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;




public class CommonUtilities {
	
	public FileInputStream stream=null;
	
	public Properties loadFile(String filename) {
		
		Properties propertyFile = new Properties();
		String PropertyFilePath=null;
		switch(filename) {
		case "applicationProperties":
			PropertyFilePath=Constants.APPLICATION_PROPERTIES_PATH;
				break;
		case "applicationData":
			PropertyFilePath=Constants.APPLICATION_DATA_PATH;
			break;
			
			
		case "generateReport":
			PropertyFilePath=Constants.GENERATE_REPORT_PATH;
			break;
		}
				
		
		try {
			stream = new FileInputStream(PropertyFilePath);
			propertyFile.load(stream);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return propertyFile;
			}	
	public String getApplicationProperty(String key,Properties propertyFile) {
		String value = propertyFile.getProperty(key);
		System.out.println("property we got from the file is::"+value);
		try {
			stream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		
	return value;
}	
	public HashMap getAllPropertiesAsSet(Properties propertyFile) {
		return new HashMap(propertyFile);
					
				
				
		
		
	}
	
}
	
