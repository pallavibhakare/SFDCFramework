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
import pages.UserMenuPage;


@Listeners(TestListener.class)
public class CreateAccountTest extends BaseTest {
			
	@BeforeMethod
	public void preCondition() {
		BaseTest.setDriver("chrome", false);
	}
	
//	@Test
	public void createAnAccount_TC10() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		UserMenuPage ump =new UserMenuPage(driver);
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.launchAndLoginToApplication(driver);	
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cap.getAccountTab(driver);
		Assert.assertTrue(cap.isAccountsPageDisplayed(driver), "Verify Accounts page");
		test.log(Status.PASS, "Accounts page is displayed with username "+ump.getUserName(driver));
		cap.isNewAccountEditPage(driver);		
		cap.createNewAccount(driver);
		Assert.assertTrue(cap.isNewAccountDetailsPage(driver), "Verify New Account created");
		test.log(Status.PASS, "New account page is displayed with account details");
	}
	
//	@Test
	public void createNewView_TC11() throws IOException {
	
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		UserMenuPage ump =new UserMenuPage(driver);
		CreateAccountPage cap = new CreateAccountPage(driver);
		
		cap.launchAndLoginToApplication(driver);	
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cap.getAccountTab(driver);
		Assert.assertTrue(cap.isAccountsPageDisplayed(driver), "Verify Accounts page");
		test.log(Status.PASS, "Accounts page is displayed with username "+ump.getUserName(driver));
		
		cap.createNewViewLink(driver);
		Assert.assertTrue(cap.isAccountsViewPage(driver), "Verify Accounts view page is displayed.");
		Assert.assertTrue(cap.isNewViewDisplayed(driver), "Verify newly added view is Visible.");
		test.log(Status.PASS, "Newly added view is displayed in the account view list.");
	}
//	@Test
	public void editView_TC12() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		CreateAccountPage cap = new CreateAccountPage(driver);
		UserMenuPage ump =new UserMenuPage(driver);
		cap.launchAndLoginToApplication(driver);
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cap.getAccountTab(driver);
		Assert.assertTrue(cap.isAccountsPageDisplayed(driver), "Verify Accounts page");
		test.log(Status.PASS, "Accounts page is displayed with username "+ump.getUserName(driver));
		cap.selectViewNameFromViewDropdown(driver);
		cap.getEdit(driver);
		Assert.assertTrue(cap.isEditViewPage(driver), "Verify Edit View page");
		test.log(Status.PASS, cap.getEditViewName(driver)+" edit page is displayed.");
		cap.performEditView(driver);
		Assert.assertTrue(cap.verifyEditView(driver), "Verify View page");
		test.log(Status.PASS, "View page with new View name in the drop down is displayed.");	
	}
//	@Test
	public void mergeAccounts_TC13() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		CreateAccountPage cap = new CreateAccountPage(driver);
		UserMenuPage ump =new UserMenuPage(driver);
		cap.launchAndLoginToApplication(driver);
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cap.getAccountTab(driver);
		Assert.assertTrue(cap.isAccountsPageDisplayed(driver), "Verify Accounts page");
		test.log(Status.PASS, "Accounts page is displayed with username "+ump.getUserName(driver));
		
		cap.mergeAccountsLink(driver);
		Assert.assertTrue(cap.isMergeStep2(driver), "Verift Merge Step 2");
		test.log(Status.PASS, "Merge by Accounts step 2 page is displayed.");
		cap.merge(driver);
		Assert.assertTrue(cap.isAccountsPageDisplayed(driver), "Verify Accounts Home Page displayed");
		test.log(Status.INFO, "Accounts page is displayed");
		boolean isRecentAccountInView = cap.recentView(driver);
		Assert.assertTrue(isRecentAccountInView, "Verify recent view is in view list");
		test.log(Status.PASS, "In recently viewed view, new merged account is listed.");
	}
	
	@Test
	public void createAccountReport_TC14() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		CreateAccountPage cap = new CreateAccountPage(driver);
		UserMenuPage ump =new UserMenuPage(driver);
		cap.launchAndLoginToApplication(driver);
		test.log(Status.PASS, "SalesForce login page is launched and application home page is logged in with username "+ump.getUserName(driver));
		cap.getAccountTab(driver);
		Assert.assertTrue(cap.isAccountsPageDisplayed(driver), "Verify Accounts page");
		test.log(Status.PASS, "Accounts page is displayed with username "+ump.getUserName(driver));
		cap.getLastActiviytReports(driver);
		Assert.assertTrue(cap.isUnsavedReportPage(driver), "Verify Unsaved Reports Page.");
		test.log(Status.PASS, "Unsaved Report page is displayed.");
		cap.selectReportOptions(driver);
		Assert.assertTrue(cap.isListOfAccountsDisplayed(driver), "Verify list of accounts displayed");
		test.log(Status.PASS, "List of accounts qualified are displayed.");
		cap.saveReports(driver);
		Assert.assertTrue(cap.isDetailedReportPage(driver), "Verify Detailed Reports Page.");
		test.log(Status.PASS, "Report page with details and "+cap.getReportName(driver)+" is displayed.");
	}
	
	@AfterMethod
	public void postCondition() {
		System.out.println("Post condition: Home Page of the app");
		BaseTest.getDriver().close();
	}
}
