package com.lmp.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lmp.base.BaseClass;
import com.lmp.pages.DashboardPage;
import com.lmp.pages.LoginPage;
import com.lmp.pages.OrgMgmtPage;
import com.lmp.util.TestUtil;

public class OrgMgmtPageTest extends BaseClass{

	LoginPage loginpage;
	DashboardPage dashboardpage;
	OrgMgmtPage orgmgmtpage;
	TestUtil testUtil;
	
	String sheetName ="Organization_Details";
	String sheetName1 ="Asset_Details";
	
	public OrgMgmtPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		orgmgmtpage = new OrgMgmtPage();
		dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashboardpage.clickOnViewManagement();
	}
	
	@DataProvider
	public Object[][] getTestDataforAddingOrg() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1, dataProvider = "getTestDataforAddingOrg")
	public void verifyCreateNewOrg(String orgType, String nameOfOrg, String mobileNum, String addressOfOrg, String emailID, String typeOfOrg, String panNumber,
			String acctHolderName, String acctNumber, String bankName, String testRemarks) throws InterruptedException, IOException {
		
		orgmgmtpage.createNewOrg(orgType, nameOfOrg, mobileNum, addressOfOrg, emailID, typeOfOrg, panNumber, acctHolderName, acctNumber, bankName,testRemarks);
	}
	
	@DataProvider
	public Object[][] getTestDataforAddingAsset() {
		Object data[][] = TestUtil.getTestData(sheetName1);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getTestDataforAddingAsset")
	public void verifyAddNewAsset(String assetCategory,String assetType,String stateName,String districtName,String activity, String assetModelNum,String assetDescrip,String trackDeviceType,
			String trackDeviceID,String securityAmt,String rateCard,String rateCharges) throws InterruptedException, IOException {
		
		orgmgmtpage.addNewAsset(assetCategory, assetType,stateName,districtName,activity,assetModelNum,assetDescrip,trackDeviceType,trackDeviceID,securityAmt,
				rateCard,rateCharges);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
