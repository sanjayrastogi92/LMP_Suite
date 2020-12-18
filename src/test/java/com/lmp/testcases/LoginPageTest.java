package com.lmp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lmp.base.BaseClass;
import com.lmp.pages.DashboardPage;
import com.lmp.pages.LoginPage;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginpage;
	DashboardPage dashboardpage;

	public LoginPageTest() {
		super();
	}
	
	
	@BeforeClass
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Movr");
		
	}
	
	
	@Test(priority = 2)
	public void userLoginTest() {
		dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority = 3)
	public void vleLoginIconTest() {
		boolean flag = loginpage.validateLoginIcon();
		Assert.assertTrue(flag);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
