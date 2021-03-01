package com.crm.techsan.pageobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.techsan.generics.ExcelUtilities;
import com.crm.techsan.generics.FileUtility;
import com.crm.techsan.generics.JavaUtil;
import com.crm.techsan.generics.PageUtilities;
/**
 * 
 * @author Rajiv
 *
 */
public class CreateLeadPage extends PageUtilities{
	private ExcelUtilities excel;
	private FileUtility file;
	JavaUtil javautil;
	
	@FindBy(name="salutationtype")
	private WebElement salutationDropDown;
	
	@FindBy(name="firstname")
	private WebElement firstNameTextBox;
	
	@FindBy(name="lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(name="company")
	private WebElement compnayNameTextBox;
	
	@FindBy(id="phone")
	private WebElement phoneNoTextBox;
	
	@FindBy(id="mobile")
	private WebElement mobileNoTextBox;
	
	@FindBy(id="designation")
	private WebElement designationTextBox;
	
	@FindBy(id="fax")
	private WebElement faxTextBox;
	
	@FindBy(id="email")
	private WebElement emailTextBox;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="annualrevenue")
	private WebElement annualRevenueTextBox;
	
	@FindBy(name="website")
	private WebElement websiteTextBox;
	
	@FindBy(name="leadstatus")
	private WebElement leadStatusDropDown;
	
	@FindBy(id="noofemployees")
	private WebElement noOfEmployeeTextBox;
	
	@FindBy(name="rating")
	private WebElement ratingDropDown;
	
	@FindBy(id="secondaryemail")
	private WebElement secoundaryEmailTextBox;
	
	@FindBy(name="lane")
	private WebElement SteetTextArea;
	
	@FindBy(id="pobox")
	private WebElement poBoxNoTextBox;
	
	@FindBy(id="code")
	private WebElement postalCodeTextBox;
	
	@FindBy(id="city")
	private WebElement cityTextBox;
	
	@FindBy(id="country")
	private WebElement countryTextBox;
	
	@FindBy(id="state")
	private WebElement stateTextBox;

	@FindBy(name="description")
	private WebElement descriptionTextArea;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageTitle;
	
	public CreateLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSalutationDropDown() {
		return salutationDropDown;
	}

