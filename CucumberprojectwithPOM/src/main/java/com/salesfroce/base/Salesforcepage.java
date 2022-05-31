package com.salesfroce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Salesforcepage 
{
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	public Salesforcepage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	//clearing element
		public static void clearbox(WebElement element,String objectname)
		{ if(element .isDisplayed())
		{
			element.clear();
			System.out.println("element  cleared");
		}
		else {
			System.out.println("element not cleared");
		}
		}
		//sending textvalues
		public static void textvalues(WebElement element,String text, String objectname)
		{
			if(element.isDisplayed())
			{
				//clearbox(element,objectname);
			element.sendKeys(text);
			
			System.out.println("text entered in textbox");
			}
			else
			{
				System.out.println("element not displayed");
			}
		}
		//click on webelement
		public static void clickele(WebElement element,String objectname)
		{
			if(element.isDisplayed())
			{
			element.click();
			System.out.println("element is clicked");
			}
			else
			{
				System.out.println("element not clicked");
			}
		}
		//mouseover on webelements
		public static void mouseon(WebElement element, String objectname)
		{
			waituntillvisible(element,objectname);
			Actions action=new Actions(driver);
			action.moveToElement(element).build().perform();
			
			
		}
		public static String gettext(WebElement element,String objectname)
		{
			waituntillvisible(element, objectname);
			String text=element.getText();
			return text;
			
			
		}
		
		public static void waituntillvisible(WebElement element,String objname)
		{
			 wait = new WebDriverWait(driver, 40); 
		    wait.until(ExpectedConditions.visibilityOf(element) );	  
		}
		
		
		public static String gettitle()
		{
			  
			return driver.getTitle();
			 
		}

}
