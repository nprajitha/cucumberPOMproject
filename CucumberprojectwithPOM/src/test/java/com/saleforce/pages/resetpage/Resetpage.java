package com.saleforce.pages.resetpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesfroce.base.Salesforcepage;

public class Resetpage extends Salesforcepage{
	 WebDriver driver;
	public Resetpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="header")WebElement checkemail;
	public String checkingmsg()
	{
		String emailmsg= gettext(checkemail,"to get text");
		return emailmsg;
		
	}

}
