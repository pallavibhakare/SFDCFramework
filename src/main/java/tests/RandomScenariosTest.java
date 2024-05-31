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
import pages.LoginPage;
import pages.RandomScenariosPage;
import pages.UserMenuPage;

@Listeners(TestListener.class)
public class RandomScenariosTest extends BaseTest{

	LoginPage lp;
	UserMenuPage ump;
	
	@BeforeMethod
	public void preCondition() throws IOException {
		BaseTest.setDriver("chrome", false);
		
		lp = new LoginPage(driver);
		lp.launchAndLoginToApplication(driver);		
	}
	
	
//	@Test
	public void verifyFirstNameandLastNameOfTheUser_TC33() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		RandomScenariosPage rsp = new RandomScenariosPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		
		rsp.getHomeTab();
		Assert.assertTrue(rsp.isHomeTabPage(driver));
		test.log(Status.PASS, "1.Home tab's home Page is displayed.");	
		Assert.assertTrue(rsp.isUserNameLinkDisplayed(driver));
		test.log(Status.PASS, "2. Correct account holder is displayed as a link.");		
		rsp.getUserNameLink(driver);
		Assert.assertTrue(ump.isUserProfilePage(driver));
		test.log(Status.PASS, driver.getTitle() +" page is displayed");
		Assert.assertTrue(rsp.isUserNamePagesSameAsMyProfile(driver));
		test.log(Status.PASS, "Current page '"+driver.getTitle()+"' is same as the 'My Profile' page.");
	}
	
//	@Test
	public void verifyLastNameUpadate_TC34() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		RandomScenariosPage rsp = new RandomScenariosPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		rsp.getHomeTab();
		Assert.assertTrue(rsp.isHomeTabPage(driver));
		test.log(Status.PASS, "Home tab's home Page is displayed.");	
		rsp.getUserNameLink(driver);
		Assert.assertTrue(ump.isUserProfilePage(driver));
		test.log(Status.PASS, "The "+driver.getTitle()+" is displayed.");
		ump.selectEditIcon(driver);
		Assert.assertTrue(ump.isEditContactIframe(driver));
		test.log(Status.PASS, "The 'Edot Profile' popup is displayed with the 'Contact tab' selected.");
		Assert.assertTrue(ump.isFocusAtFirstNameField(driver), "Verify focus id at First Name field");
		test.log(Status.PASS, "Focus is in the First Name field.");
		ump.changeLastNameAndSaveAll(driver);
		Assert.assertFalse(ump.isEditContactIframe(driver));
		test.log(Status.PASS, "1. The 'Edit Profile' popup is closed");
		Assert.assertTrue(ump.isLastNameUpdatedInBreadCrumb(driver));
		test.log(Status.PASS, "2. LastName is updated in breadcrumb");
		Assert.assertTrue(ump.isLastNameUpdatedInUsermenu(driver));
		test.log(Status.PASS, "3. Last Name is updated in 'User menu'");
		Assert.assertTrue(ump.isLastNameUpdatedInPageTitle(driver));
		test.log(Status.PASS, "4. Last Name is updated in Account holder's Page Title");		
	}
	
