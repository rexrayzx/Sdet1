package Scripts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.techsan.generics.ExcelUtilities;
import com.crm.techsan.generics.JavaUtil;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RandomName {
	String sheetName="OrgName";
	WebDriver driver;
	@Test(dataProvider = "getData")
	public void createname(String name, String number,String web) throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitbutton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//a/img[@title='Create Organization...']")).click();
		JavaUtil j=new JavaUtil();
		int num = j.randomvalue();
		driver.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@name='accountname']")).sendKeys(name+num);
		driver.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@id='phone']")).sendKeys(number+num);
		driver.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@name='website']")).sendKeys(web+num);
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
		
		//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		WebElement orgna = driver.findElement(By.xpath("(//a[text()='Organizations'])"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(orgna));
		orgna.click();
		driver.findElement(By.name("search_text")).sendKeys(name);
		WebElement drop = driver.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]"));
		Select sel= new Select(drop);
		sel.selectByVisibleText("Organization Name");
		driver.findElement(By.name("submit")).click();
		
		String x="//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']";
		
		List<WebElement> list2 = driver.findElements(By.xpath(x));
		for(WebElement wb:list2) {
			String opp = wb.getText();
			if(opp.contains(name)) {
				System.out.println("organization found");
				break;
			}
		}
		WebElement notfound = driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
		System.out.println(notfound.getText());
		
		driver.close();
	}
	


@DataProvider
public Object[][] getData() throws Throwable{
	ExcelUtilities excel=new ExcelUtilities();
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