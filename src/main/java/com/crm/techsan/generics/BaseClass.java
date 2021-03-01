package com.crm.techsan.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.techsan.pageobjectrepository.HomePage;
import com.crm.techsan.pageobjectrepository.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Rajiv
 *
 */
public class BaseClass {
	/*Object creation*/
	public FileUtility file = new FileUtility();
	public ExcelUtilities excel=new ExcelUtilities();
	public JavaUtil jutil=new JavaUtil();
	public PageUtilities utils=new PageUtilities();
	public DataBaseUtilities dbLb = new DataBaseUtilities();
	public WebDriver driver;
	public static WebDriver staticDriver;
	@BeforeSuite(groups = {"Smoke","Regression"})
	//to connect to database
	public void configBeforeSuite() throws Throwable {
		dbLb.connectToDB();
	}

	@BeforeClass(groups = {"Smoke","Regression"})
	public void configBeforeClass() throws Throwable {
		/* launch the Browser*/
		/*read Common Data*/
		String URL = file.getPropertyData("url");

		String BROWSER = file.getPropertyData("browser");
		
		 if(BROWSER.equals("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		 }else {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
		 staticDriver=driver;
		//to wait for page to load
		 utils.implicitwait(driver);
		 //to maximize the window
		 utils.maximizeWindow(driver);
		 //to enter the url
		 driver.get(URL);
	}

	/*@Parameters("browser")
	@BeforeClass(groups = {"Smoke","Regression"})*/
	public void configBeforeClassParrallel(String browser) throws Throwable {
		/* launch the Browser*/
		/*read Common Data*/
		String URL = file.getPropertyData("url");
		
		 if(browser.equals("Firefox")) {
			 WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		 }else if(browser.equals("Chrome")){
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
		//to wait for page to load
		 utils.implicitwait(driver);
		 //to maximize the window
		 utils.maximizeWindow(driver);
		 //to enter the url
		 driver.get(URL);
	}
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void configBeforeMtd() throws Throwable {
		/* login to Application*/
		String USERNAME = file.getPropertyData("username");
		String PASSWORD = file.getPropertyData("password");
		Login login=new Login(driver);
		login.loginToVtiger(USERNAME, PASSWORD);
	}
	@AfterMethod(groups = {"Smoke","Regression"})
	public void configAfterMethod() throws Throwable {
		HomePage home=new HomePage(driver);
	      /*: logout */
		home.signout();
	}
	@AfterClass(groups = {"Smoke","Regression"})
	//to close the browser
	public void configAfterClass() {
		driver.close();
	}
	
	@AfterSuite(groups = {"Smoke","Regression"})
	//to close the connection to database
	public void configAfterSuite() throws Throwable {
		dbLb.closeDb();
		
	}

}		  