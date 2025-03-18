package com.savaprix.ecom.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public static String filePath = "./env-config-data/selenium-env-data.properties";
	
	
	/**
	 * Return the values form the propery file stored in environmental property file
	 * @param key
	 * @return Value associated with the `key`
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) throws IOException {
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		p.load(fis);
		return p.getProperty(key);
	}
	
	
	/**
	 * Returns the property data from any property file
	 * @param path location of the property file
	 * @param key 
	 * @return value associated with the key
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String path, String key) throws IOException {
			
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream(path);
			p.load(fis);
			return p.getProperty(key);
		}
}


