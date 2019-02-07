package com.papercutNG.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

	private static String fileName=System.getProperty("user.dir")+"\\config\\config.properties";
	private static Properties prop=new Properties();
	
	
	
	//Get Browser Name
	public String getBrowser() throws FileNotFoundException, IOException
	{
		prop.load(new FileInputStream(fileName));
		String url=prop.getProperty("BROWSER");
		return url;
	}
	
	//Get Base URL of the application
	public String getURL() throws FileNotFoundException, IOException
	{
		prop.load(new FileInputStream(fileName));
		String url=prop.getProperty("BASEURL");
		return url;
	}

	public String getUsername() throws FileNotFoundException, IOException
	{
		prop.load(new FileInputStream(fileName));
		String uName=prop.getProperty("UNAME");
		return uName;
	}
	
	public String getPassword() throws FileNotFoundException, IOException
	{
		prop.load(new FileInputStream(fileName));
		String password=prop.getProperty("PWD");
		return password;
	}

}