	public WebElement getFirstNameTextBox() {
		return firstNameTextBox;
	}

	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}

	public WebElement getCompnayNameTextBox() {
		return compnayNameTextBox;
	}

	public WebElement getPhoneNoTextBox() {
		return phoneNoTextBox;
	}

	public WebElement getMobileNoTextBox() {
		return mobileNoTextBox;
	}

	public WebElement getDesignationTextBox() {
		return designationTextBox;
	}

	public WebElement getFaxTextBox() {
		return faxTextBox;
	}

	public WebElement getEmailTextBox() {
		return emailTextBox;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getAnnualRevenueTextBox() {
		return annualRevenueTextBox;
	}

	public WebElement getWebsiteTextBox() {
		return websiteTextBox;
	}

	public WebElement getLeadStatusDropDown() {
		return leadStatusDropDown;
	}

	public WebElement getNoOfEmployeeTextBox() {
		return noOfEmployeeTextBox;
	}

	public WebElement getRatingDropDown() {
		return ratingDropDown;
	}

	public WebElement getSecoundaryEmailTextBox() {
		return secoundaryEmailTextBox;
	}

	public WebElement getSteetTextArea() {
		return SteetTextArea;
	}

	public WebElement getPoBoxNoTextBox() {
		return poBoxNoTextBox;
	}

	public WebElement getPostalCodeTextBox() {
		return postalCodeTextBox;
	}

	public WebElement getCityTextBox() {
		return cityTextBox;
	}

	public WebElement getCountryTextBox() {
		return countryTextBox;
	}

	public WebElement getStateTextBox() {
		return stateTextBox;
	}

	public WebElement getDescriptionTextArea() {
		return descriptionTextArea;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	public WebElement getPageTitle() {
		return pageTitle;
	}

	/**
	 * to create lead with all the feilds
	 * @throws Throwable
	 */
	
	public void createLead() throws Throwable {
		excel=new ExcelUtilities();
		file=new FileUtility();
		javautil=new JavaUtil();
		String sheetName=file.getPropertyData("Leadssheetname");
		int randomNumber = javautil.randomvalue();
		String firstname=excel.getExcelData(sheetName, 2, 0)+"_"+randomNumber;
		String lastname=excel.getExcelData(sheetName, 2, 1)+"_"+randomNumber;
		select(salutationDropDown, "Mr.");
		firstNameTextBox.sendKeys(firstname);
		lastNameTextBox.sendKeys(lastname);
		compnayNameTextBox.sendKeys(excel.getExcelData(sheetName, 2, 2));
		phoneNoTextBox.sendKeys(excel.getExcelData(sheetName, 2, 3));
		mobileNoTextBox.sendKeys(excel.getExcelData(sheetName, 2, 4));
		designationTextBox.sendKeys(excel.getExcelData(sheetName, 2, 5));
		faxTextBox.sendKeys(excel.getExcelData(sheetName, 2, 6));
		emailTextBox.sendKeys(excel.getExcelData(sheetName, 2, 7));
		select(leadSourceDropDown, "Cold Call");
		select(industryDropDown, "Banking");
		annualRevenueTextBox.clear();
		annualRevenueTextBox.sendKeys(excel.getExcelData(sheetName, 2, 8));
		websiteTextBox.sendKeys(excel.getExcelData(sheetName, 2, 9));
		select(leadStatusDropDown, "Cold");
		noOfEmployeeTextBox.sendKeys(excel.getExcelData(sheetName, 2, 10));
		select(ratingDropDown, "Acquired");
		secoundaryEmailTextBox.sendKeys(excel.getExcelData(sheetName, 2, 11));
		SteetTextArea.sendKeys(excel.getExcelData(sheetName, 2, 12));
		poBoxNoTextBox.sendKeys(excel.getExcelData(sheetName, 2, 13));
		postalCodeTextBox.sendKeys(excel.getExcelData(sheetName, 2, 14));
		cityTextBox.sendKeys(excel.getExcelData(sheetName, 2, 16));
		countryTextBox.sendKeys(excel.getExcelData(sheetName, 2, 15));
		stateTextBox.sendKeys(excel.getExcelData(sheetName, 2, 17));
		descriptionTextArea.sendKeys(excel.getExcelData(sheetName, 2, 18));
		saveButton.click();
	}
	/**
	 * to create lead with only mandatory data
	 * @param lastname
	 * @param companyName
	 * @throws Throwable
	 */
	public void createLead(String lastname,String companyName) throws Throwable {
		lastNameTextBox.sendKeys(lastname);
		compnayNameTextBox.sendKeys(companyName);
		saveButton.click();
	}
	/**
	 * to create lead with filling all the data
	 * @param salutation
	 * @param firstname
	 * @param lastname
	 * @param companyName
	 * @param phoneNo
	 * @param mobileNo
	 * @param designation
	 * @param fax
	 * @param email
	 * @param leadsource
	 * @param industry
	 * @param annualRevenue
	 * @param website
	 * @param leadStatus
	 * @param noOfEmployee
	 * @param rating
	 * @param secoundryemail
	 * @param street
	 * @param pobox
	 * @param postalCode
	 * @param city
	 * @param countryName
	 * @param state
	 * @param description
	 */
	public void createLead(String salutation,String firstname, String lastname,String companyName,String phoneNo,String mobileNo,String designation,String fax,String email,String leadsource,String industry,String annualRevenue,String website,String leadStatus,String noOfEmployee,String rating,String secoundryemail,String street,String pobox,String postalCode,String city,String countryName,String state,String description) {
		select(salutationDropDown, salutation);
		firstNameTextBox.sendKeys(firstname);
		lastNameTextBox.sendKeys(lastname);
		compnayNameTextBox.sendKeys(companyName);
		phoneNoTextBox.sendKeys(phoneNo);
		mobileNoTextBox.sendKeys(mobileNo);
		designationTextBox.sendKeys(designation);
		faxTextBox.sendKeys(fax);
		emailTextBox.sendKeys(email);
		select(leadSourceDropDown, leadsource);
		select(industryDropDown, industry);
		annualRevenueTextBox.clear();
		annualRevenueTextBox.sendKeys(annualRevenue);
		websiteTextBox.sendKeys(website);
		select(leadStatusDropDown, leadStatus);
		noOfEmployeeTextBox.sendKeys(noOfEmployee);
		select(ratingDropDown, rating);
		secoundaryEmailTextBox.sendKeys(secoundryemail);
		SteetTextArea.sendKeys(street);
		poBoxNoTextBox.sendKeys(pobox);
		postalCodeTextBox.sendKeys(postalCode);
		cityTextBox.sendKeys(city);
		countryTextBox.sendKeys(countryName);
		stateTextBox.sendKeys(state);
		descriptionTextArea.sendKeys(description);
		saveButton.click();
	}
	/**
	 *  to create lead without mandatory data
	 * @param salutation
	 * @param firstname
	 * @param phoneNo
	 * @param mobileNo
	 * @param designation
	 * @param fax
	 * @param email
	 * @param leadsource
	 * @param industry
	 * @param annualRevenue
	 * @param website
	 * @param leadStatus
	 * @param noOfEmployee
	 * @param rating
	 * @param secoundryemail
	 * @param street
	 * @param pobox
	 * @param postalCode
	 * @param city
	 * @param countryName
	 * @param state
	 * @param description
	 * @throws Throwable 
	 */
	public void createLead(String salutation,String firstname,String phoneNo,String mobileNo,String designation,String fax,String email,String leadsource,String industry,String annualRevenue,String website,String leadStatus,String noOfEmployee,String rating,String secoundryemail,String street,String pobox,String postalCode,String city,String countryName,String state,String description) throws Throwable {
		select(salutationDropDown, salutation);
		firstNameTextBox.sendKeys(firstname);
		phoneNoTextBox.sendKeys(phoneNo);
		mobileNoTextBox.sendKeys(mobileNo);
		designationTextBox.sendKeys(designation);
		faxTextBox.sendKeys(fax);
		emailTextBox.sendKeys(email);
		//waitAndClick(leadSourceDropDown);
		select(leadSourceDropDown, leadsource);
		select(industryDropDown, industry);
		annualRevenueTextBox.clear();
		annualRevenueTextBox.sendKeys(annualRevenue);
		websiteTextBox.sendKeys(website);
		select(leadStatusDropDown, leadStatus);
		noOfEmployeeTextBox.sendKeys(noOfEmployee);
		select(ratingDropDown, rating);
		secoundaryEmailTextBox.sendKeys(secoundryemail);
		SteetTextArea.sendKeys(street);
		poBoxNoTextBox.sendKeys(pobox);
		postalCodeTextBox.sendKeys(postalCode);
		cityTextBox.sendKeys(city);
		countryTextBox.sendKeys(countryName);
		stateTextBox.sendKeys(state);
		descriptionTextArea.sendKeys(description);
		saveButton.click();
	}
}
