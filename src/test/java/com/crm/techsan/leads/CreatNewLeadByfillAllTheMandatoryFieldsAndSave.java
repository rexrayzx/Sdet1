package com.crm.techsan.leads;


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
public class CreatNewLeadByfillAllTheMandatoryFieldsAndSave extends BaseClass {
	
	@Test
	public void creatNewLeadByfillAllTheMandatoryFieldsAndSaveTest() throws Throwable {
		/* get the data*/
		String sheetName=file.getPropertyData("Leadssheetname");
		int randomNumber = jutil.randomvalue();
		String lastname=excel.getExcelData(sheetName, 5, 1)+"_"+randomNumber;
		String compantname=excel.getExcelData(sheetName, 5, 2)+"_"+randomNumber;
		//to create new lead with only mandatory data
		HomePage home = new HomePage(driver);
		home.getLeadsLink().click();
		LeadsPage leads=new LeadsPage(driver);
		leads.getCreateNewLeadLink().click();;
		CreateLeadPage create=new CreateLeadPage(driver);
		create.createLead(lastname, compantname);
		//to validate
		CreateLeadInfo leadinfo=new CreateLeadInfo(driver);
		String actSusccessMsg=leadinfo.getSuccessfulMsg().getText();
		Assert.assertTrue(actSusccessMsg.contains(lastname));
	}
}
