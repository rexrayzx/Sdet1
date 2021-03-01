package com.crm.techsan.lead;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.techsan.generics.BaseClass;
import com.crm.techsan.generics.FileUtility;
import com.crm.techsan.generics.PageUtilities;
import com.crm.techsan.pageobjectrepository.CreateLeadPage;
import com.crm.techsan.pageobjectrepository.HomePage;
import com.crm.techsan.pageobjectrepository.LeadsPage;
import com.crm.techsan.pageobjectrepository.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Rajiv
 *
 */
public class NavigateToLeadPage extends BaseClass{
	@Test(groups = "Smoke")
	public void navigateToLeadPageTest() throws Throwable {
		/* To get The data*/
		String pageTitle="Creating New Lead";
		//to Navigate To Lead Page
		HomePage home = new HomePage(driver);
		home.getLeadsLink();
		LeadsPage leads=new LeadsPage(driver);
		leads.getCreateNewLeadLink();
		/*to validate*/
		CreateLeadPage create=new CreateLeadPage(driver);
		String title = create.getPageTitle().getText();
		Assert.assertTrue(title.contains(pageTitle));
	}
}
