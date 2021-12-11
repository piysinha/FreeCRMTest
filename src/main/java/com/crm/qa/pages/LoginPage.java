package com.crm.qa.pages;

import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//Page factory - OR(Object Repository):
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@class ='btn btn-small']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img [@class ='img-responsive' and @height ='31']")
	WebElement crmLogo;

	private HomePage HomePage;
	
	
	// initializing the Page Objects:
	public LoginPage() {	
		PageFactory.initElements(driver, this);	
	}
	
	
	// Actions 
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un , String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}


	
}
