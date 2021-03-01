package com.crm.techsan.lead;

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
	@Test(groups = "Regression")
	public void creatNewLeadbykeepAllTheMandatoryFieldBlankAndSaveTest() throws Throwable {
		/* to get the data*/
		String popup="Last Name cannot be empty";
		String sheetName=file.getPropertyData("Leadssheetname");
		int randomNumber = jutil.randomvalue();
		String firstname=excel.getExcelData(sheetName, 4, 0)+"_"+randomNumber;
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
		//to navigate to leads page
		HomePage home = new HomePage(driver);
		home.getLeadsLink();
		//to create new lead
		LeadsPage leads=new LeadsPage(driver);
		leads.getCreateNewLeadLink();
		CreateLeadPage create=new CreateLeadPage(driver);
		//to enter all the valid data from excel except mandatory 
		create.createLead(salutation, firstname, phoneNo, mobileNo, designation, fax, email, leadsource, industry, annualRevenue, website, leadStatus, noOfEmployee, rating, secoundryemail, street, pobox, postalCode, city, countryName, state, description);
		//to Validate
		String text=utils.getTextofpopup(driver);
		Assert.assertTrue(text.contains(popup));
	}
}
