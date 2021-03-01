package com.crm.techsan.leads;

import org.testng.annotations.Test;

import com.crm.techsan.generics.BaseClass;
import com.crm.techsan.pageobjectrepository.CreateLeadPage;
import com.crm.techsan.pageobjectrepository.HomePage;
import com.crm.techsan.pageobjectrepository.LeadsPage;

/**
 * 
 * @author Rajiv
 *
 */
public class CreatNewLeadBykeepAllTheFieldsBlankAndSave extends BaseClass {
	@Test
	public void creatNewLeadBykeepAllTheFieldsBlankAndSaveTest() throws Throwable{
		HomePage home = new HomePage(driver);
		//to create new lead
		home.getLeadsLink().click();
		LeadsPage leads=new LeadsPage(driver);
		leads.getCreateNewLeadLink().click();;
		//to save the lead without entering any data
		CreateLeadPage create=new CreateLeadPage(driver);
		create.getSaveButton().click();
		//to get the test from warning popup and accept the popup
		utils.getTextofpopup(driver);	
	}
}