//	@Test
	public void theTabCustomization_TC35() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		RandomScenariosPage rsp = new RandomScenariosPage(driver);
		lp.launchAndLoginToApplication(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");
		
		rsp.allTab(driver);
		Assert.assertTrue(rsp.isAllTabPageLoaded(driver), "Verify All tabs Page is loaded.");
		test.log(Status.PASS, driver.getTitle()+" is displayed.");
		rsp.customizeMyTabBtn(driver);		
		Assert.assertTrue(rsp.isCustomizeMyTabsPage(driver), "Verfiy Customize My Tabs Page");
		test.log(Status.PASS, driver.getTitle()+" page is displayed.");		
		rsp.removeAnyTab(driver);
		Assert.assertTrue(rsp.isTabRemovedFromSelected(driver), "Verfiy Tabs is removed from Selected Tabs");
		test.log(Status.PASS, "The selected tab is removed from the 'Selected Tabs' section.");
		Assert.assertTrue(rsp.isTabAddedToAvailableTabs(driver), "Verfiy Tabs is added to Available Tabs");
		test.log(Status.PASS, "and should be moved to the 'Available Tabs' section.");
		rsp.saveCustomizeMyTabs(driver);
		Assert.assertTrue(rsp.isAllTabPageLoaded(driver), "Verify All tabs Page is loaded.");
		test.log(Status.PASS, "1. "+driver.getTitle()+" is displayed.");
		Assert.assertTrue(rsp.isTabRemovedFromTabBar(driver), "Verify All tabs Page is loaded.");
		test.log(Status.PASS, "2. The '"+rsp.getTabNameToRemove(driver)+"' is removed from Tab Bar");
		lp.logoutFromSFDC(driver);
		Assert.assertTrue(lp.isLoggedOut(driver));
		test.log(Status.PASS, driver.getTitle()+" is displayed");
		lp.loginToSFDC(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "1. SalesForce application is Launched");
		Assert.assertTrue(rsp.isTabRemovedFromTabBar(driver), "Verify All tabs Page is loaded.");
		test.log(Status.PASS, "2. The '"+rsp.getTabNameToRemove(driver)+"' is removed from Tab Bar");
	}
	@Test
	public void blockingAnEventInTheCalender_TC36() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		RandomScenariosPage rsp = new RandomScenariosPage(driver);

		Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify Application launched.");
		test.log(Status.PASS, "SalesForce application is Launched");		
		rsp.getHomeTab();
		Assert.assertTrue(rsp.isHomeTabPage(driver));
		test.log(Status.PASS, "1. Home tab's home Page is displayed.");
		Assert.assertTrue(rsp.isDateDisplayedAsLink(driver));
		test.log(Status.PASS, "2. "+rsp.getCurrentDate(driver)+" is displayed Account Holder's name in Day Month Date,Year format.");
		rsp.clickCurrentDate(driver);
		Assert.assertTrue(rsp.isUserCalenderPage(driver));
		test.log(Status.PASS, driver.getTitle()+" is displayed.");
		rsp.clickOnTime(driver, "8:00 PM");
		Assert.assertTrue(rsp.isCalendarNewEventPageWithCursorOnSubject(driver));
		test.log(Status.PASS, "The '"+driver.getTitle()+"' page is displayed with the cursor at the Subject field.");

		Boolean popupOpened = rsp.isComboBoxPopupOpened(driver);
		Assert.assertTrue(popupOpened);
		test.log(Status.PASS, driver.getTitle()+" is opened.");
		
//		System.out.print(popupOpened);/true
		rsp.performActionInPopup(driver, popupOpened);
		Assert.assertTrue(rsp.isPopupClosed(driver));
		test.log(Status.PASS, "1. The 'Checkbox' popup is closed.");
		rsp.isOtherInSubjectField(driver);
		Assert.assertTrue(rsp.isOtherInSubjectField(driver));
		test.log(Status.PASS, "2. '"+rsp.getSubjectFieldValue(driver)+"' is  entered in Subject field.");
		Assert.assertTrue(rsp.areDropdownTimesCorrect(driver));
		test.log(Status.PASS, "Drop down is displayed with time starting from 9:00 PM till 11:30 PM.");
	
		Assert.assertTrue(rsp.selectTime(driver));
		test.log(Status.PASS, rsp.getSelectedTime(driver)+" is selected in the 'End' field.");
//		Assert.assertTrue(rsp.isSavedCalenderEvent(driver));
//		test.log(Status.PASS, "The '"+driver.getTitle() +"' page is displayed with 'Other' event in the time slot 8:00PM to 9:00PM, as a link.");
	}
	@AfterMethod
	public void postCondition() {
//		BaseTest.getDriver().close();
	}
}
