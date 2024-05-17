package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import constants.FileConstants;
import constants.WaitConstants;
import listeners.TestListener;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.DataUtils;
import java.util.List;

@Listeners(TestListener.class)
public class UserMenuTest extends BaseTest{

	@BeforeMethod	
	public void preCondition() throws IOException{
		System.out.println("Pre condition: Home Page");
		BaseTest.setDriver("chrome", false);
	}
	
	
	@Test
	public void selectUserMenu_TC05() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		BaseTest bt = new BaseTest();
		bt.goToUrl();
//		Assert.assertTrue(lp.isLoginPageOpen(driver), "is launched");
//		Assert.assertTrue(lp.isApplicationURLLaunched(driver), " is launched.");
//		lp.loginToSFDC(lp.getUsername(driver), lp.getPassword());
//		Assert.assertTrue(lp.isHomePageLoaded(driver), "Home Page is loaded");
//		test.log(Status.PASS, "Salesforce login page is launched and application home page is logged in with "+ump.getUserName());
		
		
		
//		String url = DataUtils.readLoginTestData("url");
//		String userName = DataUtils.readLoginTestData("username");
//		String pwd = DataUtils.readLoginTestData("password");
//		driver.get(url);		
//		Assert.assertTrue(lp.isLoginPageOpen(driver), "login page is open");
//		test.log(Status.INFO, "login page is launched");
//		lp.loginToSFDC(userName, pwd);
//		Assert.assertTrue(lp.isHomePageLoaded(driver), "Home page is loaded.");
//		test.log(Status.INFO, "Home page is loaded for user "+lp.userMenu.getText());
//		ump.userMenu.click();
//		Assert.assertTrue(lp.userMenu.isDisplayed(), "User menu is visible");
//		
//		List<String>  actualOptionNames = ump.getUserMenuOptionNames();
//		List<String> expectedOptionNames = Arrays.asList("My Profile", "My Settings","Developer Console","Switch to Lightning Experience","Logout");
//		Assert.assertEquals(actualOptionNames,  expectedOptionNames, "All options are loaded with their names.");
//		test.log(Status.PASS, actualOptionNames+ " is displayed.");
	}
	
	
//	@Test
	public void verifyMyProfile_TC06() throws IOException, InterruptedException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		
		driver.get(DataUtils.readLoginTestData("url"));		
		lp.loginToSFDC(DataUtils.readLoginTestData("username"), DataUtils.readLoginTestData("password"));
		ump.selectUserMenu();
		Assert.assertTrue(ump.selectUserMenuOption(driver, "My Profile"), "Usermenu option should be selected");
		ump.selectEditIcon(driver);
		Assert.assertTrue(ump.verifyEditContactIframe(driver), "Iframe should be loaded.");
		String updateLastName = DataUtils.readLoginTestData("updateLastName");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, updateLastName), "LastName should be changed");
		String createPostContent = DataUtils.readLoginTestData("createPostContent");
		Assert.assertTrue(ump.veriyfyCreatePost(driver, createPostContent), "Post should be created.");
		String filePath = FileConstants.FILE_PATH;
		System.out.println("filepath"+filePath);
		Assert.assertTrue(ump.verifyFileUpload(driver, filePath), "File should be uploaded successfully.");
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.IMAGE_PATH), "Photo should be uploaded successfully.");
		//driver.quit();
	}	
	
