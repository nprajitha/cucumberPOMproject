package com.saleforce.pages.forgotpswdpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesfroce.base.Salesforcepage;

public class Forgotpassword extends Salesforcepage{
        WebDriver driver;
	public Forgotpassword(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='un']")WebElement fusername;
	@FindBy(id="continue")WebElement continuebutton;
   
	public void resetpswdusername(String name)
	{
		textvalues(fusername,name,"enter the user name");
	}
	public void clickcontinuebutton()
	{
		clickele(continuebutton,"click on continue");
	}

}
