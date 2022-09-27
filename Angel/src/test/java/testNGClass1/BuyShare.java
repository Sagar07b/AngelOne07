package testNGClass1;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AngelOne.HeaderPage;
import AngelOne.HiddenDivisionPopUp;
import AngelOne.LoginPage;
import setUp.Base;
import utils.Utility;

public class BuyShare extends Base {
private WebDriver driver;
private LoginPage loginPage;
private HiddenDivisionPopUp hiddenDivisionPopUp;
private HeaderPage headerPage;
private SoftAssert soft;
private int testId;

@Parameters ("browser")

@BeforeTest
public void launchBrowser(String browserName)
{
	if(browserName.equals("Chrome"))
	{
		 driver=openChromeDriver();
	}
	
	if(browserName.equals("MicroSoftEdge"))
 	{
		 driver=openMicrosoftEdgexBrowser();
     }
	
	if(browserName.equals("Opera"))
 	{
 		 driver=openOperaBrowser();

     }
	
	driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
}

	 @BeforeClass
	public void lounchBrowser() {
		 loginPage =new LoginPage(driver);
		 headerPage = new HeaderPage(driver);
		 headerPage = new HeaderPage(driver);
		 hiddenDivisionPopUp =new HiddenDivisionPopUp(driver);
	}
	
	@BeforeMethod
	public void loginAngelOne() throws EncryptedDocumentException, IOException {
		
		driver.get("https://trade.angelbroking.com/Login");
		
	    String data= Utility.excelSheet("TestData", 12, 0);
			loginPage.sendUserName(data);
	   String data1= Utility.excelSheet("TestData", 13, 0);
				 
			loginPage.sendPassword(data1);
			loginPage.clickOnSignINButton();
			
		  boolean result= hiddenDivisionPopUp.clickOnTabClose();
			  
	    soft=new SoftAssert();
	    String homePageURL=driver.getCurrentUrl();
		soft.assertEquals(homePageURL, "https://trade.angelbroking.com/portfolio/equity/index_v1");
			
		soft.assertAll();
	}
	
	@Test
	public void openMarket() {
		  testId=10110;
	 headerPage.openMarket();
	 
	 String marketPageURL=driver.getCurrentUrl();
	 soft.assertEquals(marketPageURL, "https://trade.angelbroking.com/trade/trading/watchlist");
		 
	 soft.assertAll();
	}
	
	@Test 
	public void openOrder() throws InterruptedException {
	testId=10111;
	headerPage.openOrders();
		
	 String orderPageURL=driver.getCurrentUrl();
	 soft.assertEquals(orderPageURL, "https://trade.angelbroking.com/trade/trading/orderbook");
		 
	soft.assertAll();
	}
	
	@Test 
	public void open() throws InterruptedException {
	testId=10111;
	headerPage.openOrders();
		
	 String orderPageURL=driver.getCurrentUrl();
	 soft.assertEquals(orderPageURL, "https://trade.angelbroking.com/trade/trading/orderbook");
		 Assert.fail();
	soft.assertAll();
	}
	
	@AfterMethod
	public void captureScreenShot(ITestResult result1) throws IOException {
		if (ITestResult.FAILURE==result1.getStatus()) {
			Utility.capture(driver, testId);
		}
	}
	@AfterClass
	public void  cleanPOMObject() {
		 loginPage =null;
		 headerPage = null;
		 headerPage = null;
		  hiddenDivisionPopUp =null;
		
	}
	 @AfterTest
	  public void closeBrowser() {
		  driver.quit();
		  driver=null;
		  System.gc();
	  }
	  	
}
