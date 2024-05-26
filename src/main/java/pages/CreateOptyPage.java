package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.BaseTest;
import utils.DataUtils;
import utils.WebElementUtils;


public class CreateOptyPage extends BasePage{

	public CreateOptyPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[@id='Opportunity_Tab']/a")
	public WebElement optyLink;
	
	@FindBy(id = "fcf")
	public WebElement optyViewDropdownSelect;
	@FindBy(xpath = "//select[@id='fcf']/option")
	public List<WebElement> optyViewDDOptions;
	@FindBy(xpath = "//input[@value=' New ']")
	public WebElement newButton;
	
	@FindBy(id = "opp3")
	public WebElement newOptyName;
	@FindBy(id = "opp4_lkwgt")
	public WebElement newOptyAccountNameSrch;
	@FindBy(id = "opp12")
	public WebElement newOptyProbability;
	@FindBy(id = "opp9")
	public WebElement newOptyCloseDate;
	@FindBy(id = "opp17")
	public WebElement newOptyPrimaryCampaignSource;
	@FindBy(id = "opp6")
	public WebElement newOptyLeadSourceSelect;
	@FindBy(id = "opp11")
	public WebElement newOptyStageSelect;
	
	@FindBy(xpath = "//td[@id='topButtonRow']/input[@value=' Save ']")
	public WebElement saveBtn;
	
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
	@FindBy(xpath = "//li/a[contains(text(), 'Opportunity Pipeline')]")
	public WebElement optyPipelineReport;	
	@FindBy(xpath = "//li/a[contains(text(), 'Stuck Opportunities')]")
	public WebElement stuckOptyReport;
	
	@FindBy(id = "quarter_q")
	public WebElement interval;
	@FindBy(id = "open")
	public WebElement include;
	@FindBy(xpath = "//input[@value='Run Report']")
	public WebElement runReport;
	
	
	public void getOptyTab(WebDriver driver) {
		optyLink.click();
	}
	public boolean isOptyPageDisplayed(WebDriver driver) throws IOException {
		boolean isOptyPageDisplayed = false;
		String actual = driver.getTitle();
		String expected = DataUtils.readLoginTestData("optyHomePageTitle");
		if(actual.endsWith(expected)) {
			isOptyPageDisplayed= true;
			logger.info("Accounts Page is displayed");
		}else {
			isOptyPageDisplayed= false;
			logger.info("Can not display Accounts Page");
		}
		return isOptyPageDisplayed;
		
	}
	public void selectOptyViewDropdown(WebDriver driver) {
		BaseTest.clickDropDown(optyViewDropdownSelect);		
	}
	public List<String> getOptyViewOptionNames(){
		List<String> optionNames = new ArrayList<>();
		for(WebElement option: optyViewDDOptions) {
			optionNames.add(option.getText());
		}
		return optionNames;
	}
	public boolean isOptyViewOptionsLoaded(WebDriver driver) {
		boolean isOptyViewOptionsLoaded=false;		
		List<String>  actualOptionNames =getOptyViewOptionNames();
		List<String> expectedOptionNames = Arrays.asList("All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities", "Won");
		Collections.sort(actualOptionNames);
		Collections.sort(expectedOptionNames);
		if(actualOptionNames.equals(expectedOptionNames)) {
			isOptyViewOptionsLoaded=true;
			logger.info("All opportunity options are loaded");
		}else {
			isOptyViewOptionsLoaded=false;
			logger.info("Can not load opportunity options");
		}
		return isOptyViewOptionsLoaded;		
	}
	public void createNewOpty(WebDriver driver) throws IOException {
		newButton.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = DataUtils.readLoginTestData("newOptyPageTitle");
		if(actualTitle.equals(expectedTitle)) {
			logger.info("New opportunity page is displayed.");
			newOptyName.sendKeys(DataUtils.readLoginTestData("newOptyName"));
			String mainWindowHandle = driver.getWindowHandle();
			getAccountName(driver, newOptyAccountNameSrch);
			driver.switchTo().window(mainWindowHandle);	
			newOptyProbability.clear();
			newOptyProbability.sendKeys(DataUtils.readLoginTestData("newOptyProbability"));
			newOptyCloseDate.sendKeys(DataUtils.readLoginTestData("newOptyCloseDate"));
			WebElementUtils.selectRandomOptionFromDropdown(newOptyLeadSourceSelect);
			WebElementUtils.selectRandomOptionFromDropdown(newOptyStageSelect);
			newOptyPrimaryCampaignSource.clear();;
			saveBtn.click();
		}else {
			logger.info("Can not display New opportunity page");
		}		
	}
	public void getAccountName(WebDriver driver, WebElement ele) {
		ele.click();
		WebElementUtils.clickAndSwitchToNewWindow(driver, newOptyAccountNameSrch);
		driver.switchTo().frame(searchFrame);
		searchInput.sendKeys("a");
		goBtn.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(searchResult);
		WebElementUtils.selectFirstCellInTable(driver, tableElement);
	}
	
