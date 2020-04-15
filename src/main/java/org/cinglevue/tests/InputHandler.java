package org.cinglevue.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InputHandler {
	 Properties prop;
	public   String getProperty(String propertyName) {
		prop  = new Properties();
	 try(InputStream input = new FileInputStream(System.getProperty("user.dir")+"/config.properties")) {   
		 	prop.load(input);
     } catch (IOException ex) {
         ex.printStackTrace();
     }
	 return prop.getProperty(propertyName);
	}
}
