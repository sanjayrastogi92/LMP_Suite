package com.lmp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lmp.base.BaseClass;

public class DashboardPage extends BaseClass{
	
	@FindBy(xpath="//span[@class='light-logo']//img")
	WebElement movrLogo;
	
	@FindBy(linkText = "Organization Management")
	WebElement orgMgmtLink;
	
	@FindBy(linkText = "View Organization")
	WebElement viewOrgLink;
	
	@FindBy(xpath="//div/app-view-organization/div/div/ul/li[1]/a/span[2]")
	WebElement addOrgLink;
	
	
	//Initializing the Page Objects
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyDashboardLogo() {
		return movrLogo.isDisplayed();
	}
	
	
	public OrgMgmtPage clickOnViewManagement() {
		orgMgmtLink.click();
		viewOrgLink.click();
		addOrgLink.click();
		
		return new OrgMgmtPage();
	}
	

}
