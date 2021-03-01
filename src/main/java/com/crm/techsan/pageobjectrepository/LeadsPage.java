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
public class LeadsPage extends PageUtilities {
	public WebDriver driver;
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createNewLeadLink;
	
	public LeadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewLeadLink() throws Throwable {
		waitAndClick(createNewLeadLink);
		return createNewLeadLink;
	}
	
}
