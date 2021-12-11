package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
	initialization(); 
	testUtil = new TestUtil();
	loginPage = new LoginPage();
	contactsPage = new ContactsPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	testUtil.switchToFrame();
	contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("Rahul Shukla");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("Sanket Lasnapure");
		contactsPage.selectContactsByName("Rahul Shukla");
	}
	
//	@DataProvider
//	public Object[][] getCRMTestData() {
//		Object data[][] = TestUtil.getTestdata(sheetName);
//		return data;
//	}
	
//	@Test(priority=4, dataProvider="getCRMTestData")
//	public void vaildateCreateNewContact(String title, String firstName, String lastName, String company) {
//		homePage.clickOnNewContactLink();
//		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
//		contactsPage.createNewContact(title, firstName, lastName, company);
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
