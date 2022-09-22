package setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

	
	public static WebDriver openChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\Automation notes\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		   WebDriver driver = new ChromeDriver();
		   return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:\\Software Testing\\Automation notes\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
 		
	   WebDriver  driver = new FirefoxDriver();
	     return driver;
	}
	
	public static WebDriver openMicrosoftEdgexBrowser() {
		System.setProperty("webdriver.edge.driver","D:\\Software Testing\\Automation notes\\Selenium\\edgedriver_win64\\msedgedriver.exe");

			WebDriver driver = new EdgeDriver  ();
		        return driver;
	}
	
	public static WebDriver openOperaBrowser() {
		System.setProperty("webdriver.opera.driver","D:\\Software Testing\\Automation notes\\Selenium\\operadriver_win64\\operadriver_win64\\operadriver.exe");

		WebDriver driver = new OperaDriver();
        return driver;
	}	
	
	public static WebDriver openBrowser() {
		System.setProperty("webdriver.opera.driver","D:\\Software Testing\\Automation notes\\Selenium\\operadriver_win64\\operadriver_win64\\operadriver.exe");

		WebDriver driver = new OperaDriver();
        return driver;
	}	
	
}
