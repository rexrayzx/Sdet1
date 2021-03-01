package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicCalenderWindow {
	WebDriver driver;
	@Test
	public void calenderwindowpop() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights");
		
		Actions act= new Actions(driver);
		act.moveByOffset(10, 10);
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE'")).click();
		int count=0;
		while(count<11) {
			try {
				String x="div[@aria-lable='sat DEC 25 2021']/div/p[text()='25']";
				driver.findElement(By.xpath(x)).click();
				System.out.println("Given date is valid");
				break;
			}catch (Exception e) {
				// TODO: handle exception
				driver.findElement(By.xpath(null)).click();
				count++;
			}
			
		}
	}
}
