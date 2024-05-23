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
import pages.CreateAccountPage;
import pages.CreateOptyPage;
import pages.UserMenuPage;



@Listeners(TestListener.class)
public class CreateOptyTest extends BaseTest{
	
	@BeforeMethod
	public void preCondition() {
		BaseTest.setDriver("chrome", false);
	}
	
//	@Test
	public void optyDropdown_TC15() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		CreateAccountPage cap = new CreateAccountPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		CreateOptyPage cop =new CreateOptyPage(driver);
		cap.launchAndLoginToApplication(driver);
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cop.getOptyTab(driver);
		Assert.assertTrue(cop.isOptyPageDisplayed(driver), "Verify Opportunity page");
		test.log(Status.PASS, "Opportunity Home page is displayed.");
		
		cop.selectOptyViewDropdown(driver);
		Assert.assertTrue(cop.isOptyViewOptionsLoaded(driver), "Verify oppotyunity View options");
		test.log(Status.PASS, "Drop down with "+cop.getOptyViewOptionNames()+" should be available");
	}
//	@Test
	public void createNewOpty_TC16() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		CreateAccountPage cap = new CreateAccountPage(driver);
		CreateOptyPage cop = new CreateOptyPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		cap.launchAndLoginToApplication(driver);
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cop.getOptyTab(driver);
		Assert.assertTrue(cop.isOptyPageDisplayed(driver), "Verify Opportunity page");
		test.log(Status.PASS, "Opportunity page is displayed.");
		cop.createNewOpty(driver);
		Assert.assertTrue(cop.isNewOptyPage(driver), "Verify New oppportunity Page");
		test.log(Status.PASS, "New Opportunity page is displayed with Opportunity details.");
	}
//	@Test
	public void testOptyPipelineReport_TC17() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		CreateAccountPage cap = new CreateAccountPage(driver);
		CreateOptyPage cop = new CreateOptyPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		cap.launchAndLoginToApplication(driver);
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cop.getOptyTab(driver);
		Assert.assertTrue(cop.isOptyPageDisplayed(driver), "Verify Opportunity page");
		test.log(Status.PASS, "Opportunity home page is displayed.");
		cop.getOptyPipelineReport(driver);
		Assert.assertTrue(cop.isOptyPipelineReportPage(driver), "Verify opportunity Pipeline page");
		test.log(Status.PASS, "Report Page with the Opportunities that are pipelined is displayed.");
	}
//	@Test
	public void testStuckOpportunitiesReport_TC18() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		CreateAccountPage cap = new CreateAccountPage(driver);
		CreateOptyPage cop = new CreateOptyPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		cap.launchAndLoginToApplication(driver);
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cop.getOptyTab(driver);
		Assert.assertTrue(cop.isOptyPageDisplayed(driver), "Verify Opportunity page");
		test.log(Status.PASS, "Opportunity home page is displayed.");
		cop.getStuckOpportunitiesReport(driver);
		Assert.assertTrue(cop.isStuckOpportunitiesReportPage(driver), "Verify stuck opportunity page");
		test.log(Status.PASS, "Report Page with the Opportunities that are Stuck is displayed.");
	}
	
	@Test
	public void testQuarterlySummaryReport_TC19() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		CreateAccountPage cap = new CreateAccountPage(driver);
		CreateOptyPage cop = new CreateOptyPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		cap.launchAndLoginToApplication(driver);
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cop.getOptyTab(driver);
		Assert.assertTrue(cop.isOptyPageDisplayed(driver), "Verify Opportunity page");
		test.log(Status.PASS, "Opportunity home page is displayed.");
		cop.getQuarterlySummaryReport(driver);
		Assert.assertTrue(cop.isQuarterlySummaryReportPage(driver), "Verify stuck opportunity page");
		test.log(Status.PASS, "Report Page with the Opportunities that satisfies the search criteria is displayed.");
	}
	
	@AfterMethod
	public void postCondition() {
		System.out.println("Post condition: Home Page of the app");
		BaseTest.getDriver().close();
	}
}
