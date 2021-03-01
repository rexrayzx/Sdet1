package com.crm.techsan.generics;



import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


/**
 * 
 * @author Rajiv
 *
 */
public class PageUtilities {
	public WebDriver driver;
	/**
	 * to wait implicitly
	 */
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(AutoConstant.implicitlywaitwait, TimeUnit.SECONDS);
	}
	/**
	 * to wait till element is clickable
	 * @param element
	 */
	public void clickabilityOfElement(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, AutoConstant.explicitlywaitwait);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * to wait till element is visible
	 * @param element
	 */
	public void visibilityOfElement(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, AutoConstant.explicitlywaitwait);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * to select from drop down by visible Text
	 * @param element
	 * @param text
	 */
	public void selectbyvisibletext(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * to select from drop dowm by value
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	/**
	 * to select from drop down by index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * to click using javascript Excecutor
	 * @param driver
	 * @param element
	 */
	public void javescripclick(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * to switch to child window
	 * @param driver
	 * @param sessionid
	 */
	public void switchtochildWindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> winpop = windows.iterator();
		String parentid = winpop.next();
		String childid = winpop.next();
		driver.switchTo().window(childid);
	}
	/**
	 * to switch to parent window
	 * @param driver
	 */
	public void switchtoparentwindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> winpop = windows.iterator();
		String parentid = winpop.next();
		driver.switchTo().window(parentid);
	}
	/**
	 * to switch frame by name
	 * @param driver
	 * @param nameorid
	 */
	public void switchFrame(WebDriver driver,String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	/**
	 * to switch to frame by index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * To switch back to parent frame
	 * @param driver
	 */
	
	public void switchtodefaultcontain(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * to accept alert popup
	 * @param driver
	 */
	public void alertpopupAccept(WebDriver driver) {
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	/**
	 * to cancel alert popup
	 * @param driver
	 */
	public void dismissalertPopup(WebDriver driver) {
		Alert a=driver.switchTo().alert();
		a.dismiss();
	}
	/**
	 * to move to desired element
	 * @param driver
	 * @param element
	 */
	public void movetoelement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * to handle scroll bar
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBar(WebDriver driver, int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * to scroll till element is visible
	 * @param driver
	 * @param element
	 */
	public void scrollBar(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	/**
	 * to click at a point on a page w.r.t x and y points
	 * @param driver
	 * @param xoffset
	 * @param yoffset
	 */
	public void move(WebDriver driver,int xoffset,int yoffset) {
		Actions a=new Actions(driver);
		a.moveByOffset(xoffset, yoffset).perform();;
	}
	/**
	 * to double click on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();;
	}
	/**
	 * to click on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseclick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.click(element).perform();;
	}
	/**
	 * to right click on a webelement
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();;
	}
	/**
	 * to drag and drop an element w.r.t other element
	 * @param driver
	 * @param element
	 * @param element2
	 */
	public void dargAndDrop(WebDriver driver,WebElement element,WebElement element2) {
		Actions a=new Actions(driver);
		a.dragAndDrop(element, element2).perform();;
	}
	/**
	 * to drag an drop an element w.r.t x and y points
	 * @param driver
	 * @param element
	 * @param xoffset
	 * @param yoffset
	 */
	public void dargAndDrop(WebDriver driver,WebElement element,int xoffset,int yoffset) {
		Actions a=new Actions(driver);
		a.dragAndDropBy(element, xoffset, yoffset).perform();;
	}
	/**
	 * to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * to get text from alert popup
	 * @param driver
	 * @return 
	 * @return text from alert popup
	 */
	public String getTextofpopup(WebDriver driver) {
		Alert a=driver.switchTo().alert();
		String popupText = a.getText();
		a.accept();
		return popupText;
	}
	/**
	 * used to wait & click for expected element in GUI
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick( WebElement element) throws Throwable {
		  int count = 0;
	        while(count < 40) {
			   try {
				   element.click();
			     break;
			   }catch (Throwable e) {
				Thread.sleep(500);
				count++;
			   }
	        }
	}
	
	/**
	 * Used to take screenshot
	 * @param driver
	 * @param methodName
	 * @throws IOException
	 */
	public void takeScreenShot(String methodName) throws IOException {
		EventFiringWebDriver event=new EventFiringWebDriver(BaseClass.staticDriver);
		File src=event.getScreenshotAs(OutputType.FILE);
		File dest=new File(AutoConstant.screenshotpath+methodName+".PNG");
		Files.copy(src, dest);
	}
}
