package Scripts;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CurrentDateCalenderpopup {
	WebDriver driver;
	@Test
	public void currentdate() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights");
		
		Actions act= new Actions(driver);
		act.moveByOffset(10, 10);
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE'")).click();
		
		Date dateObj=new Date();
		String strDate=dateObj.toString();
		String[] arr=strDate.split(" ");
		String day=arr[0];
		String month=arr[1];
		String date=arr[2];
		String year=arr[5];
		
		String x= "div[@aria-lable='"+day+" "+month+" "+date+" "+year+"']/div/p[text()='"+date+"']";
		driver.findElement(By.xpath(x)).click();
	}
}
