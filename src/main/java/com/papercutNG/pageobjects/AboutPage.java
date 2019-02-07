package com.papercutNG.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AboutPage {

	
		//About Tab
		@FindBy(how=How.XPATH ,using="//span[contains(text(),'About')]")
		private WebElement aboutTab;
		
		public WebElement getAboutTab()
		{
			return aboutTab;
		}
		
		
		//Build Number
		@FindBy(how=How.XPATH ,using="//p[contains(text(),'Version:')]")
		private WebElement buildNumber;
		
		public WebElement getBuildAndVersionNumberFromAboutPage()
		{
			return buildNumber;
		}
		
		
		
		
}
