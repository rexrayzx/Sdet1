package com.crm.techsan.leads;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.server.HomeBaseWarning;
import org.testng.annotations.Test;

import com.crm.techsan.generics.BaseClass;
import com.crm.techsan.generics.FileUtility;
import com.crm.techsan.generics.PageUtilities;
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
	@Test
	public void navigateToLeadPageTest() throws Throwable {
		//to Navigate To Lead Page
		HomePage home=new HomePage(driver);
		home.getLeadsLink();
		LeadsPage leads=new LeadsPage(driver);
		utils.waitAndClick(leads.getCreateNewLeadLink());
		leads.getCreateNewLeadLink();
	}
}
