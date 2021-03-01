package com.crm.techsan.lead;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.techsan.generics.BaseClass;
import com.crm.techsan.pageobjectrepository.CreateLeadInfo;
import com.crm.techsan.pageobjectrepository.CreateLeadPage;
import com.crm.techsan.pageobjectrepository.HomePage;
import com.crm.techsan.pageobjectrepository.LeadsPage;

/**
 * 
 * @author Rajiv
 *
 */
public class CreatNewLeadbByfillAllTheFieldsAndSave extends BaseClass{
	@Test(groups = {"Regression","Smoke"})
	public void creatNewLeadbByfillAllTheFieldsAndSaveTest() throws Throwable{
		/*to get the data*/
		String sheetName=file.getPropertyData("Leadssheetname");
		int randomNumber = jutil.randomvalue();
		String firstname=excel.getExcelData(sheetName, 2, 0)+"_"+randomNumber;
		String lastname=excel.getExcelData(sheetName, 2, 1)+"_"+randomNumber;
		String companyName=excel.getExcelData(sheetName, 2, 2)+"_"+randomNumber;
		String phoneNo=excel.getExcelData(sheetName, 2, 3);
		String mobileNo=excel.getExcelData(sheetName, 2, 4);
		String designation=excel.getExcelData(sheetName, 2, 5);
		String fax=excel.getExcelData(sheetName, 2, 6);
		String email=excel.getExcelData(sheetName, 2, 7);
		String annualRevenue=excel.getExcelData(sheetName, 2, 8);
		String website=excel.getExcelData(sheetName, 2, 9);
		String noOfEmployee=excel.getExcelData(sheetName, 2, 10);
		String secoundryemail=excel.getExcelData(sheetName, 2, 11);
		String street=excel.getExcelData(sheetName, 2, 12);
		String pobox=excel.getExcelData(sheetName, 2, 13);
		String postalCode=excel.getExcelData(sheetName, 2, 14);
		String countryName=excel.getExcelData(sheetName, 2, 15);
		String city=excel.getExcelData(sheetName, 2, 16);
		String state=excel.getExcelData(sheetName, 2, 17);
		String description=excel.getExcelData(sheetName, 2, 18);
		String salutation=excel.getExcelData(sheetName, 2, 19);
		String leadsource=excel.getExcelData(sheetName, 2, 20);
		String industry=excel.getExcelData(sheetName, 2, 21);
		String leadStatus=excel.getExcelData(sheetName, 2, 22);
		String rating=excel.getExcelData(sheetName, 2, 23);

		HomePage home = new HomePage(driver);
		//to create new lead
		home.getLeadsLink().click();
		LeadsPage leads=new LeadsPage(driver);
		leads.getCreateNewLeadLink();
		CreateLeadPage create=new CreateLeadPage(driver);
		create.createLead(salutation, firstname, lastname, companyName, phoneNo, mobileNo, designation, fax, email, leadsource, industry, annualRevenue, website, leadStatus, noOfEmployee, rating, secoundryemail, street, pobox, postalCode, city, countryName, state, description);
		//to validate
		CreateLeadInfo leadinfo=new CreateLeadInfo(driver);
		String successmsg = leadinfo.getSuccessfulMsg().getText();
		Assert.assertTrue(successmsg.contains(lastname));
	}
}
