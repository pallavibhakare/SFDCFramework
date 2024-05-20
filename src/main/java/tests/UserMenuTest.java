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
import pages.UserMenuPage;
import utils.WaitUtils;


@Listeners(TestListener.class)
public class UserMenuTest extends BaseTest{

	@BeforeMethod	
	public void preCondition() throws IOException{
		System.out.println("Pre condition: Home Page");
		BaseTest.setDriver("chrome", false);
	}
	
	
//	@Test
	public void selectUserMenu_TC05() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		BaseTest bt = new BaseTest();
		bt.goToUrl(driver);
		Assert.assertTrue(lp.isLoginPageOpen(driver), lp.getLoginPageTitle()+" is launched.");
		test.log(Status.INFO, lp.getLoginPageTitle()+" is launched.");
		
		lp.loginToSFDC(driver);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Validate Home page is loaded");
		test.log(Status.PASS, lp.getLoginPageTitle()+" is launched and application home page os logged on with correst user "+ump.getUserName(driver));
		
		bt.clickElement(lp.getUsermenu(driver), "User Menu");
		Assert.assertTrue(ump.isUserMenuVisible(), "Verify user menu navigation is visible.");
		test.log(Status.PASS, "User menu drop down is available.");
		ump.getUserMenuOptionNames();
		Assert.assertTrue(ump.isUserMenuOptionsLoaded(), "Verify all user options are loaeded.");
		test.log(Status.PASS, ump.getUserMenuOptionNames()+" All user options are loaded");
		
	}
//	@Test
	public void verifyMyProfile_TC06() throws IOException, InterruptedException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		BaseTest bt = new BaseTest();
		bt.goToUrl(driver);
		
		lp.loginToSFDC(driver);
		bt.clickElement(lp.getUsermenu(driver), "User Menu");
		Assert.assertTrue(ump.isUserMenuOptionsLoaded(), "Verify all user options are loaeded.");
		test.log(Status.PASS, ump.getUserMenuOptionNames()+" All user options are loaded");
		
		ump.selectUserMenuOption(driver, "My Profile");
		Assert.assertTrue(ump.isUserProfilePage(driver), "Verify user profile page is displayed.");
		test.log(Status.PASS, "User Profile page is displayed.");
		
		ump.selectEditIcon(driver);
		Assert.assertTrue(ump.isEditContactIframe(driver), "Verify Iframe is loaded.");
		test.log(Status.PASS, "Edit Profile Pop up is displayed with contact and About tabs to edit.");
		ump.verifyLastNameChangeInAboutTab(driver);
		Assert.assertTrue(ump.isUserProfilePage(driver), "Verify UserProfilePage with changed <lastname> is displayed.");
		test.log(Status.PASS, "User Profile Page is displayed with changed "+ump.getUserName(driver)+" is displayed.");
		
		//ump.veriyfyCreatePost(driver);
		Assert.assertTrue(ump.veriyfyCreatePost(driver), "Verify post is created.");
		test.log(Status.PASS, "Post is visible in on the page.");
		
		Assert.assertTrue(ump.verifyFileUpload(driver), "File should be uploaded");
		test.log(Status.PASS, "File is posted");
		Assert.assertTrue(ump.verifyPhotoUpload(driver),"Photo shpuld be uploaded");
		test.log(Status.PASS, "Photo is uploaded");
	}	
	
//	@Test (description="done in the class")
//	public void verifyMyProfile_TC06() throws IOException, InterruptedException {
//		test = BaseTest.threadExtentText.get();
//		driver = BaseTest.getDriver();
//		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
//		
//		LoginPage lp = new LoginPage(driver);
//		UserMenuPage ump = new UserMenuPage(driver);
//		
//		driver.get(DataUtils.readLoginTestData("url"));		
//		lp.loginToSFDC(driver);
//		ump.selectUserMenu();
//		Assert.assertTrue(ump.selectUserMenuOption(driver, "My Profile"), "Usermenu option should be selected");
//		ump.selectEditIcon(driver);
//		Assert.assertTrue(ump.verifyEditContactIframe(driver), "Iframe should be loaded.");
//		String updateLastName = DataUtils.readLoginTestData("updateLastName");
//		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, updateLastName), "LastName should be changed");
//		String createPostContent = DataUtils.readLoginTestData("createPostContent");
//		Assert.assertTrue(ump.veriyfyCreatePost(driver, createPostContent), "Post should be created.");
//		String filePath = FileConstants.FILE_PATH;
//		System.out.println("filepath"+filePath);
//		Assert.assertTrue(ump.verifyFileUpload(driver, filePath), "File should be uploaded successfully.");
//		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.IMAGE_PATH), "Photo should be uploaded successfully.");
//		//driver.quit();
//	}	
	
