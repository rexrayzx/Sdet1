package Scripts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.techsan.generics.ExcelUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {
	String sheetName="bookTicketTest";
	String filePath="./Data/testData.xlsx";
	WebDriver driver;
	int count=0;
	@Test(dataProvider = "getData")
	public void makeMyTrip(String src, String dst) throws Throwable {
		ExcelUtilities excel=new ExcelUtilities();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions act= new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		Thread.sleep(3000);
		//WebDriverWait wai=new WebDriverWait(driver, 30);
		//wai.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='From']")));
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(src);
		driver.findElement(By.xpath("//div[text()='"+src+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(dst);
		driver.findElement(By.xpath("//div[text()='"+dst+"']")).click();
		
		act.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		List<WebElement> number = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		int size=number.size();
		String write=String.valueOf(size);
		excel.setExcelData(sheetName, count, 2, write);
		count++;
		
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtilities excel=new ExcelUtilities();
		int rowIndex = excel.getRowCount(sheetName);
		rowIndex++;
		Object[][]objArr=new Object[rowIndex][2];
		for(int i=0; i<rowIndex;i++) {
			objArr[i][0]=excel.getExcelData(sheetName,i, 0);
			objArr[i][1]=excel.getExcelData(sheetName,i, 1);
		}
		return objArr;
	}
	
}
