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

/*
 * Test to search for a particular text on the text box and verify the search results are displayed
 */
public class TestSearchScenario extends MainTestCase {
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
	public void TestSearchResults() {
		
		System.out.print("Running second test case:: Verify the search results are displayed sucessfully ------------- \n");
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
		boolean findNewsLinkInHomePage = driver.findElement(By.xpath("//a[contains(@href,'http://www.pactera.com/news/')]")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.print(" User is sucessfully navigated to Pactera homepage \n");
		/*
		 * Find the Search text box to type in the search query
		 */
		 WebElement findSearchTextBox = driver.findElement(By.xpath("//input[@id='s']"));
		 
		 /*
		  * Find the search button to click  
		  */
		 WebElement findSearchButton = driver.findElement(By.xpath("//input[@id='searchsubmit']"));
		 
		 /*
		  * Type the search query as 'test automation'
		  */
		 findSearchTextBox.sendKeys("test automation");
		 System.out.print("Typing search text 'test automation' in search box \n"); 
		 /*
		  * Click on the search button 
		  */
		 findSearchButton.click();
		 System.out.print("Clicking on submit button to retrieve search results \n");
		 /*
		  * Wait for the next page to load - Here I have used breadcrumb element to be loaded on next page 
		  */
		 WebDriverWait wait = new WebDriverWait(driver, 5);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='breadcrumb']")));
		  
		  /*
		   * Verify the search results are displayed	
		   */
		  boolean searchResults = driver.findElement(By.xpath("//div[@id='content' and @class='content-wide']")).isDisplayed();
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.MILLISECONDS);
		 try{
		  if(searchResults!= false)
			{
				System.out.print("TEST CASE PASSED: Search completed sucessfully \n");
			}
			else
			{
				System.out.print("TEST CASE FAILED: Search is not completed sucessfully \n");
			}
			}
			
			catch(Exception e)
			{
				System.out.print("TEST CASE FAILED: Search is not completed sucessfully \n");
			}
			
	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		 * 
		 * Print before exiting the driver
		 */
		System.out.print("End of Test");
	}
}
	


