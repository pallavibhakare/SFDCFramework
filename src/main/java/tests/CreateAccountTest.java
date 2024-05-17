package tests;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import constants.WaitConstants;
import listeners.TestListener;
import pages.CreateAccountPage;
import pages.LoginPage;
import utils.DataUtils;

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
		LoginPage lp = new LoginPage(driver);
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.launchAndLoginToApplication(driver);
		
		String loggedUserName = lp.userMenu.getText();		
		test.log(Status.INFO, "SalesForce login page is launched and application home page is logged in with username "+loggedUserName);
			
		cap.accountsLink.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = DataUtils.readLoginTestData("accountsHomePageTitle");
		Assert.assertEquals(actualTitle, expectedTitle, "Verify Account Home");
		test.log(Status.INFO, "Accounts page is displayed with usename "+loggedUserName);
		
		cap.accountsLink.click();
		Assert.assertTrue(cap.isNewAccountEditPage(driver), "Verify New Account Edit page");
		cap.editNewAccount(driver);
		
		String actualNewTitle = driver.getTitle();
		String expectedNewPageTitle = "Account: "+cap.topName.getText()+" ~ Salesforce - Developer Edition";
		Assert.assertEquals(actualNewTitle, expectedNewPageTitle, "Verify New account page");
		test.log(Status.INFO, "New account page is displayed with account details.");
	}
	
//	@Test
	public void createNewView_TC11() throws IOException {
	
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		LoginPage lp = new LoginPage(driver);
		CreateAccountPage cap = new CreateAccountPage(driver);
		
		cap.launchAndLoginToApplication(driver);
	    Assert.assertTrue(lp.isHomePageLoaded(driver), "Verify home page is loaded");		
		String loggedUserName = lp.userMenu.getText();	
		test.log(Status.INFO, "SalesForce login page is launched and application home page is logged in with username "+loggedUserName);
		
		cap.accountsLink.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = DataUtils.readLoginTestData("accountsHomePageTitle");
		Assert.assertEquals(actualTitle, expectedTitle, "Verify Account Home");
		test.log(Status.INFO, "Accounts page is displayed with usename "+loggedUserName);
		
		cap.createNewView(driver);
		Assert.assertTrue(cap.isAccountsViewPage(driver), "Verify Accounts view page is displayed.");
		test.log(Status.INFO, "Accounts Page Is displayed");
		Assert.assertTrue(cap.isNewViewDisplayed(driver), "Verify newly added view is Visible.");
		test.log(Status.INFO, "Newly added view is displayed in the account view list.");
	}
	@Test
	public void editView_TC12() throws IOException {
		test = BaseTest.threadExtentText.get();
		driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		LoginPage lp = new LoginPage(driver);
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.launchAndLoginToApplication(driver);
		String loggedUserName = lp.userMenu.getText();		
		test.log(Status.INFO, "SalesForce login page is launched and application home page is logged in with username "+loggedUserName);			
		cap.accountsLink.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = DataUtils.readLoginTestData("accountsHomePageTitle");
		Assert.assertEquals(actualTitle, expectedTitle, "Verify Account Home");
		test.log(Status.INFO, "Accounts page is displayed with usename "+loggedUserName);
		
		WebElement dropDownElement = cap.accountViewListSelect;
		BaseTest.clickDropDown(dropDownElement);
		String expectedOptionToSelect = DataUtils.readLoginTestData("selectRandomViewItem");
		boolean optionSelected = BaseTest.selectDropdownOption(driver, dropDownElement, expectedOptionToSelect);
		// Verify that the option is selected successfully
        Assert.assertTrue(optionSelected, "Option '" + expectedOptionToSelect + "' selected successfully");
       
        cap.editLink.click();
        String actualEditPageTitle = driver.getTitle();
        String expectedEditPageTitle = DataUtils.readLoginTestData("accountsEditViewPageTitle");
        Assert.assertEquals(actualEditPageTitle, expectedEditPageTitle, cap.viewName.getText()+" edit page is displayed.");
        
        cap.viewName.sendKeys(DataUtils.readLoginTestData("changeViewName"));
        WebElement filterField = cap.filterField;
        String expectedFilterFieldOption = "Account Name";
        BaseTest.clickDropDown(filterField);
        boolean fieldOptionSelected = BaseTest.selectDropdownOption(driver, filterField, expectedFilterFieldOption);
        Assert.assertTrue(fieldOptionSelected, "Option '"+expectedFilterFieldOption+"' selected successfully.");
        
        WebElement filterOperator = cap.filterOperator;
        String expectedFilterOperator = "contains";
        boolean operatorOptionSelected = BaseTest.selectDropdownOption(driver, filterOperator, expectedFilterOperator);
        Assert.assertTrue(fieldOptionSelected, "Option '"+operatorOptionSelected+"' slected successfully.");
        
       cap.filterValue.sendKeys("a");
       String expetedValueToEnter = "a";
       String actualValueEntered = cap.filterValue.getAttribute("value");
       Assert.assertEquals(actualValueEntered, expetedValueToEnter, "Value in the value field is not expected.");
       
       cap.Save.click();
	}
	@AfterMethod
	public void postCondition() {
		System.out.println("Post condition: Home Page of the app");
//		BaseTest.getDriver().close();
	}
}
