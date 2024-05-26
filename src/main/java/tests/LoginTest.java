package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import constants.WaitConstants;
import listeners.TestListener;
import pages.LoginPage;
import utils.DataUtils;



@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	
	
	
	@BeforeMethod	
	public void preCondition(Method name) throws IOException{
		System.out.println("Pre condition: Login to app");
		BaseTest.setDriver("chrome", false); //localDriver
		
	}
	
//	@Test(description = "Login Error Message -1" )
	public void loginErrorMessage_TC01() throws IOException {
		//for creating this test.html report
		test = BaseTest.threadExtentText.get();
		
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("url"));
		Assert.assertTrue(lp.isLoginPageOpen(driver));
		test.log(Status.INFO, "website is loaded");
		
//		lp.usernameField.sendKeys(DataUtils.readLoginTestData("username"));				
			
		lp.enterUserName();			
		String expectedUsername = DataUtils.readLoginTestData("username");
		Assert.assertTrue(lp.isUserNameValueEntered(expectedUsername));
		test.log(Status.INFO, "Username is displayed in username field.");	
				
		//lp.passwordField.clear();				
		lp.clearPassword();		
		Assert.assertTrue(lp.isPasswordEmpty());
		test.log(Status.INFO, "Password field is cleared.");
		
		lp.clickLoginButton();
		test.log(Status.INFO, "Login button is clicked");	
		Assert.assertTrue(lp.isErrorMessageDisplayed());		
		test.log(Status.INFO, "Error message is displayed");
	 
	}
	
	@Test(description = "Login to SalesForce -2 ")
	public void loginToSalesForce_TC02() throws IOException {				
		test = BaseTest.threadExtentText.get();
		
		driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		driver.get(DataUtils.readLoginTestData("url"));
		Assert.assertTrue(lp.isLoginPageOpen(driver));
		test.log(Status.INFO, "SFDC login page is open.");
		
		lp.enterUserName();
		test.log(Status.INFO, "Uesrname is entered");		
		
		lp.enterPassword();
		test.log(Status.INFO, "Password is entered");		
		lp.clickLoginButton();
		test.log(Status.INFO, "Login button is clicked.");	
		Assert.assertTrue(lp.isHomePageLoaded(driver));
		test.log(Status.PASS, "Home Page is displayed.");	

	}	
	
	
//	@Test(description = "Check Remember Me -3 ")
	public void rememberMeCheckbox_TC03() throws IOException {
		//Initialize test and driver
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		//open login page
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("url"));		
		//Validate if the login page is open
		Assert.assertTrue(lp.isLoginPageOpen(driver), "SFDC login page is loaded");
		test.log(Status.PASS, "SFDC login page is loaded");	
		
		lp.enterUserName();
		lp.enterPassword();
		lp.selectRememberMeCheckbox();
		lp.clickLoginButton();
		Assert.assertTrue(lp.isHomePageLoaded(driver), "Salesforce home page is displayed.");
		test.log(Status.PASS, "Salesforce home page is displayed.");
		
		lp.logoutFromSFDC(driver);
		boolean isRememberMeSelected = lp.isRememberMeSelected();
		Assert.assertTrue(lp.isLoginPageOpen(driver), "Verify login page.");
		test.log(Status.PASS, "SFDC login page is loaded with "+lp.getSavedUser()+" populated and remember user checkbox " + (isRememberMeSelected ? "Checked" : "Not Checked"));
		
		Assert.assertTrue(lp.isUserSaved(driver), "Validate User name is displayed in username field");		
		test.log(Status.PASS, lp.getSavedUser()+" is displayed in username field.");
		
	}	
	
//	@Test(description = "Forget Password - 4A")
	public void forgetPassword_TC04_A() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("url"));
		Assert.assertTrue(lp.isLoginPageOpen(driver), "Login page is opended.");
		test.log(Status.PASS, "Login page is opended.");
		
		lp.clickForgetPasswordLink();
		Assert.assertTrue(lp.isForgetPasswordPage(driver), "Verify forget password page.");
		test.log(Status.PASS, "Salesforce forget password page is displayed.");
		
		lp.forgetPassword();
		Assert.assertTrue(lp.isCheckYourEmailPage(driver), "Verify Check Your Email Confirmation page");
		test.log(Status.PASS, lp.getAssociateEmailConfirmationdMsgPageTitle(driver)+" page is displayed."+lp.getAssociateEmailConfirmationdMsg());
	}
	
	
//	@Test(description = "Forget Password - 4B")
	public void forgetPassword_TC04_B() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		LoginPage lp = new LoginPage(driver);
	
		driver.get(DataUtils.readLoginTestData("url"));
		Assert.assertTrue(lp.isLoginPageOpen(driver), "Login page is loaded.");
		test.log(Status.PASS, "SFDC Login page is loaded.");
		
		lp.enterWrongUserName();
		boolean isUserValueEntered = lp.isUserNameValueEntered(DataUtils.readLoginTestData("wrongUser"));
		Assert.assertTrue(isUserValueEntered, "Validate Username is entered.");
		test.log(Status.PASS, "Username is entered  in username field.");
		lp.enterWrongPassword();
		Assert.assertTrue(lp.isPassEntered(driver), "Validate value is entered in password field.");
		test.log(Status.PASS, "Password is entered in password field");
		lp.clickLoginButton();		
		Assert.assertTrue(lp.isErrorMessageDisplayed(), "Validating error message is displayed");
		test.log(Status.PASS, "Error message is displayed '"+lp.getErrorMessage()+"'");
		
	}
	
	@AfterMethod
	public void postCondition() {
		System.out.println("Post condition: Home Page of the app");
		BaseTest.getDriver().close();
	}
	
	

	
//	@Test
//	public void loginToSalesForce1() throws IOException {
//		//to create a report for a particular test adn pass test name
////		BaseTest.test = BaseTest.extent.createTest("loginToSalesForce1");
//		ExtentTest test = BaseTest.threadExtentText.get();
//		WebDriver driver = BaseTest.getDriver();
//		LoginPage lp = new LoginPage(driver);
//		driver.get(DataUtils.readLoginTestData("url"));
//		lp.usernameField.sendKeys(DataUtils.readLoginTestData("username"));
//		
//		//if you wan to log the locator's details in the report use
//		test.log(Status.INFO, "Uesrname is entered");
//		
//		lp.passwordField.sendKeys(DataUtils.readLoginTestData("password"));
//		test.log(Status.INFO, "Password is entered");
//		
//		//CommonUtils.CaptureScreenShots(driver);
//		lp.loginButton.click();
//		///throw new NoSuchElementException(); //to take screenshot for fail test
//		test.log(Status.INFO, "Login button is clicked.");
//	}
//	@Test
//	public void loginToSalesForce2() throws IOException {
//		//to create a report for a particular test adn pass test name
////		BaseTest.test = BaseTest.extent.createTest("loginToSalesForce2");
//		ExtentTest test = BaseTest.threadExtentText.get();
//		WebDriver driver = BaseTest.getDriver();
//		LoginPage lp = new LoginPage(driver);
//		driver.get(DataUtils.readLoginTestData("url"));
//		lp.usernameField.sendKeys(DataUtils.readLoginTestData("username"));
//		
//		//if you wan to log the locator's details in the report use
//		test.log(Status.INFO, "Uesrname is entered");
//		
//		lp.passwordField.sendKeys(DataUtils.readLoginTestData("password"));
//		test.log(Status.INFO, "Password is entered");
//		
//		//CommonUtils.CaptureScreenShots(driver);
//		lp.loginButton.click();
//		
//		test.pass("loginToSalesForce2");			
//	}
	
	

}
