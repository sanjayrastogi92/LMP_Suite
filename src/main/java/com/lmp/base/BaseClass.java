package com.lmp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.lmp.util.TestUtil;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\sanjay.rastogi\\eclipse-workspace\\LMPTest\\"
					+ "src\\main\\java\\com\\lmp\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sanjay.rastogi\\eclipse-workspace\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\sanjay.rastogi\\eclipse-workspace\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
		
		driver.get(prop.getProperty("url"));
		
		//testing for git-- just for learning purpose"
		System.out.println("Testing git");
	}
	
	
}
