package setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

	
	public static WebDriver openChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Browsers\\chromedriver.exe");
		
		   WebDriver driver = new ChromeDriver();
		   return driver;
	}
	
  	public static WebDriver openFirefoxBrowser() {
  		System.setProperty("webdriver.gecko.driver", "src\\\\test\\\\resources\\\\Browsers\\geckodriver.exe");
 		
  	   WebDriver  driver = new FirefoxDriver();
  	     return driver;
 	}
	
	public static WebDriver openMicrosoftEdgexBrowser() {
		System.setProperty("webdriver.edge.driver","src\\\\test\\\\resources\\\\Browsers\\msedgedriver.exe");

			WebDriver driver = new EdgeDriver  ();
		        return driver;
	}
	
	 
	public static WebDriver openOperaBrowser() {
		System.setProperty("webdriver.opera.driver","src\\\\test\\\\resources\\\\Browsers\\operadriver.exe");

		WebDriver driver = new OperaDriver();
        return driver;
  }	
	 
	 
}