//	@Test
	public void selectUserMenuOption_TC07() throws IOException {
		
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		BaseTest bt = new BaseTest();
		bt.goToUrl(driver);
		lp.loginToSFDC(driver);
		ump.selectUserMenu();
		Assert.assertTrue(ump.isUserMenuOptionsLoaded(), "Verify user menu options are loaded.");
		test.log(Status.PASS, "Drop down with "+ump.getUserMenuOptionNames()+" is displayed");
		ump.selectUserMenuOption(driver, "My Settings");
		Assert.assertTrue(ump.isMySettingsPage(driver), "Verify 'My Settings' page is loaded.");
		test.log(Status.PASS, driver.getTitle() +"is displayed.");
		
		ump.getPersonalLink(driver);
		Assert.assertTrue(ump.selectOption(driver, "Login History"), "Login History is selected.");
		ump.getLoginHistory(driver);
		bt.clickElement(ump.downloadLoginHistoryLink, "Login History Link");
		test.log(Status.PASS, "Login history is displayed and the dta is downloaded.");
				
		Assert.assertTrue(ump.selectOption(driver, "Display & Layout"), "Display & Layout is selected.");
		Assert.assertTrue(ump.selectOption(driver, "Customize My Tabs"), "Customize My Tabs is selected");
		ump.PerformCustomizeMyTabOperation(driver);
		ump.checkReportsOption(driver);
		Assert.assertTrue(ump.checkReportsOption(driver),"Verify 'Reports' option added in selected Tabs");
		test.log(Status.PASS, "Reports field is added to Selected Tabs list");
		ump.getEmailTab(driver);
		ump.performMyEmailSettings(driver);
		Assert.assertTrue(ump.isEmailSettingsSaved(driver), "Verify email settings saved.");
		test.log(Status.PASS, "Given details are saved as default mail options and My Settings Page is displayed.");
		
		ump.getCalenderAndRemindersTab(driver);
		Assert.assertTrue(ump.isTestActivityReminderOpen(driver), "Verify Reminder Window is open");
		test.log(Status.INFO,"Sample event pop up window is displayed");
	}
	
//	@Test
	public void selectUserMenuOptionConsole_TC08() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		BaseTest bt = new BaseTest();		
		bt.goToUrl(driver);	
		lp.loginToSFDC(driver);		
		ump.selectUserMenu();
		Assert.assertTrue(ump.isUserMenuOptionsLoaded(), "Verify user menu options are loaded.");
		test.log(Status.PASS, "Drop down with "+ump.getUserMenuOptionNames()+" is displayed");
		String parentWindow = driver.getWindowHandle();
		ump.selectUserMenuOption(driver, "Developer Console");
		ump.switchToNewWindow(driver, parentWindow);		
		Assert.assertTrue(ump.isDevConsoleOpen(driver), "Verify 'Developer Console' page is loaded.");
		test.log(Status.PASS, driver.getTitle() +" is displayed.");				
		driver.close();
		test.log(Status.PASS, "Developer Console Window is closed");
		driver.switchTo().window(parentWindow);
		test.log(Status.INFO, "Switching back to main window");
	}
	
	@Test
	public void selectUserMenuOptionLogout_TC09() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		BaseTest bt = new BaseTest();		
		bt.goToUrl(driver);	
		lp.loginToSFDC(driver);		
		ump.selectUserMenu();
		Assert.assertTrue(ump.isUserMenuOptionsLoaded(), "Verify user menu options are loaded.");
		test.log(Status.PASS, "Drop down with "+ump.getUserMenuOptionNames()+" is displayed");
		
		ump.selectOption(driver, "Logout");
		WaitUtils.waitForElementToDisappear(driver, ump.getLogoutLink());
		Assert.assertTrue(lp.isLoggedOut(driver), "Verify logged out.");
		test.log(Status.PASS, "Logout  of current sales force application  and "+driver.getTitle()+" page is displayed.");
	
	}
		
	@AfterMethod
	public void postCondition() {
		System.out.println("Post condition: Home Page of the app");
		BaseTest.getDriver().close();
	}

}
