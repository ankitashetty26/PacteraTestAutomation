package pactera.automation.maintest;


import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MainTestCase {

	public static WebDriver driver=null;
	@Rule
	public TestName name=new TestName();
	public static  Properties CONFIG=null;
	

	public WebDriver getDriver(){
				
		try
		{ if(CONFIG==null){				
			 // Loading config.properties file.
			 CONFIG = new Properties();
			 FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\pactera\\automation\\tests\\config.properties");
				CONFIG.load(fs);
			}
		}
		catch(Exception e){}
		if(driver==null){
			if(CONFIG.getProperty("browserType").equals("Mozilla")){
				driver=new FirefoxDriver();
			}			
			/* else if (CONFIG.getProperty("browserType").equals("IE")) {
		 			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "\\BrowserDrivers\\IEDriverServer.exe");
		 			DesiredCapabilities capabilities=new DesiredCapabilities();
		 			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		 			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 			driver = new InternetExplorerDriver(capabilities);
				}*/ 
			else if (CONFIG.getProperty("browserType").equals("Chrome")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir")
									+ "\\BrowserDrivers\\chromedriver.exe");
					driver = new ChromeDriver();
		}
			}
		return driver;
	}	
	
}
	
	

