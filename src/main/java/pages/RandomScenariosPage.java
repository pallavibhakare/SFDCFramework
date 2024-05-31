package pages;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataUtils;
import utils.WebElementUtils;

public class RandomScenariosPage extends BasePage {
	public RandomScenariosPage(WebDriver driver) {
		super(driver);
	}
	UserMenuPage ump;
	private String popupWindowHandle;
	
	@FindBy(id = "home_Tab")
	public WebElement homeTab;
	
	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	public WebElement currentUserContainer;
	
	@FindBy(xpath = "//span[@class='pageDescription']")
	public WebElement currentDateContainer;
	
	@FindBy(xpath = "//span[@class='pageDescription']/a")
	public WebElement currentDateLink;
	
	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	public WebElement userNameLink;
	
	@FindBy(id = "AllTab_Tab")
	public WebElement allTab;
	
	@FindBy(xpath = "//input[@class='btnImportant']")
	public WebElement customizeMyTab;
	
	@FindBy(id = "duel_select_1")
	public WebElement selectedTabs;
	
	@FindBy(xpath = "//a[@id='duel_select_0_left']/img")
	public WebElement removeBtn;
	
	@FindBy(id = "duel_select_0")
	public WebElement availableTabs;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']/input[@value=' Save ']")
	public WebElement saveCustomizeMyTab;
	
	@FindBy(xpath = "//td[@class='fixedTable']")
	public WebElement timeTable;
	
	@FindBy(id = "evt5")
	public WebElement subjectField;

	@FindBy( xpath = "//label[@for='evt5']")
	public WebElement subjectFieldLabel;
	
	@FindBy(xpath = "//td[@class='dataCol col02']/div/a/img")
	public WebElement subjectComboBoxIcon;
	
	@FindBy(xpath = "//body[@class='taskTab brandNoBgrImg subjectSelectionPopup']")
	public WebElement subjectPopup;
	
	@FindBy(xpath = "//div[@class='choicesBox tertiaryPalette brandSecondaryBrd']/ul")
	public WebElement selectSubjectUl;
	
	@FindBy(xpath = "//div[@class='choicesBox tertiaryPalette brandSecondaryBrd']/ul/li")
	public WebElement selectSubjectLi;
	
	@FindBy(id = "EndDateTime_time")
	public WebElement endTimeField;
	
	@FindBy(id = "simpleTimePicker")
	public WebElement simpleTimePicker;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']/input[@value=' Save ']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='multiLineEventBlock dragContentPointer']/span")
	public WebElement addedEventElement;
	
	public void getHomeTab() {
		homeTab.click();		
	}
	public boolean isHomeTabPage(WebDriver driver) throws IOException {
		boolean isHomeTabPage = false;
		String actualTitle = driver.getTitle();
		String expextedTitle = DataUtils.readLoginTestData("homeTabPageTitle");
		if(actualTitle.equals(expextedTitle)) {
			isHomeTabPage = true;
		}
		else {
			isHomeTabPage = false;
		}
		return isHomeTabPage;
	}
	public boolean isUserNameLinkDisplayed(WebDriver driver) {
		boolean isUserNameDisplayed = false;
		UserMenuPage ump = new UserMenuPage(driver);
		String expectedFullName = ump.getUserName(driver);
		
		WebElement h1Element =currentUserContainer; 
        // Locate the anchor tag within the h1 element
        WebElement linkElement = h1Element.findElement(By.tagName("a"));
        // Get the text of the anchor tag
       	String actualFullName = linkElement.getText();
       	
		if (actualFullName.equals(expectedFullName)) {
			isUserNameDisplayed = true;
            System.out.println("The user's first name and last name are displayed as a link: " + actualFullName);
        } else {
        	isUserNameDisplayed = false;
            System.out.println("The displayed link text does not match the expected name. Found: " + actualFullName);
        }
		return isUserNameDisplayed;
	}
	public void getUserNameLink(WebDriver driver) {
		userNameLink.click();		
	}

