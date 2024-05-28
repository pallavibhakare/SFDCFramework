package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebElementUtils {

	 // Method to click on a WebElement
    public static void clickElement( WebElement ele, String objName) {
    	 if (ele.isEnabled()) {
           ele.click();
           System.out.println(objName + " button is clicked");
       } else {
           System.out.println("Button element is not enabled");
       }
    }

    // Method to enter text into a WebElement
    public static void enterText(WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Failed to enter text into the element: " + e.getMessage());
        }
    }

    // Method to clear a WebElement
    public static void clearElement( WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            System.out.println("Failed to clear the element: " + e.getMessage());
        }
    }
    
    public static void moveToElement(WebDriver driver, WebElement element, String objName) {
    	Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        System.out.println("Moved to the element: " + objName);
    }
    
    public static List<String> getDropdownOptionNames(WebDriver driver, List<WebElement> eleOptions){
    	
		List<String> optionNames = new ArrayList<>();
		List<WebElement> options = eleOptions;
		for(WebElement option: options) {
			optionNames.add(option.getText());
		}
		return optionNames;
	}
    
    public static String getParentWindow(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();
		return parentWindow;
	}
	public static void switchTochildWindow(WebDriver driver ,WebElement childWindownId) {
		Set<String> childWindows = driver.getWindowHandles();
		String childWindow="";
		for(String window : childWindows) {
			childWindow = window;
			driver.switchTo().window(childWindow);
		}
		
	}
	public static void clickAndSwitchToNewWindow(WebDriver driver, WebElement clickableElement) {
		String mainWindowHandle = driver.getWindowHandle();
		clickableElement.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String windowHandle : allWindowHandles) {
			if(!windowHandle.equals(mainWindowHandle)){
				driver.switchTo().window(windowHandle);
				break;
			}
		}		
	}
	public static void backToParentWindow(WebDriver driver) {
		driver.switchTo().window(getParentWindow(driver));		
	}
	public static void selectRandomOptionFromDropdown(WebElement seletElement) {
		Select dropdown = new Select(seletElement);
		List<WebElement> options = dropdown.getOptions();
		int randomIndex = new Random().nextInt(options.size());
		dropdown.selectByIndex(randomIndex);
	}
	public static void selectFirstCellInTable(WebDriver driver, WebElement tableElement) {
		//first row 
		WebElement firstRow = tableElement.findElement(By.cssSelector("tr.dataRow"));
		//first cell within first row
		WebElement firstCellLink = firstRow.findElement(By.cssSelector("th a"));
		firstCellLink.click();
	}	
	
	public static void clickDropDown(WebElement dropdownElement  ) {
		if(dropdownElement.isDisplayed()) {
			dropdownElement.click();		
		}		
	}	
	
	public static boolean selectDropdownOption(WebDriver driver, WebElement dropdownElement, String optionText) {
		boolean isOptionVerified = false;
		try {
            Select select = new Select(dropdownElement);
            List<WebElement> options = select.getOptions();
            for (WebElement option : options) {
                if (option.getText().equals(optionText)) {
                    option.click();
                    System.out.println("Option '" + optionText + "' selected from dropdown");
                    isOptionVerified = true;
                    break;
                }
            }
            if (!isOptionVerified) {
                System.out.println("Option '" + optionText + "' is not displayed in the dropdown");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting option '" + optionText + "': " + e.getMessage());
        }
        return isOptionVerified;
	    
	}
	
}
