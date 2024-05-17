package utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import constants.FileConstants;

public class CommonUtils {

	//Created methods to capture screenshot 'CaptureScreenShots()'
	//then called as ->" CommonUtils.CaptureScreenShots(driver); " in LoginTest.java to take screenshot of that test
//	public static void CaptureScreenShots(WebDriver driver) {		
//		TakesScreenshot page = (TakesScreenshot) driver;
//		File src = page.getScreenshotAs(OutputType.FILE);
//		File destination = new File(System.getProperty("user.dir")+"/src/main/java/reports/sample.png");
//		src.renameTo(destination);
//	}
	//this method is dynamic
	public static String captureScreenShots(WebDriver driver) {
		String filePath = FileConstants.SCREENSHOTS_FOLDER_PATH;
		TakesScreenshot page = (TakesScreenshot) driver;
		File src = page.getScreenshotAs(OutputType.FILE);
		File dst = new File(filePath);
		src.renameTo(dst);
		return filePath;		
	}
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
	}
	
	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
}