	public boolean isUserNamePagesSameAsMyProfile(WebDriver driver) throws IOException {
		boolean arePagesSame = false;
		String currentPageTitle = driver.getTitle();
		ump = new UserMenuPage(driver);
		String myProfilePageTitle = "User: "+ump.getUserName(driver)+" ~ Salesforce - Developer Edition";
	
		boolean isSourceSame = currentPageTitle.equals(myProfilePageTitle);
		//Compares the HTML source of the two pages.
		if(isSourceSame) {
			arePagesSame = true;
			logger.info("Both pages are same.");
        } else {
        	arePagesSame = false;
        	logger.info("The pages are different.");
        }
		return arePagesSame;
	}
	public void allTab(WebDriver driver) {
		if(allTab.isDisplayed()) {
			allTab.click();
		}else {
			logger.info("Can not load All tabs.");
		}
	}
	public boolean isAllTabPageLoaded(WebDriver driver) throws IOException {
		boolean isAllTabPage= false;
		String actual = driver.getTitle();
		String expected = DataUtils.readLoginTestData("allTabsPageTitle");
		if(actual.equals(expected)) {
			isAllTabPage = true;
			logger.info("All tabs home Page is displayed");
		}else {
			isAllTabPage= false;
			logger.info("Can not load All tabs home Page.");
		}
		return isAllTabPage;
	}
	public void customizeMyTabBtn(WebDriver driver) {
		customizeMyTab.click();
	}
	public boolean isCustomizeMyTabsPage(WebDriver driver) throws IOException {
		boolean isCustomizeMyTabsPage= false;
		String actual = driver.getTitle();
		String expected = DataUtils.readLoginTestData("customizeMyTabsPageTitle");
		if(actual.equals(expected)) {
			isCustomizeMyTabsPage = true;
			logger.info("'Customize My Tabs' Page is displayed");
		}else {
			isCustomizeMyTabsPage= false;
			logger.info("Can not display 'Customize My Tabs' Page.");
		}
		return isCustomizeMyTabsPage;
	}
	public String getTabNameToRemove(WebDriver driver) throws IOException {
		return DataUtils.readLoginTestData("optionValueToRemove");
	}
	public void removeAnyTab(WebDriver driver) throws IOException {
		String optionValueToRemove = getTabNameToRemove(driver);
		Select select = new Select(selectedTabs);
		select.selectByVisibleText(optionValueToRemove);
		removeBtn.click();
	}
	public boolean isTabRemovedFromSelected(WebDriver driver) throws IOException {
		String optionValueToRemove = getTabNameToRemove(driver);
		Select selectedTabsSelect = new Select(selectedTabs);
		boolean isTabRemovedFromSelected = selectedTabsSelect.getOptions().stream()
                .noneMatch(option -> option.getText().equals(optionValueToRemove));
		logger.info("Selected Tab" +isTabRemovedFromSelected);
		return isTabRemovedFromSelected;
	}
	public boolean isTabAddedToAvailableTabs(WebDriver driver) throws IOException {
		
		Select availableTabSelect = new Select(availableTabs);
		String optionValueToRemove = getTabNameToRemove(driver);
		boolean isTabAddedToAvailable  = availableTabSelect.getOptions().stream().anyMatch(option -> option.getText().equals(optionValueToRemove));
		logger.info("Available Tabs" +isTabAddedToAvailable);
		return isTabAddedToAvailable ;
	}
	public void saveCustomizeMyTabs(WebDriver driver) {
		saveCustomizeMyTab.click();
	}
	public boolean isTabRemovedFromTabBar(WebDriver driver) throws IOException {
		boolean isTabRemoved = true;
		String optionValueToRemove = getTabNameToRemove(driver);
		List<WebElement> tabs = driver.findElements(By.cssSelector("#tabBar > li > a"));
		for(WebElement tab : tabs) {
			if(tab.getText().equals(optionValueToRemove)) {
				isTabRemoved = false;
				break;
			}
		}
		return isTabRemoved;
	}
	
	public boolean isDateDisplayedAsLink(WebDriver driver) {
		boolean isDateLinkDisplayed = false;
		String expectedDate = getCurrentDate(driver);
		
		WebElement dateElement =currentDateContainer; 
        // Locate the anchor tag within the h1 element
        WebElement linkElement = dateElement.findElement(By.tagName("a"));
        // Get the text of the anchor tag
       	String actualDate = linkElement.getText();
       	
		if (actualDate.equals(expectedDate)) {
			isDateLinkDisplayed = true;
            logger.info(getCurrentDate(driver)+" date is displayed");
        } else {
        	isDateLinkDisplayed = false;
        	logger.info("Can not display date");
        }
		return isDateLinkDisplayed;
	}
	
