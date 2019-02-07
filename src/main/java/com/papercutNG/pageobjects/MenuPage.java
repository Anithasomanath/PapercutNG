package com.papercutNG.pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.papercutNG.genericlib.BaseTest;
import com.papercutNG.genericlib.ConfigReader;

public class MenuPage extends BaseTest {

	public static ConfigReader config =new ConfigReader();
	
	
	//User profile 
	@FindBy(how=How.XPATH, using="//ul[@class='tabList']/li/div/a")
	private List<WebElement> menuLinks;
	
	public List<WebElement> getTotalMenuLinks()
	{
		return (List<WebElement>) menuLinks;
	}
	
	
	public void printLinks(String url) throws FileNotFoundException, IOException
	{
		test.log(Status.PASS,"URL is:"+url);
	}
	
	
	 public void verifyLink(String urlLink) {
	   
					 		//Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
					        try {
							 //Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
							 URL link = new URL(urlLink);
							
							 // Create a connection using URL object (i.e., link)
							 HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
							
							 //Set the timeout for 2 seconds
							 httpConn.setConnectTimeout(2000);
							 //connect using connect method
							 httpConn.connect();
							
							 //use getResponseCode() to get the response code. 
							 if(httpConn.getResponseCode()== 200) { 
							 
								 test.log(Status.PASS,urlLink+" --> IS WORKING FINE");
								 test.log(Status.PASS,urlLink+" --> STATUS CODE IS :: "+httpConn.getResponseMessage());
								 
								 }
							 if(httpConn.getResponseCode()== 404) {
								 test.log(Status.PASS,urlLink+" --> IS NOT WORKING");
								 test.log(Status.PASS,urlLink+" --> STATUS CODE IS :: "+httpConn.getResponseMessage());
							 }
					       }
					 //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
					 catch (Exception e) {
					 //e.printStackTrace();
					 }
	 } 
}
