package com.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.saleforce.pages.forgotpswdpage.Forgotpassword;
import com.saleforce.pages.resetpage.Resetpage;
import com.salesforce.pages.HomePages.Homepage;
import com.salesfroce.pages.loginpages.Loginpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsSalesforcePom {
	WebDriver driver;
	Loginpage login;
	Homepage home;
	Forgotpassword fp;
	Resetpage rp;
	@Before
	public void startup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Given("navigate to {string}")
	public void navigate_to(String url) {
	    driver.get(url);
	}
	
	
	@When("user on {string}")
	public void user_on(String page) {
		if(page.equalsIgnoreCase("loginpage"))
			 login = new Loginpage(driver);
		else if(page.equalsIgnoreCase("homepage"))
			home= new Homepage(driver);
		else if(page.equalsIgnoreCase("forgotpassword"))
			fp=new Forgotpassword(driver);
		else if(page.equalsIgnoreCase("resetpage"))
			rp=new Resetpage(driver);
	   
	}

	@When("user enter username as {string}")
	public void user_enter_username_as(String id) {
		login.enteremail(id);
		System.out.println("username entered");
	   
	}
	@When("user enter password as {string}")
	public void user_enter_password_as(String pdata) {
	    login.password(pdata);
	   System.out.println("password entered");
	}



	@When("user enter password should  be empty")
	public void user_enter_password_should_be_empty() {
		login.clearpasswordbx();
		System.out.println("password cleared");
	    
	}

	@When("click on login  button")
	public void click_on_login_button() {
		login.clickbutton();
		System.out.println("click on login");
	    
	}
	@When("user enter  resetusername  as {string}")
	public void user_enter_resetusername_as(String resetuser) {
		fp.resetpswdusername(resetuser);
		System.out.println("reset username entered");
	}

	@Then("verify error message text {string}")
	public void verify_error_message_text(String expectedresult) {
		 String actual=login.pswderrmsg();
		 Assert.assertEquals(actual, expectedresult);
	    
	}

	

	@Then("I verify page title as {string}")
	public void i_verify_page_title_as(String  result) {
		String actaulresult=home.page();
		Assert.assertEquals(actaulresult,result);
	    
	}

	@When("user click on check box")
	public void user_click_on_check_box() {
		login.checkbox();
		System.out.println("checkbox is clicked");
	}

	@When("user click on dropdown")
	public void user_click_on_dropdown() {
		home.dropdownusermenu();
		System.out.println("mouse on and click on userdropdown ");
	   
	}

	@When("user click logout link")
	public void user_click_logout_link() {
		home.logout();
		System.out.println("Click on logout link");
	   
	}

	@Then("verify displayname {string}")
	public void verify_displayname(String expecteddname) {
		String actual=login.displayname();
		Assert.assertEquals(actual,expecteddname );
	}

	@When("user click on forgot password link")
	public void user_click_on_forgot_password_link() {
		login.clickforgetpswd();
		System.out.println("Click on forgot password link");
	  
	}

	@When("click on  continue button")
	public void click_on_continue_button() {
		fp.clickcontinuebutton();
		System.out.println("Click on  continue button");
	   
	}

	@Then("verify  resetpage header text is {string}")
	public void verify_resetpage_header_text_is(String exceptedmsgfp) {
		 String actualmessage=rp.checkingmsg();
		 Assert.assertEquals(actualmessage, exceptedmsgfp);
	}

	@Then("message with the text {string}")
	public void message_with_the_text(String exceptedmsg) {
		 String actualmsg=login.invaliderrormsg();
		 Assert.assertEquals(actualmsg,exceptedmsg);
	   
	}
	@After
	public void finaldown()
	{
		driver.quit();
	}


}