	public String getCurrentDate(WebDriver driver) {
		// Create an instance of SimpleDateFormat with the desired date format
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE MMMM dd, yyyy");        
        // Get the current date
        Date currentDate = new Date();        
        // Format the current date
        String formattedDate = formatter.format(currentDate);
        return formattedDate;
	}
	public void clickCurrentDate(WebDriver driver) {
		if(currentDateLink.isDisplayed()) {
		currentDateLink.click();		
		}
	}
	public boolean isUserCalenderPage(WebDriver driver) {
		boolean isUserCalenderPage = false;
		String actualTitle = driver.getTitle();
		UserMenuPage ump = new UserMenuPage(driver);
		String expectedTitle = "Calendar for "+ump.getUserName(driver)+" ~ Salesforce - Developer Edition";
       	
		if (actualTitle.equals(expectedTitle)) {
			isUserCalenderPage = true;
            logger.info("Calender for "+ump.getUserName(driver)+" is displayed");
        } else {
        	isUserCalenderPage = false;
        	logger.info("Can not display Calender for "+ump.getUserName(driver));
        }
		return isUserCalenderPage;
	}
	public void clickOnTime(WebDriver driver, String time) {		
		WebElementUtils.selectTimeOption(driver, time);		
	}
	public boolean isCalendarNewEventPageWithCursorOnSubject(WebDriver driver) throws IOException {
		
		String actualTitle = driver.getTitle();		
		String expectedTitle = DataUtils.readLoginTestData("calenderNewEventPageTitle");
       	
		// Check if the page title matches
	    if (actualTitle.equals(expectedTitle)) {
	        logger.info(actualTitle + " is displayed");

	        // Check if the subject field is active (focused)
	        subjectField.click();
	        WebElement activeElement = driver.switchTo().activeElement();
	        String labelText = subjectFieldLabel.getText().replace("*", "").trim();
	        if (subjectField.equals(activeElement)) {
	            logger.info("Cursor is at " + labelText + " field.");
	            return true; // Both conditions are met
	        } else {
	            logger.info("Cursor is not at the " + labelText + " field.");
	            return false; // Cursor is not at the subject field
	        }
	    } else {
	        logger.info("Cannot display Calendar: New Event Page");
	        return false;
	    }
	}
	public String getMainWindow(WebDriver driver) {
		return	driver.getWindowHandle();	
	}
	
	public boolean isComboBoxPopupOpened(WebDriver driver) throws IOException {

		//The current window handle is stored so that you can switch back to it later.
		String mainWindowHandle = driver.getWindowHandle();
		//open the popup
		subjectComboBoxIcon.click();
		//The WebDriverWait is used to wait until the number of windows is 2, indicating the popup has opened.	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //get all windowHandles
        Set<String> childWindowHandles = driver.getWindowHandles();
        //Loop through the window handles to find the popup (which is not the main window).
        for(String windowHandle : childWindowHandles) {
        	if(!windowHandle.equals(mainWindowHandle)) {
        		 try {
        			 // Switch to the popup window and check its title.
	        		driver.switchTo().window(windowHandle);
	        		//validate popup
	        		String expectedPopupTitle = DataUtils.readLoginTestData("ComboBoxPopupTitle");
	        		String actualPopupTitle = driver.getTitle();
	        		if(actualPopupTitle.equals(expectedPopupTitle)) {
	        			//If the popup title matches the expected title, set this.popupWindowHandle and return true.
	        			logger.info("The 'ComboBox' popup is opened.");
	        			this.popupWindowHandle = windowHandle;
	        			return true;
	        		}else {
	        			//If the title doesn't match, switch back to the main window and return false.
	        			logger.info("Can not open 'ComboBox' popup.");
	        			 driver.switchTo().window(mainWindowHandle);
	        			return false;
	        		}  
        		 }catch(NoSuchWindowException e) {
        			 //if popup window is already closed, log a warning and switch back to main window
        			 logger.warn("Popup window already closed: " + e.getMessage());
                     driver.switchTo().window(mainWindowHandle);
                     return false;
        		 }
        	}
        }
        //fallback:if no popup found, log the information and switch back to mainwindow
        logger.info("No popup window found.");
        driver.switchTo().window(mainWindowHandle);
		return false;			
	}
	public void performActionInPopup(WebDriver driver, Boolean popupOpened) throws IOException {
		//The method takes a boolean parameter (popupOpened) to check if the popup was successfully opened.
		if (popupOpened) {
			try {
				//Switch to the popup window using this.popupWindowHandle.
				 driver.switchTo().window(this.popupWindowHandle);
				 String text = DataUtils.readLoginTestData("ComboBoxOption");
	                WebElement otherOption = driver.findElement(By.xpath("//a[contains(text(),'"+text+"')]"));
	                otherOption.click();
	                logger.info("Clicked 'Other' option in the popup.");
	                // Wait  until the number of windpws is 1 , indicating the popup has closed
	                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	                wait.until(ExpectedConditions.numberOfWindowsToBe(1));
	                
	                // Loop through window handles to switch back to the main window.
	                for (String windowHandle : driver.getWindowHandles()) {
	                    driver.switchTo().window(windowHandle);
	                }
	            } catch (NoSuchWindowException e) {
	            	//If the popup window is already closed, log a warning.
	                logger.warn("Popup window already closed: " + e.getMessage());
	            } finally {
	            	//Ensure that the driver switches back to the default content (main window).
	                driver.switchTo().defaultContent();
	            }
			} else {
				//Log a message that the popup was not opened.
            logger.info("Popup was not opened. Cannot perform actions in popup.");
        }
	}
	public boolean isOtherInSubjectField(WebDriver driver) throws IOException {
		String actual = subjectField.getAttribute("value");
		String expected= DataUtils.readLoginTestData("ComboBoxOption");
		if(actual.equals(expected)) {
			logger.info(expected+" is entered in the Subject field.");
			return true;
		}else {
			
			logger.info(expected+" can not be selected.");
			return false;
		}
	}
	