//	@Test
	public void selectUserMenuOption_TC07() throws IOException {
		
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		
		String url = DataUtils.readLoginTestData("url");
		String userName = DataUtils.readLoginTestData("username");
		String pwd = DataUtils.readLoginTestData("password");
		driver.get(url);		
		Assert.assertTrue(lp.isLoginPageOpen(driver), "login page is open");
		lp.loginToSFDC(userName, pwd);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Home page is loaded.");
		
		ump.selectUserMenu();
		Assert.assertTrue(lp.userMenu.isDisplayed(), "User menu is visible");
		List<String>  actualOptionNames = ump.getUserMenuOptionNames();
		List<String> expectedOptionNames = Arrays.asList("My Profile", "My Settings","Developer Console","Switch to Lightning Experience","Logout");
		Assert.assertEquals(actualOptionNames,  expectedOptionNames, "All options are loaded with their names.");
		test.log(Status.INFO, actualOptionNames+ " is displayed.");
		Assert.assertTrue(ump.selectOption(driver, "My Settings"), "My Settings option selected");
		
		String actualSettingsTitle = driver.getTitle();
		String expectedSettingTitle = "Hello, "+ump.userMenu.getText()+"! ~ Salesforce - Developer Edition";
		Assert.assertEquals(actualSettingsTitle,expectedSettingTitle, "My Settings page is displayed.");
		test.log(Status.INFO, "My Settings page is displayed.");
		
		ump.personalLink.click();
		Assert.assertTrue(ump.selectOption(driver, "Login History"), "Login History is selected.");
		
		ump.downloadLoginHistoryLink.click();
		test.log(Status.INFO, "Download Login History link is clicked");

		Assert.assertTrue(ump.selectOption(driver, "Display & Layout"), "Display & Layout is selected.");
		
		Assert.assertTrue(ump.selectOption(driver, "Customize My Tabs"), "Customize My Tabs is selected");
		ump.customApp.click();
		Assert.assertTrue(ump.selectOption(driver, "Reports"), "Reports tab is selected");
		ump.Add.click();
		test.log(Status.INFO, "Reports tab is saved in selected tab");
		//*********Reports field is added to Selected Tabs list and also added in the links available in top of salesforce page and sales force chatter page and sales and marketing pages.
		Assert.assertTrue(ump.selectOption(driver, "Email"), "Email Tabs is selected");
		Assert.assertTrue(ump.selectOption(driver, "My Email Settings"), "My Email Settings Tabs is selected");
		ump.emailName.clear();
		ump.emailName.sendKeys(DataUtils.readLoginTestData("emailName"));
		ump.emailAddress.clear();
		ump.emailAddress.sendKeys(DataUtils.readLoginTestData("emailAddress"));
		ump.bccRadiobutton.click();
		ump.saveOnEmail.click();
		Assert.assertTrue(ump.emailSettingsConfirmation.isDisplayed(), "Email settings page is displayed");
		test.log(Status.INFO, "Given details are saved as default mail options and My settings page is displayed.");
		Assert.assertTrue(ump.selectOption(driver, "Calendar & Reminders"), "Calendar & Reminders Tabs is selected");
		Assert.assertTrue(ump.selectOption(driver, "Activity Reminders"), "Calendar & Reminders Tabs is selected");
		ump.openaTestRemainder.click();
		String actualReminderPage = driver.getTitle();
		String expectedReminderPage = DataUtils.readLoginTestData("reminderPageTitle");
		Assert.assertEquals(actualReminderPage, expectedReminderPage, "Verify Reminder page");
		test.log(Status.INFO,"Sample event pop up window is displayed");
	}
	
//	@Test
	public void selectUserMenuOptionConsole_TC08() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		
		driver.get(DataUtils.readLoginTestData("url"));		
		lp.loginToSFDC(DataUtils.readLoginTestData("username"), DataUtils.readLoginTestData("password"));
		
		ump.selectUserMenu();		
		Assert.assertTrue(lp.userMenu.isDisplayed(), "Verify User menu is visible");
		List<String>  actualOptionNames = ump.getUserMenuOptionNames();
		List<String> expectedOptionNames = Arrays.asList("My Profile", "My Settings","Developer Console","Switch to Lightning Experience","Logout");
		Assert.assertEquals(actualOptionNames,  expectedOptionNames, "Verify All options are loaded with their names.");
		test.log(Status.INFO, actualOptionNames+ " is displayed.");
		
		Assert.assertTrue(ump.selectUserMenuOption(driver, "Developer Console"), "Verify Developer Console option selected");
		test.log(Status.INFO, "Developer Console is clicked");
	
		String parentWindow = driver.getWindowHandle();
		ump.switchToNewWindow(driver, parentWindow);
		String expectedDevConsoleTitle = DataUtils.readLoginTestData("developerConsolePageTitle");
		String actualConsoleTitle = driver.getTitle();
		Assert.assertEquals(actualConsoleTitle ,expectedDevConsoleTitle, "Verify Developer Console Page");
		test.log(Status.INFO, "Developer Console window is displayed.");
		driver.close();
		driver.switchTo().window(parentWindow);
		test.log(Status.INFO, "Switching back to main window");
	}
	
//	@Test
	public void selectUserMenuOptionLogout_TC09() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		
		String url = DataUtils.readLoginTestData("url");
		String userName = DataUtils.readLoginTestData("username");
		String pwd = DataUtils.readLoginTestData("password");
		driver.get(url);		
		Assert.assertTrue(lp.isLoginPageOpen(driver), "login page is open");
		lp.loginToSFDC(userName, pwd);
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Varify Home page");
		
		ump.selectUserMenu();
		Assert.assertTrue(lp.userMenu.isDisplayed(), "User menu is visible");
		List<String>  actualOptionNames = ump.getUserMenuOptionNames();
		List<String> expectedOptionNames = Arrays.asList("My Profile", "My Settings","Developer Console","Switch to Lightning Experience","Logout");
		Assert.assertEquals(actualOptionNames,  expectedOptionNames, "All options are loaded with their names.");
		test.log(Status.INFO, actualOptionNames+ " is displayed.");
		
		Assert.assertTrue(ump.selectUserMenuOption(driver, "Logout"), "Varify Logout is clicked");
		test.log(Status.INFO, "Logout is clicked.");
		
		// Wait for the page title to become available
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Login | Salesforce"));
		String actualTitle = driver.getTitle();
		System.out.println("actualTitle is "+actualTitle);		
		String expectedTitle = DataUtils.readLoginTestData("loginPageTitle");
		System.out.println("expectedTitle is "+expectedTitle);		
		Assert.assertEquals(actualTitle, expectedTitle, "Verify page title");
		test.log(Status.INFO, actualTitle+ " page is displayed.");		
	}
	
	
	@AfterMethod
	public void postCondition() {
		System.out.println("Post condition: Home Page of the app");
		//BaseTest.getDriver().close();
	}

}
