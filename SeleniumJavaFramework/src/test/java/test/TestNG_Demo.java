package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Config.PropertiesFile;

public class TestNG_Demo {

	WebDriver driver = null;
	public static String browsername=null;

	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver ();
			
		}
		PropertiesFile.setProperties();
		

	}

	@Test
	public void googleSearch() {


		//go to google.com

		driver.get("https://google.com");

		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		//click on search button
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/form[1]/div[2]/div[1]/div[3]/center[1]/input[1]")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).sendKeys(Keys.RETURN);
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}

	@AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();
		//driver.quit();
		System.out.println("Test Completed Successfully!");
		PropertiesFile.setProperties1();
	}

}