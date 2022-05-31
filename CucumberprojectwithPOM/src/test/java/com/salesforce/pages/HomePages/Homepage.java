package com.salesforce.pages.HomePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesfroce.base.Salesforcepage;

public class Homepage  extends Salesforcepage{
	WebDriver driver;
	public Homepage(WebDriver driver) {
		super(driver);
		
	}
	public String page() {
	
		return gettitle();
		  
	 }
	 @FindBy(xpath="//div[@id='userNavButton']")WebElement usermenu;
	 @FindBy(linkText="Logout")WebElement logoutbutton;
	 
	 public void dropdownusermenu()
	 {
		 mouseon(usermenu,"mouse on userdropdown");
		 clickele(usermenu,"click on userdropdown");
	 }
	 public void logout()
	 {
		 clickele(logoutbutton,"click on logout");
	 }

}
