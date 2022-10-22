package com.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javax.naming.ConfigurationException;

import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;


import com.test.constants.SourcePath;

import freemarker.template.utility.Constants;

import com.test.constants.SourcePath;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.test.constants.SourcePath;
public class CommonUtilities{

public FileInputStream stream=null;

public  Properties loadfile(String filename) {

Properties propertyFile = new Properties();
String  PropertyFilePath=null;
switch(filename) {
case "getdataProperties":
PropertyFilePath =SourcePath.CONFIG_PROPERTIES_PATH;
break;

}

try {
stream=new FileInputStream(PropertyFilePath);
propertyFile.load(stream);
} catch (IOException e) {

e.printStackTrace();
}
return propertyFile;
}


public String getProperty(String Key,Properties propertyFile) {
String value = propertyFile.getProperty(Key);
System.out.println("Property we got from the file is::" + value);
try {
stream.close();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return value;
}



}





