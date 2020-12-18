package com.lmp.pages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lmp.base.BaseClass;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class OrgMgmtPage extends BaseClass {

	@FindBy(xpath = "//div/app-view-organization/div/div/ul/li[1]/a/span[2]")
	WebElement addOrgIcon;

	@FindBy(xpath = "//p-dropdown//div//label[@class='ng-tns-c9-4 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement orgTypeDropDownIcon;

	@FindBy(id = "orgName")
	WebElement organizationName;

	@FindBy(id = "contactNo")
	WebElement contactNumber;

	@FindBy(xpath = "//textarea[@name='address']")
	WebElement address;

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailAddress;

	@FindBy(xpath="//p-dropdown//div//label[@class='ng-tns-c9-5 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement gstDropDownbtn;
	
	@FindBy(xpath="//p-dropdownitem//span[contains(text(),'12 %')]")
	WebElement gstPercentage;
	
	@FindBy(xpath = "//p-dropdown//div//label[@class='ng-tns-c9-18 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement typeDropDownIcon;

	@FindBy(id = "panNo")
	WebElement pancardNum;

	@FindBy(xpath = "//p-fileupload//input")
	WebElement fileUploadPath;

	@FindBy(id = "payeeName")
	WebElement accHolderName;

	@FindBy(id = "accNo")
	WebElement accNumber;

	@FindBy(xpath = "//p-autocomplete//span//input")
	WebElement bankName;

	@FindBy(xpath = "//tr[1]//td[8]//span[1]//p-tableradiobutton[1]//div[1]//div[2]//span[1]")
	WebElement ifscCodeBtn;

	@FindBy(xpath = "//p-footer//button[@type='button']")
	WebElement ifscSubmitBtn;

	@FindBy(xpath = "//textarea[@name='remarks']")
	WebElement testingRemarks;

	@FindBy(xpath = "//label[contains(text(),'ALL STATES')]")
	WebElement serviceAreaField;

	@FindBy(xpath = "//button[@name='addBtn']")
	WebElement serviceAreaSubmitBtn;

	
	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable'][contains(text(),'Add')]")
	WebElement addAssetBtn;

	@FindBy(xpath = "//p-dropdown//label[@class='ng-tns-c9-8 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement assetCategoryBtn;

	@FindBy(xpath = "//p-dropdown//label[@class='ng-tns-c9-9 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement assetTypeBtn;
	
	@FindBy(xpath ="//p-dropdown//label[@class='ng-tns-c9-10 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement choseStateBtn;
	
	@FindBy(xpath ="//p-dropdown//label[@class='ng-tns-c9-11 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement choseDistrictBtn;
	
	@FindBy(xpath="//p-dropdown//label[@class='ng-tns-c9-27 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement activityBtn;
	
	@FindBy(xpath = "//input[@id='assetName']")
	WebElement assetModelField;

	@FindBy(xpath = "//input[@id='assetDesc']")
	WebElement assetDescField;

	@FindBy(xpath = "//p-dropdown//label[@class='ng-tns-c9-26 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement trackingDeviceTypeBtn;

	@FindBy(id = "deviceId")
	WebElement trackingDeviceID;
	
	@FindBy(id = "securityAmt")
	WebElement securityAmtField;
	
	@FindBy(xpath = "//p-dropdown//label[@class='ng-tns-c9-28 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement rateCardTypeBtn;

	@FindBy(name = "rateCardCharges")
	WebElement rateCardChargesField;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement finalSubmitBtn;

	// Initlializing the Page Objects
	public OrgMgmtPage() {
		PageFactory.initElements(driver, this);

	}

	public void createNewOrg(String orgTypeValue, String orgName, String phoneNumber, String orgAddress,
			String email, String typeDropDownValue, String pancard, String payeeName, String accountNumber,
			String nameOfBank, String remarks) throws InterruptedException, IOException {

		addOrgIcon.click();
		orgTypeDropDownIcon.click();

		driver.findElement(By.xpath("//p-dropdown//span[contains(text(),'" + orgTypeValue + "')]")).click();
		organizationName.sendKeys(orgName);
		contactNumber.sendKeys(phoneNumber);
		address.sendKeys(orgAddress);
		emailAddress.sendKeys(email);
		
		gstDropDownbtn.click();
		gstPercentage.click();	
		
		typeDropDownIcon.click();
		driver.findElement(By.xpath("//p-dropdown//span[contains(text(),'" + typeDropDownValue + "')]")).click();
		pancardNum.sendKeys(pancard);
		fileUploadPath.sendKeys("C:\\Users\\sanjay.rastogi\\eclipse-workspace\\Files\\pancard.jpg");
		accHolderName.sendKeys(payeeName);
		accNumber.sendKeys(accountNumber);
		
		//Taking screenshot for user's details:
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\target\\Screenshot\\userDetails.png");
		FileUtils.copyFile(scrFile,destFile);
		
		bankName.sendKeys(nameOfBank);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p-autocomplete//li//span[@class='ng-tns-c14-19 ng-star-inserted']")).click();

		// Handling new windows opened for selecting the Bank IFSC
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {
			subWindowHandler = itr.next();
		}
		// switching to child window
		driver.switchTo().window(subWindowHandler);
		Thread.sleep(1000);
		ifscCodeBtn.click();
		ifscSubmitBtn.click();

		// Switching back to parent window
		testingRemarks.sendKeys(remarks);
		serviceAreaField.click();
		serviceAreaSubmitBtn.click();

		// Scrolling down to fill the asset details
		Thread.sleep(3000);
		WebElement wb = driver
				.findElement(By.xpath("//span[@class='ui-button-text ui-clickable'][contains(text(),'Add')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", wb);
		Thread.sleep(2000);

		}

	public void addNewAsset(String assetCategory, String assetType,String state,String district,String activity, String assetModel, String assetDesc,
			String trackingDevice, String deviceID,String securityAmt,String rateCard,String rateCardCharges) throws InterruptedException, IOException {

		addAssetBtn.click();

		// Handling new windows opened for adding Asset
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {
			subWindowHandler = itr.next();
		}
		// switching to child window
		driver.switchTo().window(subWindowHandler);
		assetCategoryBtn.click();
		if (assetCategory.equals("Agricultural Equipments")) {
			driver.findElement(By.xpath("//p-dropdownitem//span[contains(text(),'" + assetCategory + "')]")).click();
			assetTypeBtn.click();
			driver.findElement(By.xpath("//span[contains(text(),'" + assetType + "')]")).click();
			choseStateBtn.click();
			driver.findElement(By.xpath("//span[contains(text(),'"+state+"')]")).click();
			choseDistrictBtn.click();
			driver.findElement(By.xpath("//span[contains(text(),'"+district+"')]")).click();
			activityBtn.click();
			driver.findElement(By.xpath("//span[contains(text(),'"+activity+"')]")).click();
			assetModelField.sendKeys(assetModel);
			assetDescField.sendKeys(assetDesc);
			trackingDeviceTypeBtn.click();
			driver.findElement(By.xpath("//span[contains(text(),'" + trackingDevice + "')]")).click();
			trackingDeviceID.sendKeys(deviceID);
			securityAmtField.sendKeys(securityAmt);
			rateCardTypeBtn.click();
			driver.findElement(By.xpath("//span[contains(text(),'"+rateCard+"')]")).click();
			rateCardChargesField.sendKeys(rateCardCharges);
			
			//Taking screenshot for assets
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(".\\target\\Screenshot\\assetDetails.png");
			FileUtils.copyFile(scrFile,destFile);
		
		} else {
			System.out.println("Unhandled scenario for Asset Type: Vehicle");
		}

		//Clicking the submit button for adding the asset
		WebElement addAssetSubmitBtn = driver.findElement(By.xpath("//div[@class='pull-right']//button[@class='btn btn-primary btn-sm mr-2'][contains(text(),'Submit')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", addAssetSubmitBtn);
		
		// Switching back to parent window
		driver.switchTo().window(parentWindowHandler);
		Thread.sleep(2000);
		
		//Taking ScreenShot using aShot
		//Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		//ImageIO.write(fpScreenshot.getImage(),"PNG",new File(".\\target\\Screenshot\\fpassetDetails.png"));
		finalSubmitBtn.click();
		
	}
}
