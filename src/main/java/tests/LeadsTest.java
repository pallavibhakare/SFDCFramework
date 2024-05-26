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
import pages.LeadsPage;
import pages.LoginPage;

@Listeners(TestListener.class)
public class LeadsTest  extends BaseTest{

	LoginPage lp ;
	
	@BeforeMethod
	public void preCondition() throws IOException {
		//driver initialize
		BaseTest.setDriver("chrome", false);
		driver = BaseTest.getDriver();
		//Initialize Login Page instance with driver
		lp = new LoginPage(driver);
		lp.launchAndLoginToApplication(driver);
	}	

//	@Test
	public void leadsTab_TC20() throws IOException {
		test = BaseTest.threadExtentText.get();		
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		LeadsPage ld = new LeadsPage(driver);
		ld.getLeadsTab(driver);
		Assert.assertTrue(ld.isLeadsHomePage(driver), "Verify Leads Home Page");
		test.log(Status.PASS, "Leads Home page is displayed");
	}
//	@Test
	public void leadsSelectView_TC21() throws IOException {
		test = BaseTest.threadExtentText.get();		
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		LeadsPage ld = new LeadsPage(driver);
		ld.getLeadsTab(driver);
		Assert.assertTrue(ld.isLeadsHomePage(driver), "Verify Leads Home Page");
		test.log(Status.PASS, "Leads Home page is displayed");
		ld.clickSelectView(driver);
		Assert.assertTrue(ld.isSelectViewOptionsLoaded(driver), "Verify Leads View options are loaded.");
		test.log(Status.PASS, "List should drop down and should show the following contents: "+ld.getSelectViewOptionNames(driver)+".");
	}
	
//	@Test
	public void leadsDefaultView_TC22() throws IOException, InterruptedException {
		test = BaseTest.threadExtentText.get();		
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		LeadsPage ld = new LeadsPage(driver);
		ld.getLeadsTab(driver);
		Assert.assertTrue(ld.isLeadsHomePage(driver), "Verify Leads Home Page");
		test.log(Status.PASS, "Leads Home page is displayed");
		ld.getTodaysLeadOption(driver);
		ld.getMyUnreadLeadsOption(driver);
		lp.logoutFromSFDC(driver);
		Assert.assertTrue(lp.isLoginPageOpen(driver), "Check login page");
		test.log(Status.PASS, "Salesforce Login Page appers.");
		lp.loginToSFDC(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "verify User is logged in");
		test.log(Status.PASS, "User is logged in to the application.");
		ld.getLeadsTab(driver);
		Assert.assertTrue(ld.isLeadsHomePage(driver), "Verify Leads Home Page");
		test.log(Status.PASS, "Leads homepage is displayed");
		ld.goButton(driver);
		Assert.assertTrue(ld.isSelectedViewDisplayed(driver), "Verify selected default view is displayed.");
		test.log(Status.PASS, "Default selected view and its view's page is displayed.");
	}
//	@Test
	public void listItem_TC23() throws IOException, InterruptedException {
		test = BaseTest.threadExtentText.get();		
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		LeadsPage ld = new LeadsPage(driver);
		ld.getLeadsTab(driver);
		Assert.assertTrue(ld.isLeadsHomePage(driver), "Verify Leads Home Page");
		test.log(Status.PASS, "Leads Home page is displayed");
		ld.getTodaysLeadOption(driver);
		ld.goButton(driver);
		Assert.assertTrue(ld.isSelectedViewPageTodaysLeads(driver), "Verify selected default view is displayed.");
		test.log(Status.PASS, "Todays's Lead page is displayed.");
	}
	
	@Test
	public void checkNewBtnLeadsHome_TC24() throws IOException, InterruptedException {
		test = BaseTest.threadExtentText.get();		
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		LeadsPage ld = new LeadsPage(driver);
		ld.getLeadsTab(driver);
		Assert.assertTrue(ld.isLeadsHomePage(driver), "Verify Leads Home Page");
		test.log(Status.PASS, "Leads Home page is displayed");
		ld.createNewLead(driver);
		Assert.assertTrue(ld.isNewLeadCreationPage(driver), "Verify New Lead edit Page");
		test.log(Status.PASS, "New Lead Creation page is open.");
		ld.enterNewLeadDetails(driver);
		Assert.assertTrue(ld.isNewlyCreatedLeadViewPage(driver), "Verify New Lead Details page");
		test.log(Status.PASS, "New lead is saved and newly created lead view page is displayed.");
	}
	@AfterMethod
	public void postCondition() {
		lp.logoutFromSFDC(driver);
		BaseTest.getDriver().close();
	}
	
}
