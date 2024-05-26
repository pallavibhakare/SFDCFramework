package pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tests.BaseTest;
import utils.DataUtils;
import utils.WebElementUtils;

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
	
	@FindBy (xpath = "//div[@class='topNav primaryPalette']/div/select/option[@selected='selected']")
	public WebElement SelectedViewName;
	
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
	
	@FindBy(xpath = "//*[@class='filterLinks']/a[1]")
	public WebElement editLink;
	
	@FindBy(id = "fcol1")
	public WebElement filterField;
	
	@FindBy(id = "fop1")
	public WebElement filterOperator;

	@FindBy(id = "fval1")
	public WebElement filterValue1;
	
	@FindBy(xpath = "//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]")
	public WebElement Save;
	
	@FindBy(xpath = "//span/a[contains(text(), 'Merge Accounts')]")
	public WebElement mergeAccountsLink;
	
	@FindBy(id = "srch")
	public WebElement findAccountsInput;
	
	@FindBy(xpath = "//div[@class='pbWizardBody']/input[@class='btn']")
	public WebElement findAccountsButton;
	
	@FindBy(xpath = "//tbody//th/input[@type='checkbox']")
	public WebElement checkboxSelect;
	
	@FindBy(xpath = "//div[@class='pbTopButtons']/input[contains(@title, 'Next')]")
	public WebElement nextButton;
	
	@FindBy(xpath = "//div[@class='pbWizardTitle tertiaryPalette brandTertiaryBgr']/h2")
	public WebElement mergeStepTwo;
	
	@FindBy(xpath = "//div[@class='pbWizardHeader']/div/input[@value=' Merge ']")
	public WebElement mergeButton;
	
	@FindBy(id = "hotlist_mode")
	public WebElement displaySelection;
	
	@FindBy(xpath = "//a[contains(text(), 'Accounts with last activity')]")
	public WebElement lastActivityReports;
	
	@FindBy(id = "ext-gen20")
	public WebElement createDateDD;
	
	@FindBy(xpath = "//div[@id='ext-gen265']/div[contains(text(), 'Created Date')]")
	public WebElement createdDate;
	
	@FindBy(id = "ext-gen264")
	public WebElement comboList;
	
	@FindBy(id = "ext-gen152")
	public WebElement fromDatePick;
		
	@FindBy(id = "ext-comp-1042")
	public WebElement fromInput;

	@FindBy(id = "ext-gen154")
	public WebElement toDatePick;
	@FindBy(id = "ext-comp-1045")
	public WebElement toInput;
	
	@FindBy(id = "ext-comp-1057")
	public WebElement toLabel;
	
	@FindBy(id = "gridViewScrollpreviewPanelGrid")
	public WebElement accountListGrid;
	
	@FindBy(id = "ext-gen49")
	public WebElement saveReport;
	
	@FindBy(id = "saveReportDlg")
	public WebElement saveReportDialog;
	
	@FindBy(id = "saveReportDlg_reportNameField")
	public WebElement reportName;
	@FindBy(id = "saveReportDlg_DeveloperName")
	public WebElement reportUniqueName;
	@FindBy(id = "ext-comp-1067")
	public WebElement reportDesc;
	
	@FindBy(id = "ext-gen318")
	public WebElement saveButtonDlg;
	@FindBy(id = "ext-gen63")
	public WebElement runReport;
	
	public void launchAndLoginToApplication(WebDriver driver) throws IOException {
		LoginPage lp = new LoginPage(driver);
		BaseTest bt =new BaseTest();
		bt.goToUrl(driver);		
		logger.info("Salesforce login page is launched and application");
		lp.loginToSFDC(driver);		
		lp.isHomePageLoaded(driver);
		logger.info("Home page is displayed.");		
	}
	public void getAccountTab(WebDriver driver) {
		accountsLink.click();
	}
	public boolean isAccountsPageDisplayed(WebDriver driver) throws IOException {
		boolean isAccountsPageDisplayed = false;
		String actual = driver.getTitle();
		String expected = DataUtils.readLoginTestData("accountsHomePageTitle");
		if(actual.endsWith(expected)) {
			isAccountsPageDisplayed= true;
			logger.info("Accounts Page is displayed");
		}else {
			isAccountsPageDisplayed= false;
			logger.info("Can not display Accounts Page");
		}
		return isAccountsPageDisplayed;
		
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
		
	public void createNewAccount(WebDriver driver) throws IOException {
		accountName.sendKeys(DataUtils.readLoginTestData("accountName"));
		String optionValue = "Technology Partner";
		selectDropDown(driver, type, optionValue);
		String optionValue1 = "High";
		selectDropDown(driver, customerPriority, optionValue1);
		saveButton.click();
	}
	public boolean isNewAccountDetailsPage(WebDriver driver) throws IOException {
		boolean isNewAccountDetailsPage= false;
		String creatingViewerName = DataUtils.readLoginTestData("accountName");
		String expectedTitle = "Account: "+creatingViewerName+" ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			isNewAccountDetailsPage= true;
			logger.info("New Account is created");		
		}else {
			isNewAccountDetailsPage= false;
			logger.info("Can not create New account");
		}
		return isNewAccountDetailsPage;
	}
	public void createNewViewLink(WebDriver driver) throws IOException {
		
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
		String actualViewName = newlyAccountViewInList.getText();
		if(actualViewName.equals(extectedViewName)) {
			isNewViewDisplayed = true;	
			logger.info("View name is displayed in the account view list.");
		}else {
			isNewViewDisplayed = false;
			logger.info("Can not displayed View name in Account view  list");
		}
		return isNewViewDisplayed;		
	}
	
	public void selectViewNameFromViewDropdown(WebDriver driver) {
		//selectDropDown(driver, accountViewListSelect, "Alex");
		Select select = new Select(accountViewListSelect);
		List<WebElement> options = select.getOptions();
		int numberOfOptions = options.size();
		Random randomNum = new Random();
		int randomIndex = randomNum.nextInt(numberOfOptions);
		select.selectByIndex(randomIndex);
	}
	public void getEdit(WebDriver driver) {
		editLink.click();
	}
	public boolean isEditViewPage(WebDriver driver) throws IOException {
		boolean isEditViewPage =false;
		String extectedTitle = DataUtils.readLoginTestData("accountsEditViewPageTitle");
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(extectedTitle)) {
			isEditViewPage = true;	
			logger.info("Edit view page is displayed.");
		}else {
			isEditViewPage = false;
			logger.info("Can not displayed Edit View.");
		}
		return isEditViewPage;		
	}
	public String getEditViewName(WebDriver driver) {
		return viewName.getText();
	}
	public void performEditView(WebDriver driver) throws IOException {
		viewName.clear();
		viewName.sendKeys(DataUtils.readLoginTestData("newViewName"));
		BaseTest.selectDropdownOption(driver, filterField, "Account Name");
		BaseTest.selectDropdownOption(driver, filterOperator, "contains");
		filterValue1.sendKeys("a");
		saveViewButton.click();
	}
	public boolean verifyEditView(WebDriver driver) throws IOException {
		boolean verifyEditView=false;
		String actual = driver.getTitle();
		String expected = DataUtils.readLoginTestData("accountsViewPage");
		if(actual.equals(expected)) {
			String newViewName =DataUtils.readLoginTestData("newViewName");
			String testViewName =  SelectedViewName.getText();
			if(newViewName.equals(testViewName)) {
				verifyEditView=true;
				logger.info("View page with "+newViewName+" in the drop down is displayed.");
			}else {
				verifyEditView=false;
				logger.info("View page with "+newViewName+" in the drop down can not display.");
			}			
		}
		return verifyEditView;
	}
	public void mergeAccountsLink(WebDriver driver) throws IOException {
		mergeAccountsLink.click();
		findAccountsInput.sendKeys(DataUtils.readLoginTestData("mergeAccountName"));
		findAccountsButton.click();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//tbody//input[@type='checkbox']"));
		if(checkboxes.size() >= 2) {
			checkboxes.get(0).click();
			checkboxes.get(1).click();
			logger.info("Two checkboxes are selected.");
		}else {
			logger.info("Less than  two checkboxes found.");
		}
		nextButton.click();
		
	}
	public boolean isMergeStep2(WebDriver driver) throws IOException {
		boolean isMergeStep2=false;
		String actual = mergeStepTwo.getText();
		String expected = DataUtils.readLoginTestData("mergeAccountsStep2");
		if(actual.equals(expected)) {
			isMergeStep2=true;
			logger.info("Merge Account Step 2");
		}else {
			isMergeStep2=false;
			logger.info("Can not load Merge Account Step 2");
		}
		return isMergeStep2;
	}
	public void merge(WebDriver driver) {
		mergeButton.click();
		Alert alert =driver.switchTo().alert();
		alert.accept();
	}
	public boolean recentView(WebDriver driver) throws IOException {
		boolean isRecentAccountInView = false;
		BaseTest.selectDropdownOption(driver, displaySelection, "Recently Viewed");
		// Locate the first row in the tbody
        WebElement firstRow = driver.findElement(By.xpath("//tbody/tr[contains(@class, 'dataRow')][1]"));

        // Locate the <th> element in the first row
        WebElement firstCell = firstRow.findElement(By.xpath(".//th"));

        // Retrieve the text of the <th> element
        String firstCellText = firstCell.getText();
        String expected = DataUtils.readLoginTestData("mergeAccountName");
        if(firstCellText.contains(expected)) {
        	 isRecentAccountInView = true;
        	logger.info("In recently viewed view, new merged account is listed.");
        }else {
        	 isRecentAccountInView = false;
        	logger.info("new merged account is not listed.");
        }
		return isRecentAccountInView;
	}
	public void getLastActiviytReports(WebDriver driver) {
		lastActivityReports.click();
	}
	public boolean isUnsavedReportPage(WebDriver driver) throws IOException {
		boolean isUnsavedReportPage =false;
		String actualTitle = driver.getTitle();
		String expectedTitle = DataUtils.readLoginTestData("isUnsavedReportPageTitle");
		if(actualTitle.equals(expectedTitle)) {
			isUnsavedReportPage=true;
			logger.info("");
		}else {
			isUnsavedReportPage=false;
			logger.info("");
		}
		return isUnsavedReportPage;
	}
	public void selectReportOptions(WebDriver driver) {
		String todaysDate =new SimpleDateFormat("M/dd/yyyy").format(new Date());
		createDateDD.click();
		WebElementUtils.moveToElement(driver, comboList,"Date Field");
		createdDate.click();
		fromInput.clear();		
		fromDatePick.click();
		fromInput.sendKeys(todaysDate);
		toInput.clear();
		toDatePick.click();
		toInput.sendKeys(todaysDate);
		toLabel.click();
	}
	public boolean isListOfAccountsDisplayed(WebDriver driver) {
		boolean isListOfAccountsDisplayed = false;
		if(accountListGrid.isDisplayed()) {
			isListOfAccountsDisplayed = true;
			logger.info("List of records displayed");
		}else {
			isListOfAccountsDisplayed = true;
			logger.info("Can not display records");
		}
		return isListOfAccountsDisplayed;		
	}
	public void saveReports(WebDriver driver) throws IOException {
		saveReport.click();
		logger.info("Save Report Window is open.");
		WebElementUtils.getParentWindow(driver);
		WebElementUtils.switchTochildWindow(driver, saveReportDialog);
		reportName.sendKeys(DataUtils.readLoginTestData("reportName"));
		reportUniqueName.click();
		reportDesc.click();		
		saveButtonDlg.click();		
		WebElementUtils.backToParentWindow(driver);	
		runReport.click();
	}
	public String getReportName(WebDriver driver) throws IOException {
		return DataUtils.readLoginTestData("reportName");
	}
	public boolean isDetailedReportPage(WebDriver driver) throws IOException {
		boolean isDetailedReportPage = false;		
		String actualReportName = getReportName(driver)+" ~ Salesforce - Developer Edition";
		String expected = DataUtils.readLoginTestData("reportName");
		if(actualReportName.contains(expected)) {
			isDetailedReportPage = true;
			logger.info("Detailed Report page is displayed");
		}else {
			isDetailedReportPage = true;
			logger.info("Can not display detailed report page");
		}
		return isDetailedReportPage;		
	}
	
}
