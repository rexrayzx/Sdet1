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
public class CreateLeadInfo extends PageUtilities{
	WebDriver driver;
	public CreateLeadInfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successfulMsg;
	
	@FindBy(linkText = "More Information")
	private WebElement moreinformationLink;
	
	public WebElement getSuccessfulMsg() {
		return successfulMsg;
	}

	public WebElement getMoreinformationLink() {
		return moreinformationLink;
	}

}