	private String getNewOptyName(WebDriver driver) throws IOException {
		return DataUtils.readLoginTestData("newOptyName");
	}
	public boolean isNewOptyPage(WebDriver driver) throws IOException {
		boolean isNewOptyPage=false;		
		String actualTitle =driver.getTitle(); 
		String expectedTitle = "Opportunity: "+getNewOptyName(driver)+" ~ Salesforce - Developer Edition";
		if(actualTitle.equals(expectedTitle)) {
			isNewOptyPage=true;
			logger.info("New Opportunity page is displayed");
		}else {
			isNewOptyPage=false;
			logger.info("Can not display New Opportunity page.");
		}
		return isNewOptyPage;		
	}
	public void getOptyPipelineReport(WebDriver driver) {
		optyPipelineReport.click();		
	}
	public boolean isOptyPipelineReportPage(WebDriver driver) throws IOException {
		boolean isOptyPipelineReportPage = false;
		String actualTitle = driver.getTitle();
		String expectedTitle = DataUtils.readLoginTestData("isOptyPipelinePageTitle");
		if(actualTitle.equals(expectedTitle)) {
			isOptyPipelineReportPage=true;
			logger.info("Opportunity Pipeline page is displayed");
		}else {
			isOptyPipelineReportPage=false;
			logger.info("Can not display Opportunity pipeline page.");
		}
		return isOptyPipelineReportPage;
		
	}
	public void getStuckOpportunitiesReport(WebDriver driver) {
		stuckOptyReport.click();		
	}
	public boolean isStuckOpportunitiesReportPage(WebDriver driver) throws IOException {
		boolean isStuckOpportunitiesReportPage = false;
		String actualTitle = driver.getTitle();
		String expectedTitle = DataUtils.readLoginTestData("isStuckOpportunitiesReportPage");
		if(actualTitle.equals(expectedTitle)) {
			isStuckOpportunitiesReportPage=true;
			logger.info("Stuck Opportunity page is displayed");
		}else {
			isStuckOpportunitiesReportPage=false;
			logger.info("Can not display Stuck Opportunity page.");
		}
		return isStuckOpportunitiesReportPage;
		
	}
	public void getQuarterlySummaryReport(WebDriver driver) {
		WebElementUtils.selectRandomOptionFromDropdown(interval);
		WebElementUtils.selectRandomOptionFromDropdown(include);
		runReport.click();
		
	}
	public boolean isQuarterlySummaryReportPage(WebDriver driver) throws IOException {
		boolean isQuarterlySummaryReportPage = false;
		String actualTitle = driver.getTitle();
		String expectedTitle = DataUtils.readLoginTestData("isQuarterlySummaryReportPage");
		if(actualTitle.equals(expectedTitle)) {
			isQuarterlySummaryReportPage=true;
			logger.info("Opportunity Report page is displayed");
		}else {
			isQuarterlySummaryReportPage=false;
			logger.info("Can not display Opportunity Report page.");
		}
		return isQuarterlySummaryReportPage;
		
	}
	
}
