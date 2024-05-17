package pages;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CommonUtils;
import utils.WaitUtils;

public class UserMenuPage extends BasePage{
	public UserMenuPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

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

	@FindBy(xpath = "//td[@id='chatterUploadFileActionPanel']")
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

	// Emaillink

	@FindBy(xpath = "//span[@id='EmailSetup_font']")
	public WebElement emailLink;

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
	public WebElement calendarAndReminders;

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
	
	public String getUserName() {
		return userMenu.getText();
	}
	
	public void selectUserMenu() {
		if(userMenu.isDisplayed()) {
			userMenu.click();
		}
		else {
			System.out.println("Element is not displayed");
		}
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
	
	public void selectEditIcon(WebDriver driver) {
		if(WaitUtils.waitForElement(driver, editContactButton)) {
			editContactButton.click();
		}else {
			System.out.println("Edit contact button is not visible");
		}
	}
	public boolean verifyEditContactIframe(WebDriver driver) {
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
	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String lastName) {
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
	public boolean veriyfyCreatePost(WebDriver driver, String message) {
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

	public boolean verifyFileUpload(WebDriver driver, String filePath) throws InterruptedException{
		boolean isFileUploadSuccess = false;
		if(WaitUtils.waitForElement(driver, fileLink)) {
			fileLink.click();
			if(WaitUtils.waitForElement(driver, uploadFile)) {
				//WaitUtils.waitForElement(driver, uploadFile);
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
	public boolean verifyPhotoUpload(WebDriver driver, String imageFilePath) {
		boolean isPhotoUploadedSuccess =false;
		this.clickOnUpdatePhotoButton(driver);
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
	
}
