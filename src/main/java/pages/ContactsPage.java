package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DataUtils;
import utils.WaitUtils;
import utils.WebElementUtils;


public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Contact_Tab")
	public WebElement contactsTab;
	
	@FindBy(xpath = "//input[@value=' New ']")
	public WebElement newBtn;
	
	@FindBy(id = "name_lastcon2")
	public WebElement lastName;
	
	@FindBy(id = "con4")
	public WebElement accountName;
	
	@FindBy(xpath = "//a[@id='con4_lkwgt']/img")
	public WebElement accountNamePicker;
	
	@FindBy(id = "con5")
	public WebElement titleElement;
	
	@FindBy(xpath = "//td[@id='topButtonRow']/input[@value=' Save ']")
	public WebElement saveButton;
	
	@FindBy(id="searchFrame")
	public WebElement searchFrame;
	@FindBy(id = "lksrch")
	public WebElement searchInput;
	@FindBy(xpath = "//div[@class='pBody']/input[@value=' Go! ']")
	public WebElement goBtn;	
	@FindBy(id="resultsFrame")
	public WebElement searchResult;
	
	@FindBy(xpath = "//table[@class='list']")
	public WebElement tableElement;
	
	@FindBy(xpath = "//table[@class='list']")
	public WebElement tableElement1;

	@FindBy(xpath = "//a[text()='Create New View']")
	public WebElement createNewViewLink;
	@FindBy(id = "fname")
	public WebElement viewNameField;
	
	@FindBy(id = "devname")
	public WebElement viewUniqueNameField;
	
	@FindBy(xpath = "//select[@name='fcf']/option[@selected]")
	public WebElement selectedViewOption;

	@FindBy(xpath = "//div[@class='pbHeader']/table/tbody/tr/td[@class='pbButtonb']/input[1]")
	public WebElement saveNewContactBtn;
	
	@FindBy(id = "hotlist_mode")
	public WebElement displaySelection; 
	
	@FindBy(id = "fcf")
	public WebElement viewDropdown; 
	
	@FindBy(xpath = "//h2[@class='topName']")
	public WebElement selectedFirstContact; 
	
	@FindBy(xpath = "//div[@class='requiredInput']/div[@class='errorMsg']")
	public WebElement errorMsgViewName; 
	
	@FindBy(xpath = "//div[@class='pbHeader']/table/tbody/tr/td[@class='pbButtonb']/input[2]")
	public WebElement cancelBtn; 
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']/input[@value='Save & New']")
	public WebElement saveAndNew; 
	
	
	public void getContactTab(WebDriver driver) {
		WaitUtils.waitForElement(driver, contactsTab);
		contactsTab.click();
	}

	public boolean isContactsHomePage(WebDriver driver) throws IOException {
		boolean isContactsHomePage = false;
		String actualT = driver.getTitle();
		String expectedT = DataUtils.readLoginTestData("contactsHomePageTitle");
		
		if(actualT.equals(expectedT)) {
			isContactsHomePage = true;
			logger.info("Contacts Home page is loaded");
		}else {
			isContactsHomePage = false;
			System.out.print(isContactsHomePage);
			logger.info("Can not load Contacts Home page");
		}
		return isContactsHomePage;
	}

	public void newBtnClick(WebDriver driver) {
	newBtn.click();		
	}
	public boolean isNewContactHomePage(WebDriver driver) throws IOException {
		boolean isNewContactsHomePage = false;
		String actual = driver.getTitle();
		System.out.println("actual New contact Title: "+actual);
		String expected = DataUtils.readLoginTestData("newContactHomePageTitle");
		System.out.println("expexted New contact Title: "+expected);
		if(actual.equals(expected)) {
			isNewContactsHomePage = true;
			logger.info("New Contact Home page is loaded");
		}else {
			isNewContactsHomePage = false;
			logger.info("Can not load New Contact Home page");
		}
		return isNewContactsHomePage;
	}
	public void getAccountName(WebDriver driver, WebElement ele) throws IOException {
		ele.click();
		WebElementUtils.clickAndSwitchToNewWindow(driver, accountNamePicker);
		driver.switchTo().frame(searchFrame);
		searchInput.sendKeys("a");
		goBtn.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(searchResult);
		WebElementUtils.selectFirstCellInTable(driver, tableElement);
	}
	public void newContactEditDetails(WebDriver driver) throws IOException {
		lastName.sendKeys(DataUtils.readLoginTestData("newContacLastName"));
		String mainWindowHandle = driver.getWindowHandle();
		getAccountName(driver, accountNamePicker);
		driver.switchTo().window(mainWindowHandle);
	}
	public void saveButton(WebDriver driver) {
		saveButton.click();		
	}
	public boolean isLastNameFieldEntered(WebDriver driver) throws IOException {
		boolean isLastNameEntered =false;
		String actual = lastName.getAttribute("value");		
		String expected = DataUtils.readLoginTestData("newContacLastName");		
		if(actual.equals(expected)) {
			isLastNameEntered = true;
		}else {
			isLastNameEntered = false;
		}
		return isLastNameEntered;
	}
	public boolean isAccountsNameFieldEntered(WebDriver driver) throws IOException {
		boolean isAccountsNameFieldEntered =false;
		String actual = accountName.getAttribute("value");
		if(!actual.isEmpty()) {
			isAccountsNameFieldEntered = true;
		}else {
			isAccountsNameFieldEntered = false;
		}
		return isAccountsNameFieldEntered;
	}

	public boolean isNewContactSaved(WebDriver driver) throws IOException {
		boolean isNewContactSaved= false;
		String actual = driver.getTitle();
		String expected = "Contact: "+DataUtils.readLoginTestData("newContacLastName")+" ~ Salesforce - Developer Edition";
		if(!actual.isEmpty() && !expected.isEmpty() && actual.equals(expected)) {
			isNewContactSaved = true;
		}else {
			isNewContactSaved = false;
		}
		return isNewContactSaved;
	}

	public void getCreateNewViewLink(WebDriver driver) {
		createNewViewLink.click();
	}
	public boolean isCreateNewViewPage(WebDriver driver) throws IOException {
		boolean isCreateNewViewPage= false;
		String actual = driver.getTitle();
		String expected =DataUtils.readLoginTestData("isCreateNewViewPageTitle");
		if(!actual.isEmpty() && !expected.isEmpty() && actual.equals(expected)) {
			isCreateNewViewPage = true;
			logger.info("Create New View page is loaded.");
		}else {
			isCreateNewViewPage = false;
			logger.info("Can not load Create New View page.");
		}
		return isCreateNewViewPage;
	}

	public void createNewView(WebDriver driver) throws IOException {
		viewNameField.sendKeys(DataUtils.readLoginTestData("contactViewName"));	
		viewUniqueNameField.click();	
		logger.info("View Unique Name is created");
	}
	
	public void createNewViewUniqueNameError(WebDriver driver) throws IOException {
		viewUniqueNameField.sendKeys(DataUtils.readLoginTestData("viewUniqueName"));		
	}
	public String getCreateNewViewUniqueName(WebDriver driver) throws IOException {
		return DataUtils.readLoginTestData("viewUniqueName");		
	}
	
	public String getViewName(WebDriver driver) throws IOException {
		return DataUtils.readLoginTestData("viewName");		
	}
	
	public boolean isViewNameEntered(WebDriver driver) {
		boolean isViewNameEntered = false;
		String viewName = viewNameField.getAttribute("value");
		if(!viewName.isEmpty()) {
			 isViewNameEntered = true;
			 logger.info("View Name is entered");
		}else {
			isViewNameEntered = false;
			logger.info("Can not enter View Name");
		}
		return isViewNameEntered;
	}

	public boolean isViewUniqueNameEntered(WebDriver driver) {
		
		boolean isViewUniqueNameEntered = false;
		String viewUniqueName = viewUniqueNameField.getAttribute("value");
		if(!viewUniqueName.isEmpty()) {
			isViewUniqueNameEntered = true;
			logger.info("View Unique Name is Created");
		}else {
			isViewUniqueNameEntered = false;
			logger.info("Can not enter View Name");
		}
		return isViewUniqueNameEntered;
	}
	
	public void saveNewContactBtn(WebDriver driver) {
		saveNewContactBtn.click();		
	}
	
	public boolean isUniqueNameError(WebDriver driver) {
		boolean isErrorDisplayed = false;
//		String viewUniqueName = errorMsgViewName
		if(errorMsgViewName.isDisplayed()) {
			isErrorDisplayed = true;
			logger.info("Error message is displayed under View Name");
		}else {
			isErrorDisplayed = false;
			logger.info("Can not show Error message is displayed under View Name");
		}
		return isErrorDisplayed;		
	}
	public String getErrorMsg(WebDriver driver) {
		return errorMsgViewName.getText();
	}
	
	public boolean isContactsHomeAndDefaultViewDisplayed(WebDriver driver) throws IOException {
		boolean isContactsHomeAndDefaultViewDisplayed = false;
		String newlyCreatedviewName = DataUtils.readLoginTestData("contactViewName");
		if(isContactsListPageTitle(driver)) {
			String actualSelected = selectedViewOption.getText();
			System.out.println("Actual selected view: "+actualSelected);
			if(actualSelected.equals(newlyCreatedviewName)) {
				isContactsHomeAndDefaultViewDisplayed = true;
				logger.info("Contacts Home Page is Open. Created view '"+newlyCreatedviewName+"' is displaed in drop down as default.");
			}else {
				isContactsHomeAndDefaultViewDisplayed =false;
				logger.info("Can not load Contacts Home Page with newly created view.");
			}
		}
		return isContactsHomeAndDefaultViewDisplayed;
	}
	
	public boolean isContactsListPageTitle(WebDriver driver) throws IOException {
		
		boolean isContactsListPageTitle = false;
		String actual = driver.getTitle();
		String exp = DataUtils.readLoginTestData("contactsListPageTitle");
		if(actual.equals(exp)) {
			isContactsListPageTitle = true;
			logger.info("Contacts List page displayed");
		}else {
			isContactsListPageTitle = false;
			logger.info("Can not display Contacts List page");
		}
		return isContactsListPageTitle;
	}

	public void recentlyCreated(WebDriver driver) {
		WebElementUtils.selectDropdownOption(driver, displaySelection, "Recently Created");
		
	}

	public void viewCheckForMyContacts(WebDriver driver) {
		WebElementUtils.selectDropdownOption(driver, viewDropdown, "My Contacts");		
	}
	public boolean checkSelectedView(WebDriver driver) {
		boolean selected = false;
		String actual = selectedViewOption.getText();
		String expected = "My Contacts";
		if(actual.equals(expected)) {
			selected = true;
			logger.info("Selected is '"+actual+"'");
		}else {
			selected = false;
			logger.info("Can not Selected view.");
		}
		return selected;
	}
	
