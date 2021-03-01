package Scripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.techsan.generics.ExcelUtilities;
import com.crm.techsan.generics.FileUtility;
import com.crm.techsan.generics.JavaUtil;
import com.crm.techsan.generics.PageUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForthVtiger {
	WebDriver driver;
	PageUtilities pageutils=new PageUtilities();
	FileUtility file=new FileUtility();
	JavaUtil j=new JavaUtil();
	ExcelUtilities excel=new ExcelUtilities();
	String sheetName="OrgName";
	@Test(dataProvider = "getData")
	public void createOrg(String name, String number,String web) throws Throwable {
		String browser=file.getPropertyData("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to(file.getPropertyData("url"));
		pageutils.implicitwait(driver);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitbutton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//a/img[@title='Create Organization...']")).click();
		
		
		int num = j.randomvalue();
		String orgname=name+num;
		driver.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@id='phone']")).sendKeys(number+num);
		driver.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@name='website']")).sendKeys(web+num);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Thread.sleep(5000);
		
		pageutils.switchtochildWindow(driver);
		
		driver.findElement(By.id("search_txt")).sendKeys("hp");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("(//table[@class='small'])[3]//a[@id='1']")).click();
		pageutils.alertpopupAccept(driver);
		
		pageutils.switchtoparentwindow(driver);
		
		pageutils.select(driver.findElement(By.xpath("//select[@name='industry']")), "Banking");
		
		pageutils.select(driver.findElement(By.xpath("//select[@name='rating']")), "Market Failed");
		
		pageutils.select(driver.findElement(By.xpath("//select[@name='accounttype']")), "Customer");
		
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		
		pageutils.selectbyvisibletext(driver.findElement(By.xpath("//select[@id='bas_searchfield']")), "Organization Name");
		driver.findElement(By.name("submit")).click();
		WebElement org=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
		if(org.isDisplayed()) {
			System.out.println("Displayed");
		}else {
			System.out.println("Not Displayed");
		}
		Thread.sleep(3000);
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		
		int rowIndex = excel.getRowCount(sheetName);
		rowIndex++;
		Object[][]objArr=new Object[rowIndex][3];
		for(int i=0; i<rowIndex;i++) {
			objArr[i][0]=excel.getExcelData(sheetName,i, 0);
			objArr[i][1]=excel.getExcelData(sheetName,i, 1);
			objArr[i][2]=excel.getExcelData(sheetName,i, 2);
		}
		return objArr;
	}
}