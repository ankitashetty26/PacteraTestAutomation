package pactera.automation.tests;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pactera.automation.maintest.MainTestCase;

import com.thoughtworks.selenium.Wait;

import static org.junit.Assert.*;

public class TestHomePageNavigationSuccessful extends MainTestCase {

	/*
	 * Declare and initialise the webdriver as static to initialise only once
	 */
	public static WebDriver driver = null;
	public static Properties CONFIG=null;
	
	/*
	 * Before annotation: Initialise the driver
	 */
	@Before
	public void initialise()
		{
		driver = getDriver();
	}
		 
		
	/*
	 * After annotation: EXIT
	 */
	@After
	public void exit()
	{
	driver.quit();
	}
	
	
	@Test
	public void TestHomePageNavigation() {
		
		System.out.print("Running first test case:: Verify if navigation to www.pactera.com is sucessful------------- \n");
		/*
		 * Maximise the window before hitting the URL  
		 */
		driver.manage().window().maximize();
		System.out.print("Maximising the browser window \n");
		
		/*
		 * Hit the server www.pactera.com  
		 */
		driver.get("http://www.pactera.com");
		System.out.print("Typing the URL \n Navigating to Pactera HomePage \n");
		
		/*
		 * Wait for page to load
		 */
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	    
		/*
		 * Verify if the main element at homepage is present. Here it is the presence of News Link in the home page
		 */
		try
		{
		boolean findNewsLinkInHomePage = driver.findElement(By.xpath("//a[contains(@href,'http://www.pactera.com/news/')]")).isDisplayed();
		if(findNewsLinkInHomePage!= false)
		{
			System.out.print("TEST CASE PASSED: User is sucessfully navigated to Pactera homepage \n");
		}
		else
		{
			System.out.print("TEST CASE FAILED: User is NOT sucessfully navigated to Pactera homepage \n");
		}
		}
		
		catch(Exception e)
		{
			System.out.print("TEST CASE FAILED:  User is NOT sucessfully navigated to Pactera homepage \n");
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/*
		 * Print before exiting the driver
		 */
		System.out.print("End of Test");
	}
}
