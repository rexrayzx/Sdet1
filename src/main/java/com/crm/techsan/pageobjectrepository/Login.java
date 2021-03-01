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
public class Login extends PageUtilities{
	WebDriver driver;
	@FindBy(name="user_name")
	private WebElement userNameTextbox;
	
	@FindBy(name="user_password")
	private WebElement passwordTextbox;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTextbox() {
		return userNameTextbox;
	}

	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	/**
	 * to login into application 
	 * @param username
	 * @param password
	 * @return
	 */
	public HomePage loginToVtiger(String username, String password){
		userNameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		loginbtn.click();
		return new HomePage(driver);
	}
	/**
	 * To login in to application using fixed username and password
	 * @return
	 */
	public void loginToVtiger() {
		userNameTextbox.sendKeys("admin");
		passwordTextbox.sendKeys("admin");
		loginbtn.click();
	}
}
