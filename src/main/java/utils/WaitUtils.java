package utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.WaitConstants;

public class WaitUtils {

	public static boolean waitForElement(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_BE_CLICKABLE);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementFound = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isElementFound;
	}
	
	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		boolean isElementDisappered = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementDisappered = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isElementDisappered;
	}
	
	public static File waitForFile(String downloadDir, String fileNamePrefix, String fileExtension) {
        File dir = new File(downloadDir);
        File[] matchingFiles;
        int attempts = 0;
        do {
            matchingFiles = dir.listFiles((dir1, name) -> name.startsWith(fileNamePrefix) && name.endsWith(fileExtension));
            if (matchingFiles != null && matchingFiles.length > 0) {
                return matchingFiles[0];
            }
            attempts++;
            try {
                Thread.sleep(1000); // Wait for 1 second before retrying
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (attempts < 30); // Wait for up to 30 seconds
        return null;
    }
}
