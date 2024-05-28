package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import constants.WaitConstants;
import listeners.TestListener;
import pages.ContactsPage;
import pages.LoginPage;

@Listeners(TestListener.class)
public class ContactsTest extends BaseTest {
	
	LoginPage lp;
	
	@BeforeMethod
	public void preCondition() {
		BaseTest.setDriver("chrome", false);
	}
	
//	@Test
	public void createNewContact_TC25() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		cp.getContactTab(driver);
		Assert.assertTrue(cp.isContactsHomePage(driver), "Verify Contacts Home Page is displayed.");
		test.log(Status.PASS, "Contacts Home page is displayed");
		cp.newBtnClick(driver);
		Assert.assertTrue(cp.isNewContactHomePage(driver), "Verify New Contact Home Page is displayed.");
		test.log(Status.PASS, "New Contact Home page is displayed");
		cp.newContactEditDetails(driver);
		Assert.assertTrue(cp.isLastNameFieldEntered(driver), "Verify Last Name is entered");
		test.log(Status.PASS, "Last name is enterd in Last name field");
		Assert.assertTrue(cp.isAccountsNameFieldEntered(driver), "Verify Account Name is entered");
		test.log(Status.PASS, "Account Name is enterd in Account name field.");
		cp.saveButton(driver);
		Assert.assertTrue(cp.isNewContactSaved(driver), "Verify New Contact is saved.");
		test.log(Status.PASS, "New contact is created");
	}
	
//	@Test
	public void createNewView_TC26() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		cp.getContactTab(driver);
		Assert.assertTrue(cp.isContactsHomePage(driver), "Verify Contacts Home Page is displayed.");
		test.log(Status.PASS, "Contacts Home page is displayed");
		cp.getCreateNewViewLink(driver);
		Assert.assertTrue(cp.isCreateNewViewPage(driver), "Verify New View Page.");
		test.log(Status.PASS, "New View page is displayed.");
		cp.createNewView(driver);
		Assert.assertTrue(cp.isViewNameEntered(driver), "Verify View Name is entered");
		test.log(Status.PASS, "View Name is entered in the view name field.");
		Assert.assertTrue(cp.isViewUniqueNameEntered(driver), "Verify View Name is entered");
		test.log(Status.PASS, "View Unique Name is entered in the view unique name field.");
		cp.saveNewContactBtn(driver);
		Assert.assertTrue(cp.isContactsHomeAndDefaultViewDisplayed(driver), "Verify Contacts Home page and created view.");
		test.log(Status.PASS, "Contacts Home page is opened. Created View name is displayed in drop down in that page by defalut. ");
	}
//	@Test
	public void createNewView_TC27() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		cp.getContactTab(driver);
		Assert.assertTrue(cp.isContactsHomePage(driver), "Verify Contacts Home Page is displayed.");
		test.log(Status.PASS, "Contacts Home page is displayed");
		
		cp.recentlyCreated(driver);
		test.log(Status.PASS, "Recent contacts are displayed");
	}
//	@Test
	public void createNewView_TC28() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		cp.getContactTab(driver);
		Assert.assertTrue(cp.isContactsHomePage(driver), "Verify Contacts Home Page is displayed.");
		test.log(Status.PASS, "Contacts Home page is displayed");
		
		cp.viewCheckForMyContacts(driver);
		Assert.assertTrue(cp.checkSelectedView(driver));
		test.log(Status.PASS, "'My Contacts' is displayed.");
	}
//	@Test
	public void viewAContact_TC29() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		cp.getContactTab(driver);
		Assert.assertTrue(cp.isContactsHomePage(driver), "Verify Contacts Home Page is displayed.");
		test.log(Status.PASS, "Contacts Home page is displayed");
		
		cp.clickAContact(driver);
		Assert.assertTrue(cp.isSelectedContactDetailsDisplayed(driver), "Verify Contact");
		test.log(Status.PASS, "Contact Page related to '"+cp.getContactName(driver)+"', which contains entire information about that ;"+cp.getContactName(driver)+"' should be displayed ");
	}
//	@Test
	public void errorForNewView_TC30() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		cp.getContactTab(driver);
		Assert.assertTrue(cp.isContactsHomePage(driver), "Verify Contacts Home Page is displayed.");
		test.log(Status.PASS, "Contacts Home page is displayed");
		
		cp.getCreateNewViewLink(driver);
		Assert.assertTrue(cp.isCreateNewViewPage(driver), "Verify Create New View Page");
		test.log(Status.PASS, "Create New View page is opened.");
		
		cp.createNewViewUniqueNameError(driver);
		Assert.assertTrue(cp.isViewUniqueNameEntered(driver), "Verify Unique Name entered");
		test.log(Status.PASS, "Unique Name: "+cp.getCreateNewViewUniqueName(driver));
		
		cp.saveNewContactBtn(driver);
		Assert.assertTrue(cp.isUniqueNameError(driver), "Verify Error");
		test.log(Status.PASS, "Error message is appeared under the View Name field. "+cp.getErrorMsg(driver));
	}
//	@Test
	public void cancelFunction_TC31() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		cp.getContactTab(driver);
		Assert.assertTrue(cp.isContactsHomePage(driver), "Verify Contacts Home Page is displayed.");
		test.log(Status.PASS, "Contacts Home page is displayed");
		
		cp.getCreateNewViewLink(driver);
		Assert.assertTrue(cp.isCreateNewViewPage(driver), "Verify Create New View Page");
		test.log(Status.PASS, "Create New View page is opened.");
		
		cp.createViewForCancel(driver);
		Assert.assertTrue(cp.isViewNameEntered(driver) && cp.isViewUniqueNameEntered(driver), "Verify View Name and Unique Name entered");
		test.log(Status.PASS, "The view name and Unique name should be enetered");
		cp.cancelCreateViewCreation(driver);
		Assert.assertTrue(cp.isViewCreationCancelled(driver), "Verify Cancel Error Message");
		test.log(Status.PASS, "Contacts Home page is displayed and the View "+cp.getViewNameForCancel(driver)+" is not be created.");
	}
	@Test
	public void saveAndNewBtnForContact_TC32() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		cp.getContactTab(driver);
		Assert.assertTrue(cp.isContactsHomePage(driver), "Verify Contacts Home Page is displayed.");
		test.log(Status.PASS, "Contacts page is opened.");
		
		cp.newBtnClick(driver);
		Assert.assertTrue(cp.isNewContactHomePage(driver), "Verify New Contact Page");
		test.log(Status.PASS, "'"+driver.getTitle()+"'  page is displayed.");
		
		cp.newContactDetails(driver);
		Assert.assertTrue(cp.isLastNameFieldEntered1(driver), "Verify last Name");
		Assert.assertTrue(cp.isAccountsNameFieldEntered(driver), "Verify Account name");
		test.log(Status.PASS, "Last Name and the Account Name is enetered.");
		cp.saveAndNewAction(driver);
		Assert.assertTrue(cp.isNewContactHomePage(driver), "Verify New contact Page");
		test.log(Status.PASS, "New contact is created. "+driver.getTitle()+" is dispalyed");
	}
	
	
	@AfterMethod
	public void postCondition() {
		System.out.println("Post condition");
		BaseTest.getDriver().close();
	}

}
