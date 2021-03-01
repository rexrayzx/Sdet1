package com.crm.techsan.lead;

import org.testng.Assert;
import org.testng.annotations.Listeners;
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
@Listeners(com.crm.techsan.generics.ListnerImp.class)
public class CreatNewLeadBykeepAllTheFieldsBlankAndSave extends BaseClass {
	@Test(groups = "Regression")
	public void creatNewLeadBykeepAllTheFieldsBlankAndSaveTest() throws Throwable{
		/*to get the dta*/
		String popup="Last Name cannot be empty";
		HomePage home = new HomePage(driver);
		//to create new lead
		home.getLeadsLink().click();
		LeadsPage leads=new LeadsPage(driver);
		leads.getCreateNewLeadLink().click();;
		//to save the lead without entering any data
		CreateLeadPage create=new CreateLeadPage(driver);
		create.getSaveButton().click();
		//to validate
		String text = utils.getTextofpopup(driver);	
		Assert.assertTrue(text.contains(popup));
	}
}
