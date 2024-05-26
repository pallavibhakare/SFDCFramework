package pages;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.BaseTest;
import utils.DataUtils;
import utils.WaitUtils;


public class LoginPage extends BasePage{
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	//page elements and 
	@FindBy(xpath = "//input[@id='username']")
	public WebElement usernameField;
	
		
	@FindBy(id = "password")
	public WebElement passwordField;
		
	@FindBy(id="Login")
	public WebElement loginButton;
	
	@FindBy(xpath = "//input[@id='rememberUn']")
	public WebElement rememberMe;
	
	
	@FindBy(id = "forgot_password_link")
	public WebElement forgetPassword;
	
	@FindBy(xpath = "//span[@id='idcard-identity']")
	public WebElement savedUserName;
	
	@FindBy(id = "un")
	public WebElement forgetUsername;
		
	@FindBy(id = "continue")
	public WebElement continueButton;
	
	@FindBy(id = "error")
	public WebElement errorMessage;
	
	@FindBy(id = "userNavLabel")
	public WebElement userMenu;
	
	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	public WebElement logoutButton;
		
	@FindBy(xpath = "//div[@class='message']")
	public 	WebElement forgetPassFormMsg;
	
	@FindBy(xpath = "//div[@class='message']/p[1]")
	public 	WebElement emailAssociatedMsg;
	
	
	
	
	//TC-01 Login Error Message
	public boolean isErrorMessageDisplayed() {
		boolean isErrorDisplayed = false;
		if(errorMessage.isDisplayed()) {
			isErrorDisplayed = true;
		}
		else {
			System.out.println("Error is not displayed");
		}
		return isErrorDisplayed;
	}
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
	//TC-02 Login to Salesforce
	public void loginToSFDC(WebDriver driver) throws IOException {
		String userEmail = DataUtils.readLoginTestData("username");
		String userPassword = DataUtils.readLoginTestData("password");
		logger.info("Signing in to application");
		this.usernameField.clear();
		this.usernameField.sendKeys(userEmail);
		this.passwordField.clear();
		this.passwordField.sendKeys(userPassword);
		this.loginButton.click();
		logger.info("Should be Signing in to application");
	}

	public void launchAndLoginToApplication(WebDriver driver) throws IOException {
		LoginPage lp = new LoginPage(driver);
		BaseTest bt =new BaseTest();
		bt.goToUrl(driver);		
		logger.info("Salesforce login page is launched and application");
		lp.loginToSFDC(driver);		
		lp.isHomePageLoaded(driver);
		logger.info("Home page is displayed.");		
	}
	
	public void enterUserName() throws IOException {
		logger.info("LoginPage: enterUsername : Started");
		String user = DataUtils.readLoginTestData("username");
		usernameField.clear();
		try {
	        usernameField.clear();
	        if (usernameField.isDisplayed()) {
	            usernameField.sendKeys(user);
	            logger.info("Entered username: " + user);
	        } else {
	            throw new NoSuchElementException("Username field is not displayed");
	        }
	    } catch (NoSuchElementException e) {
	        logger.error("LoginPage: enterUserName : " + e.getMessage());
	        throw e;
	    }
	}		
		
	public void enterPassword() throws IOException  {
		logger.info("LoginPage: enterPassword : Started");	
		String userPassword = DataUtils.readLoginTestData("password");	
		try {
	        if (passwordField.isDisplayed()) {
	            passwordField.clear();
	            passwordField.sendKeys(userPassword);
	            logger.info("Entered password");
	        } else {
	            throw new NoSuchElementException("Password field is not displayed");
	        }
	    } catch (NoSuchElementException e) {
	        logger.error("LoginPage: enterPassword : " + e.getMessage());
	        throw e;
	    }
		
	}
	public String getPassword() {
		return passwordField.getText();		
	}
	
	public void clearPassword() throws IOException  {
		logger.info("LoginPage: clearPassword : Started");		
		if(passwordField.isDisplayed()) {
			passwordField.clear();
		}else {
			logger.error("LoginPage: clearPassword : password not cleared.");
		}
		
	}
	
	
	public void clickLoginButton() {
		logger.info("LoginPage: clickLoginButton : Started");		
		if(loginButton.isDisplayed()) {
			loginButton.click();
		}else {
			logger.error("LoginPage: clickLoginButton : login button not clicked.");
		}
	}
	
	public void logoutFromSFDC(WebDriver driver) {		
		userMenu.click();
		logger.info("Usermenu is clicked");
		logoutButton.click();
		logger.info("Clicked Logout.");		
		WaitUtils.waitForElementToDisappear(driver, logoutButton);
	}
	
	public boolean isUserSaved(WebDriver driver) throws IOException {
		boolean isUserSaved = false;	
		String savedUser = savedUserName.getText();
		if(savedUser.equals(DataUtils.readLoginTestData("username")) && rememberMe.isSelected()) {
			isUserSaved = true;
		}else {
			isUserSaved = false;
		}
		return isUserSaved;
	}
	
	public String getSavedUser() {
		return savedUserName.getText();
	}
	public void selectRememberMeCheckbox(){		
		logger.info("LoginPage: Select 'Remember Me' checkbox");
		if(!rememberMe.isSelected()) {
			rememberMe.click();
		}		
	}
	public boolean isRememberMeSelected() {
	    logger.info("LoginPage: Checking if 'Remember Me' checkbox is selected");
	    return rememberMe.isSelected();
	}
	public boolean isLoginPageOpen(WebDriver driver) throws IOException {
		boolean isLoginPageOpen = false;
		String actualTitle = driver.getTitle();
		String expextedTitle = DataUtils.readLoginTestData("loginPageTitle");
		if(actualTitle.equals(expextedTitle)) {
			isLoginPageOpen = true;
		}
		else {
			isLoginPageOpen = false;
		}
		return isLoginPageOpen;
	}
	public String getLoginPageTitle() throws IOException {
		return DataUtils.readLoginTestData("loginPageTitle");
	}
	
