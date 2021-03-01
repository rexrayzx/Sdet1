package com.crm.techsan.leads1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
		//to get data
		String popup="Last Name cannot be empty";
		String sheetName=file.getPropertyData("Leadssheetname");
		String firstName=excel.getExcelData(sheetName, 4, 0);
		String phoneNo=excel.getExcelData(sheetName, 4, 3);
		String mobileNo=excel.getExcelData(sheetName, 4, 4);
		String designation=excel.getExcelData(sheetName, 4, 5);
		String fax=excel.getExcelData(sheetName, 4, 6);
		String email=excel.getExcelData(sheetName, 4, 7);
		String annualRevenue=excel.getExcelData(sheetName, 4, 8);
		String website=excel.getExcelData(sheetName, 4, 9);
		String noOfEmployee=excel.getExcelData(sheetName, 4, 10);
		String secoundryemail=excel.getExcelData(sheetName, 4, 11);
		String street=excel.getExcelData(sheetName, 4, 12);
		String pobox=excel.getExcelData(sheetName, 4, 13);
		String postalCode=excel.getExcelData(sheetName, 4, 14);
		String countryName=excel.getExcelData(sheetName, 4, 15);
		String city=excel.getExcelData(sheetName, 4, 16);
		String state=excel.getExcelData(sheetName, 4, 17);
		String description=excel.getExcelData(sheetName, 4, 18);
		String salutation=excel.getExcelData(sheetName, 4, 19);
		String leadsource=excel.getExcelData(sheetName, 4, 20);
		String industry=excel.getExcelData(sheetName, 4, 21);
		String leadStatus=excel.getExcelData(sheetName, 4, 22);
		String rating=excel.getExcelData(sheetName, 4, 23);
		HomePage home = new HomePage(driver);
		home.getLeadsLink();
		//to create new lead
		LeadsPage leads=new LeadsPage(driver);
		leads.getCreateNewLeadLink();
		//to get the excel sheet name
		CreateLeadPage create=new CreateLeadPage(driver);
		//to enter all the valid data from excel except mandatory 
		utils.select(create.getSalutationDropDown(), salutation);
		create.getFirstNameTextBox().sendKeys(firstName);
		create.getPhoneNoTextBox().sendKeys(phoneNo);
		create.getMobileNoTextBox().sendKeys(mobileNo);
		create.getDesignationTextBox().sendKeys(designation);
		create.getFaxTextBox().sendKeys(fax);
		create.getEmailTextBox().sendKeys(email);
		create.select(create.getLeadSourceDropDown(), leadsource);
		create.select(create.getIndustryDropDown(), industry);
		create.getAnnualRevenueTextBox().clear();
		create.getAnnualRevenueTextBox().sendKeys(annualRevenue);
		create.getWebsiteTextBox().sendKeys(website);
		create.select(create.getLeadStatusDropDown(),leadStatus);
		create.getNoOfEmployeeTextBox().sendKeys(noOfEmployee);
		create.select(create.getRatingDropDown(), rating);
		create.getSecoundaryEmailTextBox().sendKeys(secoundryemail);

		create.getSteetTextArea().sendKeys(street);
		create.getPoBoxNoTextBox().sendKeys(pobox);
		create.getPostalCodeTextBox().sendKeys(postalCode);
		create.getCityTextBox().sendKeys(city);
		create.getCountryTextBox().sendKeys(countryName);
		create.getStateTextBox().sendKeys(state);
		create.getDescriptionTextArea().sendKeys(description);
		create.getSaveButton().click();
		//to validate
		String text = create.getTextofpopup(driver);
		Assert.assertTrue(text.contains(popup));
	}
}
