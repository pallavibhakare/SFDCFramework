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
	public void preCondition() {
		BaseTest.setDriver("chrome", false);
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
	
	@Test
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
	
	@AfterMethod
	public void postCondition() {
		BaseTest.getDriver().close();
	}
}
