package Scripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompareList {
	WebDriver driver;
	@Test
	public void compare() throws InterruptedException {
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
		
		ArrayList<String> alist1=new ArrayList<String>();
		for(WebElement wb:list) {
			String name = wb.getText();
			alist1.add(name);
		}
		Collections.sort(alist1);
		  String z="//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@class='listFormHeaderLinks']"; 
		  driver.findElement(By.xpath(z)).click();
		  
		  Thread.sleep(2000);
		  List<WebElement> list1 = driver.findElements(By.xpath(x)); 
		  ArrayList<String> alist2=new ArrayList<String>(); 
		  for(WebElement wb:list1) { 
			  String name =wb.getText(); 
			  alist2.add(name); 
			  }
		  Assert.assertEquals(alist2, alist1);
		  
		  driver.close();
	}
}
