package pages;

import java.util.List;
import java.util.Set;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import tests.BaseTest;
import utils.CommonUtils;
import utils.DataUtils;
import utils.WaitUtils;

public class UserMenuPage extends BasePage{
	public UserMenuPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "userNavLabel")
	public WebElement userMenu;
	
	@FindBy(id = "userNavMenu")
	public WebElement userNavMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement myProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement mySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement developersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement switchToLightningExperience;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a[4]")
	public WebElement logout;
	
	//xpaths
	@FindBy(id = "error")
	public WebElement errorMessage;

	// My profile
	@FindBy(xpath = "//div[@class='editPen']/a/img")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement editProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement aboutTab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement aboutTabLastName;
	
	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement aboutTabFirstName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement userProfilePageNameDisplay;

	// postLink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement fileLink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentPost;

	@FindBy(xpath = "//td[@id='chatterUploadFileActionPanel']/a")
	public WebElement uploadFile;

	@FindBy(xpath = "//input[@id='chatterFile']")
	public WebElement fileOpen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photoLink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadPhoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadButton;

	@FindBy(id = "publishersharebutton")
	public WebElement photoSharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personalLink;
	
	@FindBy(xpath = "//div[@class='setupLeaf']/a/span")
	public WebElement personalSettingOptions;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement downloadLoginHistoryLink;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement displayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement customizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement availableTab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	@FindBy(id = "duel_select_1")
	public WebElement selectedTabs;
	// Emaillink

	@FindBy(xpath = "//span[@id='EmailSetup_font']")
	public WebElement emailTab;

	@FindBy(id = "EmailSettings_font")
	public WebElement myEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement emailName;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement emailAddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement bccRadiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement saveOnEmail;
	
	@FindBy(xpath = "//div[@class='messageText']")
	public WebElement emailSettingsConfirmation;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement calendarAndRemindersTab;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement activityRemainder;

	@FindBy(id = "testbtn")
	public WebElement openaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement sampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;
	
	public String getUserName(WebDriver driver) {
		return userMenu.getText();
	}
	public void getPersonalLink(WebDriver driver) {
		personalLink.click();
	}
	public void getLoginHistory(WebDriver driver) {
		downloadLoginHistoryLink.click();
	}
	public void getCustomizeMyTab(WebDriver driver) {
		customizedTab.click();
	}
	public WebElement getCustomeApp() {
		return customApp;
	}
	public WebElement getAvailableTab() {
		return availableTab;
	}
	public WebElement getAddButton() {
		return Add;
	}
	
	public void selectUserMenu() {
		if(userMenu.isDisplayed()) {
			userMenu.click();
		}
		else {
			System.out.println("Element is not displayed");
		}
	}
	
	public void PerformCustomizeMyTabOperation(WebDriver driver) {
		getCustomizeMyTab(driver);
		customApp.click();
		selectCustomAppOption(driver, "Salesforce Chatter");			
		BaseTest.selectDropdownOption(driver, availableTab, "Reports");
		Add.click();
	}
	
	public boolean checkReportsOption(WebDriver driver) {
		//WebElement selectedTabs;		
		Select select = new Select(selectedTabs);
		boolean isReportsOptionPresent= select.getOptions().stream().anyMatch(option->"Reports".equals(option.getText()));
		if(isReportsOptionPresent) {
			logger.info("The 'Reports' option is present.");
		}else {
			logger.info("The 'Reports' option is not present.");
		}
		return isReportsOptionPresent;
	}
	
	public void getEmailTab(WebDriver driver) {		
		emailTab.click();
		selectEmailTabOptions(driver, "My Email Settings");
	}
	public boolean selectEmailTabOptions(WebDriver driver, String option) {
		boolean isOptionSelected = false;
		logger.debug("Selecting Settings: " +option+ " option.");
		WebElement personalOption = driver.findElement(By.xpath("//span[text()='"+ option+"']"));
		if(WaitUtils.waitForElement(driver, personalOption)) {
			logger.debug(option+ " was visible");
			personalOption.click();
			logger.debug(option+ " was clicked");
			isOptionSelected = true;
		}else {
			System.out.println(option+" option is not displayed.");
			logger.debug(option+ " Cound not be selected");
		}
		
		return isOptionSelected;
	}
	public void performMyEmailSettings(WebDriver driver) throws IOException {
		emailName.clear();
		emailName.sendKeys(DataUtils.readLoginTestData("emailName"));
		emailAddress.clear();
		emailAddress.sendKeys(DataUtils.readLoginTestData("emailAddress"));
		bccRadiobutton.click();
		saveOnEmail.click();
	}
	public boolean isEmailSettingsSaved(WebDriver driver) throws IOException {
		boolean isEmailSettingsSaved = false;
		if(driver.getTitle().equals(DataUtils.readLoginTestData("emailSettingsPageTitle")) && emailSettingsConfirmation.isDisplayed()) {
			isEmailSettingsSaved =true;
			logger.info(" Given details are saved as default mail options and My Settings Page is displayed.");
			
		}else {
			isEmailSettingsSaved = false;
			logger.info("Can not save Email Settings.");
		}
		return isEmailSettingsSaved;
	}
	public void getCalenderAndRemindersTab(WebDriver driver) {
		calendarAndRemindersTab.click();
		selectCalenderAndRemindersTabOptions(driver, "Activity Reminders");
	}
	public boolean selectCalenderAndRemindersTabOptions(WebDriver driver, String option) {
		boolean isOptionSelected = false;
		logger.debug("Selecting Settings: " +option+ " option.");
		WebElement personalOption = driver.findElement(By.xpath("//span[text()='"+ option+"']"));
		if(WaitUtils.waitForElement(driver, personalOption)) {
			logger.debug(option+ " was visible");
			personalOption.click();
			logger.debug(option+ " was clicked");
			isOptionSelected = true;
		}else {
			System.out.println(option+" option is not displayed.");
			logger.debug(option+ " Cound not be selected");
		}
		
		return isOptionSelected;
	}
	public boolean isTestActivityReminderOpen(WebDriver driver) throws IOException {
		boolean isTestActivityReminderOpen= false;
		openaTestRemainder.click();
		String actualReminderPage = driver.getTitle();
		String expectedReminderPage = DataUtils.readLoginTestData("reminderPageTitle");
		if(actualReminderPage.endsWith(expectedReminderPage)) {
			isTestActivityReminderOpen= true;
			logger.info("Sample event pop up window is displayed");
		}else {
			isTestActivityReminderOpen= false;
			logger.info("Can not display Sample event pop up.");
		}
		return isTestActivityReminderOpen;
	}
	public boolean selectCustomAppOption(WebDriver driver, String option) {
		boolean isOptionSelected = false;
		logger.debug("Selecting custom App: '" +option+ "' option.");
		driver.findElement(By.xpath("//a[text()='"+ option+"']"));
		logger.debug(option+ " is selcted");		
		return isOptionSelected;
	}
	
	public boolean isUserMenuVisible() {
		boolean isUserMenuVisible=false;
		if(userNavMenu.isDisplayed()) {
			isUserMenuVisible=true;
		}else {
			isUserMenuVisible=false;
		}
		return isUserMenuVisible;
		
	}
	public boolean isUserProfilePage(WebDriver driver) {
		boolean isUserProfilePage=false;
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "User: "+getUserName(driver)+" ~ Salesforce - Developer Edition";		
		if(actualPageTitle.equals(expectedPageTitle)) {
			isUserProfilePage=true;
		}else {
			isUserProfilePage=false;
		}
		return isUserProfilePage;
		
	}
	public boolean isMySettingsPage(WebDriver driver) {
		boolean isUserProfilePage=false;
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "Hello, "+userMenu.getText()+"! ~ Salesforce - Developer Edition";	
		if(actualPageTitle.equals(expectedPageTitle)) {
			isUserProfilePage=true;
		}else {
			isUserProfilePage=false;
		}
		return isUserProfilePage;
		
	}
	
	public List<String> getUserMenuOptionNames(){
		List<String> optionNames = new ArrayList<>();
		for(WebElement option: userMenuOptions) {
			optionNames.add(option.getText());
		}
		return optionNames;
	}
	
	public boolean selectUserMenuOption(WebDriver driver, String option) {
		boolean isOptionVerified = false;
		logger.debug("Selecting an user menu option: " +option);
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='"+ option+"']"));
		if(WaitUtils.waitForElement(driver, userMenuOption)) {
			logger.debug(option+ " was visible");
			userMenuOption.click();
			logger.debug(option+ " was clicked");
			isOptionVerified = true;
		}else {
			System.out.println(option+" option is not displayed.");
			logger.debug(option+ " Cound not be selected");
		}
		
		return isOptionVerified;
	}
	public boolean isUserMenuOptionsLoaded() {
		boolean isUserMenuOptionsLoaded=false;
		
		List<String>  actualOptionNames = getUserMenuOptionNames();
		List<String> expectedOptionNames = Arrays.asList("My Profile", "My Settings","Developer Console","Switch to Lightning Experience","Logout");				
		if(actualOptionNames.equals(expectedOptionNames)) {
			isUserMenuOptionsLoaded=true;			
		}else {
			isUserMenuOptionsLoaded=false;
		}
		return isUserMenuOptionsLoaded;
		
	}
	
	public void selectEditIcon(WebDriver driver) {
		if(WaitUtils.waitForElement(driver, editContactButton)) {
			editContactButton.click();
		}else {
			System.out.println("Edit contact button is not visible");
		}
	}
	public boolean isEditContactIframe(WebDriver driver) {
		boolean isIframeLoaded = false;
		if(WaitUtils.waitForElement(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);
			if(aboutTab.isDisplayed() && contactTab.isDisplayed()) {
				isIframeLoaded = true;			
			}else {
				System.out.println("Can not switch to iframe");
			}
		}
		return isIframeLoaded;
	}
	public boolean verifyLastNameChangeInAboutTab(WebDriver driver) throws IOException {
		String lastName = DataUtils.readLoginTestData("updateLastName");
		boolean isLastNameChanged = false;
		if(aboutTab.isDisplayed()) {
			aboutTab.click();
			aboutTabLastName.clear();
			aboutTabLastName.sendKeys(lastName);
			saveAllButton.click();
			driver.switchTo().parentFrame();
		}
		if(userProfilePageNameDisplay.isDisplayed()) {
			String actualName = userProfilePageNameDisplay.getText();
			if(actualName.contains(lastName)) {
				isLastNameChanged = true;
			}else {
				System.out.println("Can not change last name.");
			}
		}
		return isLastNameChanged;
	}
	
	public boolean isFocusAtFirstNameField(WebDriver driver) throws IOException {
		
		boolean isFocusAtFirstNameFields = false;
		if(aboutTab.isDisplayed()) {
			aboutTab.click();
			aboutTabFirstName.click();
			WebElement activeElement = driver.switchTo().activeElement();
			if (aboutTabFirstName.equals(activeElement)) {
				isFocusAtFirstNameFields = true;
                logger.info("The focus is on the First Name field.");
            } else {
            	isFocusAtFirstNameFields = false;
            	logger.info("The focus is not on the First Name field.");
            }
		}
		return isFocusAtFirstNameFields;
	}
	
	public void changeLastNameAndSaveAll(WebDriver driver) throws IOException {
		
		String lastName =DataUtils.readLoginTestData("lastNameAsAbcd");
		aboutTabLastName.clear();
		aboutTabLastName.sendKeys(lastName);
		saveAllButton.click();
		driver.switchTo().parentFrame();	
	}
	public boolean isLastNameUpdatedInUsermenu(WebDriver driver) throws IOException {
		String lastNameUpdate = DataUtils.readLoginTestData("lastNameAsAbcd");
		boolean isLastNameUpdated = false;
		if(userMenu.isDisplayed()) {
			String userName = getUserName(driver);
			if(userName.contains(lastNameUpdate)) {				
				isLastNameUpdated = true;
				logger.info("Last Name is Updated in Usermenu");
			}else {
				isLastNameUpdated= false;
				logger.info("Can not update Last Name in Usermenu");
			}
		}
		return isLastNameUpdated;
	}
	
	public boolean isLastNameUpdatedInBreadCrumb(WebDriver driver) throws IOException {
		
		String lastNameUpdate = DataUtils.readLoginTestData("lastNameAsAbcd");
		boolean isLastNameUpdated = false;
		if(userProfilePageNameDisplay.isDisplayed()) {
			String breadCrumbName =userProfilePageNameDisplay.getText();
			if(breadCrumbName.contains(lastNameUpdate)) {				
				isLastNameUpdated = true;
				logger.info("Last Name is Updated in BreadCrumb");
			}else {
				isLastNameUpdated= false;
				logger.info("Can not update Last Name in BreadCrumb");
			}
		}
		return isLastNameUpdated;
	}
	public boolean isLastNameUpdatedInPageTitle(WebDriver driver) throws IOException {
		
		String lastNameUpdate = DataUtils.readLoginTestData("lastNameAsAbcd");
		boolean isLastNameUpdated = false;
		if(userProfilePageNameDisplay.isDisplayed()) {
			String pageTitle = "User: "+getUserName(driver)+" ~ Salesforce - Developer Edition";
			if(pageTitle.contains(lastNameUpdate)) {				
				isLastNameUpdated = true;
				logger.info("Last Name is Updated in Page Title");
			}else {
				isLastNameUpdated= false;
				logger.info("Can not update Last Name in Page Title");
			}
		}
		return isLastNameUpdated;
	}
	
	public boolean veriyfyCreatePost(WebDriver driver) throws IOException {
		String message = DataUtils.readLoginTestData("createPostContent");
		boolean isPostCreated = false;
		if(postLink.isDisplayed()) {
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message);
			driver.switchTo().defaultContent();
			if(shareButton.isDisplayed()) {
				shareButton.click();
				isPostCreated = true;
			}else {
				System.out.println("Post is not created.");
			}
		}
		return isPostCreated;
	}

	public boolean verifyFileUpload(WebDriver driver) throws InterruptedException{
		String filePath = FileConstants.FILE_PATH;
		boolean isFileUploadSuccess = false;
		if(WaitUtils.waitForElement(driver, fileLink)) {
			fileLink.click();
			if(WaitUtils.waitForElement(driver, uploadFile)) {			
				uploadFile.click();
			}
			if(WaitUtils.waitForElement(driver, fileOpen)) {
				
				fileOpen.sendKeys(filePath);
				shareButton.click();
				
				if(WaitUtils.waitForElementToDisappear(driver, cancelUpload)) {
					if(verifyFilePostElement.isDisplayed()) {
						isFileUploadSuccess = true;
					}
				}
			}
		}
		return isFileUploadSuccess;
		
	}

	public void clickOnUpdatePhotoButton(WebDriver driver) {
		CommonUtils.mouseHover(driver, moderatorButton);
		if(updateButton.isDisplayed()) {
			updateButton.click();
		}
	}	
	public boolean verifyPhotoUpload(WebDriver driver) {
		String imageFilePath= FileConstants.IMAGE_PATH;
		boolean isPhotoUploadedSuccess =false;
		this.clickOnUpdatePhotoButton(driver);
		
		WaitUtils.waitForElement(driver,photoUploadIframe);	    
		driver.switchTo().frame(photoUploadIframe);
		
		if(WaitUtils.waitForElement(driver, uploadPhoto)) {
			uploadPhoto.sendKeys(imageFilePath);
			photoSaveButton.click();
		}
		if(WaitUtils.waitForElementToDisappear(driver, spinnerIcon)
				&& WaitUtils.waitForElement(driver, photoSaveButton2)) {
			photoSaveButton2.click();
			if(WaitUtils.waitForElementToDisappear(driver, spinnerWhileCropping)) {
				isPhotoUploadedSuccess = true;
			}
		}
		driver.switchTo().parentFrame();
		return isPhotoUploadedSuccess;
	}

	public boolean selectOption(WebDriver driver, String option) {
		boolean isOptionSelected = false;
		logger.debug("Selecting Settings: " +option+ " option.");
		WebElement personalOption = driver.findElement(By.xpath("//*[text()='"+ option+"']"));
		if(WaitUtils.waitForElement(driver, personalOption)) {
			logger.debug(option+ " was visible");
			personalOption.click();
			logger.debug(option+ " was clicked");
			isOptionSelected = true;
		}else {
			System.out.println(option+" option is not displayed.");
			logger.debug(option+ " Cound not be selected");
		}
		
		return isOptionSelected;
	}
	public void switchToNewWindow(WebDriver driver, String parentWindow) {
		//current window handle i.e parent window
//		String parentWindow = driver.getWindowHandle();
		
		//Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		//iterate through all handles
		for(String windowHandle: allWindowHandles) {
			//if handle is not the current window
			if(!windowHandle.equals(parentWindow)) {
				//switch to new window
				driver.switchTo().window(windowHandle);
				break;	//break out of the loop after switching
			}
		}
	}	
	public boolean isDevConsoleOpen(WebDriver driver) throws IOException {
		boolean isDevConsoleOpen=false;
		String actualConsoleTitle = driver.getTitle();
		String expectedDevConsoleTitle = DataUtils.readLoginTestData("developerConsolePageTitle");
		if(actualConsoleTitle.equals(expectedDevConsoleTitle)) {
			isDevConsoleOpen=true;
			logger.info("Develoer Console is open");
		}else {
			isDevConsoleOpen=false;
			logger.info("Can not open Develoer Console");
		}
		return isDevConsoleOpen;
		
	}
	public WebElement getLogoutLink() {		
		return logout;
	}
	
}