	public String getSubjectFieldValue(WebDriver driver) throws IOException {
		String value = subjectField.getAttribute("value");
		return value;
	}
	public boolean isPopupClosed(WebDriver driver) {
		if (driver.getWindowHandles().size() == 1) {
            logger.info("The popup window is closed.");
            return true;
        } else {
            logger.info("The popup window is still open.");
            return false;
        }
		
	}
	public boolean areDropdownTimesCorrect(WebDriver driver) {
		endTimeField.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> timeOptions = simpleTimePicker.findElements(By.className("simpleHour"));
		List<String> expectedTimes = Arrays.asList("9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM", "11:00 PM", "11:30 PM");
		List<String> actualTimes = new ArrayList<>();
		for(WebElement option : timeOptions) {
			String timeText = option.getText().trim();
			actualTimes.add(timeText);
		}
//		System.out.println(actualTimes);
//		System.out.println("ex"+expectedTimes);
		return  actualTimes.containsAll(expectedTimes);      
	}
	public boolean selectTime(WebDriver driver) throws IOException {
		String timeToSelect =DataUtils.readLoginTestData("chooseTime");
		List<WebElement> timeOptions = simpleTimePicker.findElements(By.className("simpleHour"));
		for(WebElement option : timeOptions) {
			if(option.getText().trim().equals(timeToSelect)) {
				option.click();
				return true;
			}
		}			
		return false;
	}
	public String getSelectedTime(WebDriver driver) throws IOException {		
		return endTimeField.getAttribute("value");
	}
	public boolean isSavedCalenderEvent(WebDriver driver) throws IOException {
		UserMenuPage ump = new UserMenuPage(driver);
		saveBtn.click();
		boolean isPageSaved = false;
		if(driver.getTitle().equals("Calendar for "+ump.getUserName(driver)+" ~ Salesforce - Developer Edition")) {
			isPageSaved = true;
			WebElement addedEvent =addedEventElement; 
	        // Locate the anchor tag within the h1 element
	        WebElement linkElement = addedEvent.findElement(By.tagName("a > span"));
	        // Get the text of the anchor tag
	       	String eventNameLink = linkElement.getText();
	       	String expected = DataUtils.readLoginTestData("ComboBoxOption");
			if (eventNameLink.equals(expected)) {
				logger.info("Calender is displayed with 'Other' event as a link.");
	        } else {
	        	logger.info("No Calender Event");
	        }
			
		}else {
			isPageSaved = false;
		}
				
		return isPageSaved;
	}
}
