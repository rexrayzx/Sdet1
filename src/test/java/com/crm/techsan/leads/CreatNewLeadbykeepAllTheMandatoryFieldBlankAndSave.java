package com.crm.techsan.leads;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.techsan.generics.BaseClass;
import com.crm.techsan.generics.ExcelUtilities;
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
public class CreatNewLeadbykeepAllTheMandatoryFieldBlankAndSave extends BaseClass {
	@Test
	public void creatNewLeadbykeepAllTheMandatoryFieldBlankAndSaveTest() throws Throwable {
		String sheetName=file.getPropertyData("Leadssheetname");
		
		HomePage home = new HomePage(driver);
		home.getLeadsLink();
		//to create new lead
		LeadsPage leads=new LeadsPage(driver);
		leads.getCreateNewLeadLink();
		//to get the excel sheet name
		CreateLeadPage create=new CreateLeadPage(driver);
		//to enter all the valid data from excel except mandatory 
		utils.select(create.getSalutationDropDown(), "Prof");
		create.getFirstNameTextBox().sendKeys(excel.getExcelData(sheetName, 4, 0));
		create.getPhoneNoTextBox().sendKeys(excel.getExcelData(sheetName, 4, 3));
		create.getMobileNoTextBox().sendKeys(excel.getExcelData(sheetName, 4, 4));
		create.getDesignationTextBox().sendKeys(excel.getExcelData(sheetName, 4, 5));
		create.getFaxTextBox().sendKeys(excel.getExcelData(sheetName, 4, 6));
		create.getEmailTextBox().sendKeys(excel.getExcelData(sheetName, 4, 7));
		create.select(create.getLeadSourceDropDown(), "Public Relations");
		create.select(create.getIndustryDropDown(), "Communications");
		create.getAnnualRevenueTextBox().clear();
		create.getAnnualRevenueTextBox().sendKeys(excel.getExcelData(sheetName, 4, 8));
		create.getWebsiteTextBox().sendKeys(excel.getExcelData(sheetName, 4, 9));
		create.select(create.getLeadStatusDropDown(),"Hot");
		create.getNoOfEmployeeTextBox().sendKeys(excel.getExcelData(sheetName, 4, 10));
		create.select(create.getRatingDropDown(), "Active");
		create.getSecoundaryEmailTextBox().sendKeys(excel.getExcelData(sheetName, 4, 11));
		
		create.getSteetTextArea().sendKeys(excel.getExcelData(sheetName, 4, 12));
		create.getPoBoxNoTextBox().sendKeys(excel.getExcelData(sheetName, 4, 13));
		create.getPostalCodeTextBox().sendKeys(excel.getExcelData(sheetName, 4, 14));
		create.getCityTextBox().sendKeys(excel.getExcelData(sheetName, 4, 15));
		create.getCountryTextBox().sendKeys(excel.getExcelData(sheetName, 4, 16));
		create.getStateTextBox().sendKeys(excel.getExcelData(sheetName, 4, 17));
		create.getDescriptionTextArea().sendKeys(excel.getExcelData(sheetName, 4, 18));
		//to save the lead
		create.getSaveButton().click();
	}
}
