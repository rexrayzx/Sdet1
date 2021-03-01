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
public class CreatNewLeadbByfillAllTheFieldsAndSave extends BaseClass{
	@Test
	public void creatNewLeadbByfillAllTheFieldsAndSaveTest() throws Throwable{
		HomePage home = new HomePage(driver);
		//to create new lead
		home.getLeadsLink().click();
		LeadsPage leads=new LeadsPage(driver);
		leads.getCreateNewLeadLink();
		CreateLeadPage create=new CreateLeadPage(driver);
		create.createLead();
		//to validate
		/*CreateLeadInfo leadinfo=new CreateLeadInfo(driver);
		String actSusccessMsg=leadinfo.getSuccessfulMsg().getText();
		Assert.assertTrue(actSusccessMsg.contains(lastname));*/
		
	}
}
