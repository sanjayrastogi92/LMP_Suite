package com.lmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lmp.base.BaseClass;

public class LoginPage extends BaseClass{
	
	//Page Factory-OR;
	@FindBy(name="userCode")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement loginBtn;
	
	@FindBy(linkText = "VLE")
	WebElement vleIcon;
	
	
	//Initializing the page Objects by creating constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions on Login Page
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public DashboardPage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new DashboardPage();
	}
	
	public boolean validateLoginIcon() {
		return vleIcon.isDisplayed();
	}
	
	

}
