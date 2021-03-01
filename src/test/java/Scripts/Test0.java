package Scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.techsan.generics.FileUtility;
import com.crm.techsan.generics.PageUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Test0 {
	FileUtility file=new FileUtility();
	PageUtilities utils=new PageUtilities();
	WebDriver driver;
	@Test
	public void test1() throws Throwable{
		//to open the browser
		String browser = file.getPropertyData("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		//to maximize the window
		utils.maximizeWindow(driver);
		//to enter the url
		driver.navigate().to(file.getPropertyData("url"));
		//to login into application
		driver.findElement(By.name("user_name")).sendKeys(file.getPropertyData("username"));
		driver.findElement(By.name("user_password")).sendKeys(file.getPropertyData("password"));
		driver.findElement(By.id("submitButton")).click();
		//to sign Out
		utils.movetoelement(driver, driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td")));
		driver.findElement(By.linkText("Sign Out")).click();
		//to close the browser
		Thread.sleep(3000);
		driver.quit();
	
	}
	
	

	}
