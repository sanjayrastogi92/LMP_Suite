package seleniumQues;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class DropDownQues {

	@Test
	public void getDropDropValues() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sanjay.rastogi\\eclipse-workspace\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='select-demo']")));
		
		List<WebElement> ls = select.getOptions();
		
		for(WebElement ddValues:ls) {
			System.out.println(ddValues.getText());
		}
		
		driver.quit();
	}
}
