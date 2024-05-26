package pages;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.DataUtils;
import utils.WaitUtils;
import utils.WebElementUtils;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Lead_Tab")
	public WebElement leadsTab;
	
	@FindBy(xpath = "//select[@name='fcf']/option[@selected='selected']")
	public WebElement selectViewSelectedValue;
	
	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement selectView;
	
	@FindBy(xpath = "//select[@id='fcf']/option")
	public List<WebElement> viewOptions;
	
	@FindBy(xpath = "//input[@value=' Go! ']")
	public WebElement goBtn;
	
	@FindBy(xpath = "//input[@value=' New ']")
	public WebElement newBtn;

	@FindBy(id = "name_lastlea2")
	public WebElement lastName;
	@FindBy(id = "lea3")
	public WebElement companyName;
	@FindBy(xpath = "//td[@id='topButtonRow']/input[@value=' Save ']")
	public WebElement saveBtnTop;
	
	
	public void getLeadsTab(WebDriver driver) {
		leadsTab.click();
	}
	public boolean isLeadsHomePage(WebDriver driver) throws IOException {
		boolean isLeadsPage = false;
		String actual =driver.getTitle();
		String expected = DataUtils.readLoginTestData("isLeadsHomePageTitle");		
		if(actual.equals(expected)) {
			isLeadsPage = true;
			logger.info("Leads Home Page is displayed.");
		}else {
			isLeadsPage = false;
			logger.info("Can not load Leads Home Page.");
		}
		return isLeadsPage;
	}
	public void clickSelectView(WebDriver driver) {
		selectView.click();
	}
	public List<String> getSelectViewOptionNames(WebDriver driver){		
		return WebElementUtils.getDropdownOptionNames(null, viewOptions);
	}
	public boolean isSelectViewOptionsLoaded(WebDriver driver) {
		boolean isSelectViewLoaded = false;
		List<String> actualOptions = getSelectViewOptionNames(driver);
		List<String> expextedOptions = Arrays.asList("All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads");
		Collections.sort(actualOptions);
		Collections.sort(expextedOptions);
		if(actualOptions.equals(expextedOptions)) {
			isSelectViewLoaded=true;
			logger.info("Leads View options are loaded.");
		}else {
			isSelectViewLoaded=false;
			logger.info("Can not load Leads View options.");
		}
		return isSelectViewLoaded;	
	}
	public void getTodaysLeadOption(WebDriver driver) throws IOException {		
			String optionToselect="Today's Leads";
			WebElementUtils.selectDropdownOption(driver, selectView, optionToselect);
//			logger.info(optionToselect+" is selected from Leads View");
	}
	
	public void getMyUnreadLeadsOption(WebDriver driver) {
		String optionToselect="My Unread Leads";		
		WebElementUtils.selectDropdownOption(driver, selectView, optionToselect);
//		logger.info(optionToselect+" is selected from Leads View");
	}
	public void goButton(WebDriver driver) {
		WaitUtils.waitForElement(driver, goBtn);
		goBtn.click();		
	}
	public String getDefaultViewValue(WebDriver driver) {
		return selectViewSelectedValue.getText();		
	}
	
	public boolean isSelectedViewDisplayed(WebDriver driver) throws IOException {
		boolean isViewSelectedViewDisplayed = false;				
		String defaultViewValue = getDefaultViewValue(driver);
		String actual = selectViewSelectedValue.getText();

		if(actual.equals(defaultViewValue) ) {						
			isViewSelectedViewDisplayed=true;
		}else {
			isViewSelectedViewDisplayed=false;			
		}
		return isViewSelectedViewDisplayed;	
	}
	
	public boolean isSelectedViewPageTodaysLeads(WebDriver driver) throws IOException {
		boolean isSelectedViewTodaysLeads = false;				
		String homeViewValue = getDefaultViewValue(driver);
		String selectedViewValue = "Today's Leads";
		if(homeViewValue.equals(selectedViewValue) ) {						
			isSelectedViewTodaysLeads=true;
		}else {
			isSelectedViewTodaysLeads=false;			
		}
		return isSelectedViewTodaysLeads;	
	}
	public void createNewLead(WebDriver driver) {
		newBtn.click();
	}
	
	public boolean isNewLeadCreationPage(WebDriver driver) throws IOException {
		boolean isNewLeadCreationPage = false;
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = DataUtils.readLoginTestData("newLeadEditPageTitle");
		if(actualPageTitle.equals(expectedPageTitle) ) {						
			isNewLeadCreationPage=true;
		}else {
			isNewLeadCreationPage=false;			
		}
		return isNewLeadCreationPage;
	}
	public void enterNewLeadDetails(WebDriver driver) throws IOException {
		lastName.sendKeys(DataUtils.readLoginTestData("newLeadLastName"));
		companyName.sendKeys(DataUtils.readLoginTestData("newLeadCompany"));
		saveBtnTop.click();
	}
	public boolean isNewlyCreatedLeadViewPage(WebDriver driver) throws IOException {
		boolean isNewlyCreatedLeadViewPage = false;
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "Lead: "+DataUtils.readLoginTestData("newLeadLastName")+" ~ Salesforce - Developer Edition";
		if(actualPageTitle.equals(expectedPageTitle) ) {						
			isNewlyCreatedLeadViewPage=true;
		}else {
			isNewlyCreatedLeadViewPage=false;			
		}
		return isNewlyCreatedLeadViewPage;
	}
}
