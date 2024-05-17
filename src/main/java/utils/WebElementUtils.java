package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtils {

	 // Method to click on a WebElement
    public static void clickElement( WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Failed to click on the element: " + e.getMessage());
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


}
