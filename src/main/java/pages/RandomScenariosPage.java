package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.DataUtils;

public class RandomScenariosPage extends BasePage {
	public RandomScenariosPage(WebDriver driver) {
		super(driver);
	}
	UserMenuPage ump;
	
	@FindBy(id = "home_Tab")
	public WebElement homeTab;
	
	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	public WebElement currentUserContainer;
	
	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	public WebElement userNameLink;
	
	
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
	
	
}
