package com.lmp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lmp.base.BaseClass;
import com.lmp.pages.DashboardPage;
import com.lmp.pages.LoginPage;
import com.lmp.pages.OrgMgmtPage;

public class DashboardPageTest extends BaseClass{
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	OrgMgmtPage orgmgmtpage;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyDashBoardLogoTest() {
		boolean dashboardLogo = dashboardpage.verifyDashboardLogo();
		Assert.assertTrue(dashboardLogo);
	}
	
	@Test
	public void clickOnViewManagementTest() {
		orgmgmtpage = dashboardpage.clickOnViewManagement();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
