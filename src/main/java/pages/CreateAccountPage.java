package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DataUtils;

public class CreateAccountPage extends BasePage{

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[@class='topName']")
	public WebElement topName;
	@FindBy(xpath = "//li[@id='Account_Tab']")
	public WebElement accountsLink;
	
	@FindBy(xpath = "//input[contains(@value, ' New ')]")
	public WebElement newButton;
	
	@FindBy(xpath = "//td[contains(@class, 'col02')]/div[contains(@class, 'requiredInput')]/input[contains(@id, 'acc2')]")
	public WebElement accountName;
	
	@FindBy(xpath = "//select[contains(@id, 'acc6')]")
	public WebElement type;
	
	@FindBy(xpath = "//select[contains(@id, 'acc6')]/option")
	public WebElement typeOptions;
	
	
	@FindBy(xpath = "//select[contains(@id, '00Naj000001j46z')]")
	public WebElement customerPriority;
	
	
	@FindBy(xpath = "//input[contains(@tabindex, '34')]")
	public WebElement saveButton;
	
	//Create New View
	@FindBy(xpath = "//a[contains(text(), 'Create New View')]")
	public WebElement createNewViewLink;
	
	@FindBy(xpath = "//input[@id='fname']")
	public WebElement viewName;
	
	@FindBy(xpath = "//input[contains(@id, 'devname')]")
	public WebElement viewUniqueName;
	
	@FindBy(xpath = "//div[contains(@class, 'pbBottomButtons')]/table/tbody/tr/td/input[contains(@value, ' Save ')]")
	public WebElement saveViewButton;
	
	@FindBy(xpath = "//div[@class='controls']/select/option[@selected='selected']")
	public WebElement newlyAccountViewInList;
	
	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement accountViewListSelect;
	
	@FindBy(xpath = "//select[@id='fcf']/option")
	public WebElement accountViewListSelectOption;
	
	@FindBy(xpath = "//*[@id='00Baj000007GEiv_filterLinks']/a[1]")
	public WebElement editLink;
	
	@FindBy(id = "fcol1")
	public WebElement filterField;
	
	@FindBy(id = "fop1")
	public WebElement filterOperator;

	@FindBy(xpath = "fval1")
	public WebElement filterValue;
	
	@FindBy(xpath = "//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]")
	public WebElement Save;
	
	public void launchAndLoginToApplication(WebDriver driver) throws IOException {
		LoginPage lp = new LoginPage(driver);
		String url = DataUtils.readLoginTestData("url");
		String userName = DataUtils.readLoginTestData("username");
		String password = DataUtils.readLoginTestData("password");
		driver.get(url);
		logger.info("Salesforce login page is launched and application");
		lp.loginToSFDC(driver);		
		lp.isHomePageLoaded(driver);
		logger.info("Home page is displayed.");		
	}
	public boolean isNewAccountEditPage(WebDriver driver) throws IOException {
		
		newButton.click();
		boolean isNewAccountPage =false;
		String extectedTitle = DataUtils.readLoginTestData("accountEditForNewAccountPageTitle");
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(extectedTitle)) {
			isNewAccountPage = true;		
		}else {
			isNewAccountPage = false;
		}
		return isNewAccountPage;
	}
	public void selectDropDown(WebDriver driver, WebElement dropdownId ,String optionValue  ) {
		if(dropdownId.isDisplayed()) {
			dropdownId.click();
		}
		else {
			System.out.println("Element is not displayed");
		}
	}
		
	public void editNewAccount(WebDriver driver) throws IOException {
		accountName.sendKeys(DataUtils.readLoginTestData("accountName"));
		String optionValue = "Technology Partner";
		selectDropDown(driver, type, optionValue);
		String optionValue1 = "High";
		selectDropDown(driver, customerPriority, optionValue1);
		saveButton.click();
	}
	public void createNewView(WebDriver driver) throws IOException {
		
		createNewViewLink.click();
		viewName.clear();
		viewName.sendKeys(DataUtils.readLoginTestData("viewName"));
		logger.info("View Name is entered");
		viewUniqueName.click();
		logger.info("Unique View Name is generated");
		saveViewButton.click();		
		logger.info("New view is saved.");
		
	}
	public boolean isAccountsViewPage(WebDriver driver) throws IOException {
		boolean isAccountsViewPage =false;
		String extectedTitle = DataUtils.readLoginTestData("accountsViewPage");
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(extectedTitle)) {
			isAccountsViewPage = true;	
			logger.info("Accounts view is displayed.");
		}else {
			isAccountsViewPage = false;
			logger.info("Can not displayed Accounts View.");
		}
		return isAccountsViewPage;		
	}
	public boolean isNewViewDisplayed(WebDriver driver) throws IOException {
		boolean isNewViewDisplayed =false;
		String extectedViewName = DataUtils.readLoginTestData("viewName");
		System.out.println("expected "+extectedViewName);
		String actualViewName = newlyAccountViewInList.getText();
		System.out.println("actualViewName "+actualViewName);
		if(actualViewName.equals(extectedViewName)) {
			isNewViewDisplayed = true;	
			logger.info("View name is displayed in the account view list.");
		}else {
			isNewViewDisplayed = false;
			logger.info("Can not displayed View name in Account view  list");
		}
		return isNewViewDisplayed;
		
	}
	
}
