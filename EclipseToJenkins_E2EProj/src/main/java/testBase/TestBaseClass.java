package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utilities.TestUtil;

public class TestBaseClass {
		
	public static WebDriver driver;
	public static Properties prop;
		
	public TestBaseClass() // CONSTRUCTOR CLASS 
	{
		// READING THE PROPERTIES 
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:/Users/17327/E2EJenkins/E2EJenkinsProject/src/main/java/config/Config.properties");
			prop.load(file);
			
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
		
	public static void initialization() 
	{
		// READ THE PROPERTIES FROM CONFIG.PROPERTIES FILE
		
				String BrowserName = prop.getProperty("browser");
				if(BrowserName.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver.exe");
					driver = new ChromeDriver();
				}
				else if(BrowserName.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\17327\\Documents\\Jyothi\\Selenium\\Webdrivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				else if(BrowserName.equals("firefox"))
				{
					System.setProperty("webdriver.ie.driver", "C:\\Users\\17327\\Documents\\Jyothi\\Selenium\\Webdrivers\\IEDriverServer64.exe");
					driver = new InternetExplorerDriver();
				}
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
				
				
				driver.get(prop.getProperty("url"));
	}
	

}