	public boolean isPassEntered(WebDriver driver) throws IOException {
		boolean isPassEntered = false;
		passwordField.getAttribute("value").isEmpty();
		
		if(!passwordField.getAttribute("value").isEmpty()) {
			isPassEntered = true;
		}else {
			isPassEntered = false;
		}		
		return isPassEntered;
	}
	
	public boolean isLoggedOut(WebDriver driver) throws IOException {
		boolean isLoggedOut = false;
		String actualTitle = driver.getTitle();
		String expextedTitle= DataUtils.readLoginTestData("loginPageTitle");
		if(expextedTitle.equals(actualTitle)) {
			isLoggedOut = true;
		}else {
			isLoggedOut = false;
		}		
		return isLoggedOut;
	}
	
	
	public boolean isHomePageLoaded(WebDriver driver) throws IOException {
		boolean isHomePage = false;
//		WaitUtils.waitForElement(driver, loginButton);
		String actualTitle = driver.getTitle();		
		//System.out.println("act: "+actualTitle);
		String expextedTitle= DataUtils.readLoginTestData("homePageTitle");
		//System.out.println("exp: "+expextedTitle);
		if(expextedTitle.equals(actualTitle)) {
			isHomePage = true;
		}else {
			isHomePage = false;
		}		
		return isHomePage;
	}
	public boolean isUsernameDisplayed() {
		logger.info("LoginPage: Checking if username is displayed");		 
	    return usernameField.isDisplayed();
	}
	public boolean isUserNameValueEntered(String expectedUsername) {
		logger.info("LoginPage: Checking if username value is entered in username field");
	    return usernameField.getAttribute("value").equals(expectedUsername);
	}
	
	public boolean isPasswordEmpty() {
	    logger.info("LoginPage: Checking if password field is empty");
	    return passwordField.getAttribute("value").isEmpty();
	}
	
	//user drop down option selection
	public void selectLogout() {
		BaseTest.selectDropdownOption(null, userMenu, "");
	}
	public void clickForgetPasswordLink() {	
		logger.info("LoginPage: forgetPasswordLink : Started");		
		if(forgetPassword.isDisplayed()){
			forgetPassword.click();			
		}
	}
	public boolean isForgetPasswordPage(WebDriver driver) throws IOException {
		boolean isForgetPasswordPage = false;
		String actualTitle = driver.getTitle();
		String expextedTitle= DataUtils.readLoginTestData("forgetPasswordPageTitle");
		if(expextedTitle.equals(actualTitle)) {
			isForgetPasswordPage = true;
		}else {
			isForgetPasswordPage = false;
		}		
		return isForgetPasswordPage;
	}
	public void forgetPassword() throws IOException {
		
		if(forgetUsername.isDisplayed()) {
			forgetUsername.clear();
			String userName = DataUtils.readLoginTestData("username");
			forgetUsername.sendKeys(userName);
			continueButton.click();
		}
	}
	public boolean isCheckYourEmailPage(WebDriver driver) throws IOException {
		boolean isCheckYourEmailPage = false;
		String actualTitle = driver.getTitle();
		String expextedTitle= DataUtils.readLoginTestData("isCheckYourEmailPage");
		if(expextedTitle.equals(actualTitle)) {
			isCheckYourEmailPage = true;
		}else {
			isCheckYourEmailPage = false;
		}		
		return isCheckYourEmailPage;
	}
	public String getAssociateEmailConfirmationdMsgPageTitle(WebDriver driver) {		
		if(forgetPassFormMsg.isDisplayed()) {
			return driver.getTitle();
		}
		return driver.getTitle();
	}
	public String getAssociateEmailConfirmationdMsg() {		
		return emailAssociatedMsg.getText();
	}
	
	public boolean isForgetPassMessageDisplayed() {
		boolean isForgetPassMessageDisplayed = false;
		if(forgetPassFormMsg.isDisplayed()) {
			isForgetPassMessageDisplayed = true;
		}
		return	isForgetPassMessageDisplayed;
	}
	
	public void enterWrongUserName() throws IOException {
		logger.info("LoginPage: enterUsername : Started");
		String user = DataUtils.readLoginTestData("wrongUser");
		usernameField.clear();
		try {
	        usernameField.clear();
	        if (usernameField.isDisplayed()) {
	            usernameField.sendKeys(user);
	            logger.info("Entered wrong Username " + user);
	        } else {
	            throw new NoSuchElementException("Username field is not displayed");
	        }
	    } catch (NoSuchElementException e) {
	        logger.error("LoginPage: enterUserName : " + e.getMessage());
	        throw e;
	    }
	}	
		
	public void enterWrongPassword() throws IOException  {
		logger.info("LoginPage: enterWrongPassword : Started");	
		String userWrongPass = DataUtils.readLoginTestData("wrongPassword");	
		try {
	        if (passwordField.isDisplayed()) {
	            passwordField.clear();
	            passwordField.sendKeys(userWrongPass);
	            logger.info("Entered wrong Password");
	        } else {
	            throw new NoSuchElementException("Password field is not displayed");
	        }
	    } catch (NoSuchElementException e) {
	        logger.error("LoginPage: enterWrongPassword : " + e.getMessage());
	        throw e;
	    }
		
	}
	public WebElement getUsermenu(WebDriver driver) {		
		return userMenu;
	}
}