//	
////	public String getContactName(WebDriver driver) {
////        // Locate the first data row (tr element)
////        WebElement firstDataRow = tableElement1.findElement(By.xpath(".//tr[2]"));
////
////        // Locate the first cell (th element) within the first data row
////        WebElement firstCell = firstDataRow.findElement(By.xpath(".//th[@scope='row']"));
////
////        // Locate the link (a element) within the first cell
////        WebElement link = firstCell.findElement(By.tagName("a"));
////
////        // Retrieve the text of the link
////        String linkText = link.getText();
////        return linkText;
////	}
	public void clickAContact(WebDriver driver) {
		WebElement firstDataRow = tableElement1.findElement(By.xpath(".//tr[2]"));

        // Locate the first cell (th element) within the first data row
        WebElement firstCell = firstDataRow.findElement(By.xpath(".//th[@scope='row']"));

        // Locate the link (a element) within the first cell
        WebElement link = firstCell.findElement(By.tagName("a"));        
        link.click();
	} 

	public boolean isSelectedContactDetailsDisplayed(WebDriver driver) throws IOException {
		boolean selected = false;
		String actualContactName = 	selectedFirstContact.getText();
		String expected = driver.getTitle();

		if(expected.contains(actualContactName)) {
			selected = true;
			logger.info("selected Contact is correct ");
		}else {
			selected = false;
			logger.info("selected Contact is not correct");
		}			
		return selected;
	}
	public String getContactName(WebDriver driver) {
		return selectedFirstContact.getText();
	}

	public void createViewForCancel(WebDriver driver) throws IOException {
		viewNameField.clear();
		try {
			viewNameField.sendKeys(DataUtils.readLoginTestData("viewNameForCancelFunction"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewUniqueNameField.clear();
		viewUniqueNameField.sendKeys(DataUtils.readLoginTestData("viewUniqueNameForCancelFunction"));	
	}

	public void cancelCreateViewCreation(WebDriver driver) {
		cancelBtn.click();
	}
	
	public String getViewNameForCancel(WebDriver driver) throws IOException {
		return DataUtils.readLoginTestData("viewNameForCancelFunction");		
	}
	

	public boolean isViewCreationCancelled(WebDriver driver) throws IOException {
		boolean isViewCreationCancelled= false;
		if(isContactsHomePage(driver)) {
			isViewCreationCancelled = true;
			logger.info("Cancel the view creation and back to Contacts Home Page");
		}else {
			isViewCreationCancelled = false;
			logger.info("Can not perform cancel");
		}
		
		return isViewCreationCancelled;
	}

	public void getAccountNameBysearchText(WebDriver driver, WebElement ele) throws IOException {
		ele.click();
		WebElementUtils.clickAndSwitchToNewWindow(driver, accountNamePicker);
		driver.switchTo().frame(searchFrame);
		searchInput.sendKeys(DataUtils.readLoginTestData("acccountSearchText"));
		goBtn.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(searchResult);
		WebElementUtils.selectFirstCellInTable(driver, tableElement);
	}
	public void newContactDetails(WebDriver driver) throws IOException {
		lastName.sendKeys(DataUtils.readLoginTestData("newContacLastNameForSaveAndNew"));
		String mainWindowHandle = driver.getWindowHandle();
		getAccountNameBysearchText(driver, accountNamePicker);
		driver.switchTo().window(mainWindowHandle);
	}
	public boolean isLastNameFieldEntered1(WebDriver driver) throws IOException {
		boolean isLastNameEntered =false;
		String actual = lastName.getAttribute("value");		
		String expected = DataUtils.readLoginTestData("newContacLastNameForSaveAndNew");		
		if(actual.equals(expected)) {
			isLastNameEntered = true;
		}else {
			isLastNameEntered = false;
		}
		return isLastNameEntered;
	}
	
	public void saveAndNewAction(WebDriver driver) {
		saveAndNew.click();		
	}

}
