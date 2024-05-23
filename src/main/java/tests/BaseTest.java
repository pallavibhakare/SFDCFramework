package tests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.FileConstants;
import utils.DataUtils;


public class BaseTest {
	
	public static WebDriver driver;
	
	//'threadLocalDriver' variable holds  that holds separate instances 
	//of WebDriver for each thread in a multi-threaded environment
	//This local thread is for all the multiple threads that runs the multiple tests so same 
	//static object is not share among all tests.
	//If that happens all tests results are listed under one test that is why need threadLocal same like driver.
	//As used in testng.xml thread-count, that many threads will be created with their won driver obj.
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	
	//configuration of extentreports
	public static ThreadLocal<ExtentTest> threadExtentText = new ThreadLocal<ExtentTest>();	
	public static ExtentReports extent;
	public static ExtentTest test;			//variable to use in all tests cases for listeners logs
	
	//Log4j
	static Logger logger =LogManager.getLogger();
	
	@BeforeSuite
	public void  doConfiguration() {
		extent = new ExtentReports();
		//type of report we want to use we can choose 
		ExtentSparkReporter sparkReporter =  new ExtentSparkReporter(FileConstants.REPORT_PATH);
		//attach reporter to our object 
		extent.attachReporter(sparkReporter);
	}
	@AfterSuite
	public void tearDownConfiguration() {
		extent.flush(); //report will be flushed to the .html fiel
	}
	
	
	public static void setDriver(String browserName, boolean headless) {
		WebDriver driver = BaseTest.getBrowseDriver(browserName, false);
		threadLocalDriver.set(driver);	
	}	
	public static WebDriver getDriver() {		
		//returns webDriver type
		return threadLocalDriver.get();
	}
	
	public static WebDriver getBrowseDriver(String browserName, boolean isHeadless) {
		browserName = browserName.toLowerCase();
		switch(browserName){
			case "chrome":
					if(isHeadless) {
						ChromeOptions options = new ChromeOptions();
						options.addArguments("--headless", "--disable-gpu");
						driver = new ChromeDriver(options);
					}else {
						driver = new ChromeDriver();
					}
				break;
			case "edge":
				if(isHeadless){
					EdgeOptions options = new EdgeOptions();
					options.addArguments("--headless", "--disable-gpu");
					driver = new EdgeDriver(options);
				}else {
					driver = new EdgeDriver();
				}
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			default:
				driver = null;
				logger.error("Driver configuration failed.");
				System.out.println("Browser name is invalid.");
		}
		return driver;

	}
	
	//reusable methods
	public void goToUrl(WebDriver driver) throws IOException {
		String url=DataUtils.readLoginTestData("url");			
        driver.get(url);
        System.out.println(url + " is entered");
    }
	public void maximiseBrowser() {
        driver.manage().window().maximize();
        System.out.println("Browser window has maximized");
    }

    public void closeBrowser() {
        driver.close();
        System.out.println("Browser closed");
    }


    public void clickElement(WebElement ele, String objName) {
        if (ele.isEnabled()) {
            ele.click();
            System.out.println(objName + " button is clicked");
        } else {
            System.out.println("Button element is not enabled");
        }
    }
    
	//for clicking dropdown(clickDropDown)  and selecting DD option(selectDropdownOption)
	public static void clickDropDown(WebElement dropdownElement  ) {
		if(dropdownElement.isDisplayed()) {
			dropdownElement.click();
			logger.info("Dropdown is clicked.");
		}
		else {
			logger.info("Dropdown is not displayed.");
		}
	}	
	
	public static boolean selectDropdownOption(WebDriver driver, WebElement dropdownElement, String option) {
		boolean isOptionVerified = false;
	    try {
	        WebElement optionElement = driver.findElement(By.xpath("//*[text()='" + option + "']"));
	        if (optionElement.isDisplayed()) {
	            optionElement.click();
	             System.out.println("Option '" + option + "' selected from dropdown");
	             isOptionVerified = true;
	         } else {
	             System.out.println("Option '" + option + "' is not displayed in the dropdown");
	         }
	    } catch (Exception e) {
	    	System.out.println("Exception occurred while selecting option '" + option + "': " + e.getMessage());
	    }
	    return isOptionVerified;
	    
	}

}