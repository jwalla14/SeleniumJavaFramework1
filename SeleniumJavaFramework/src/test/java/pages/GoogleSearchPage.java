package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	private static WebElement element = null;
	
	public static WebElement textbox_search(WebDriver driver) {
		
		element = driver.findElement(By.name("q"));
		return element;
	}
	
	public static WebElement button_search(WebDriver driver) {
		
		element = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[4]/form[1]/div[2]/div[1]/div[3]/center[1]/input[1]"));
		return element;
	}
	
	
}
