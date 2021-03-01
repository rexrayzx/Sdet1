package com.crm.techsan.pageobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.techsan.generics.PageUtilities;
/**
 * 
 * @author Rajiv
 *
 */
public class HomePage extends PageUtilities{
	WebDriver driver;
	@FindBy(xpath="//table[@class='hdrTabBg']//a[text()='Leads']")
	private WebElement leadsLink;
	
	@FindBy(xpath="//td[@class='genHeaderSmall']/following-sibling::td")
	private WebElement userImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadsLink() throws Throwable {
		waitAndClick(leadsLink);
		return leadsLink;
	}
	/**
	 * to singout from application
	 * @throws Throwable 
	 */
	public void signout() throws Throwable {
		waitAndClick(userImage);
		movetoelement(driver, userImage);
		signOutLink.click();
	}
}
