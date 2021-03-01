package Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerAssignment {
	WebDriver driver;
	@Test
	public void checkOrg() {
		String org="oppo";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitbutton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		String x="//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']";
		
		List<WebElement> list = driver.findElements(By.xpath(x));
		
		for(WebElement wb: list) {
			  String name = wb.getText(); 
			  if(name.equals(org)) {
				  wb.click(); break; 
				  }
			 
		}
	driver.findElement(By.name("Delete")).click();
	Alert a=driver.switchTo().alert();
	a.accept();
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.name("search_text")).sendKeys(org);
	WebElement drop = driver.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]"));
	Select sel= new Select(drop);
	sel.selectByVisibleText("Organization Name");
	driver.findElement(By.name("submit")).click();
	
	List<WebElement> list2 = driver.findElements(By.xpath(x));
	for(WebElement wb:list2) {
		String opp = wb.getText();
		if(opp.equals(org)) {
			System.out.println("organization found");
			break;
		}
	}
	WebElement notfound = driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
	System.out.println(notfound.getText());
	
	driver.close();
	}
}
