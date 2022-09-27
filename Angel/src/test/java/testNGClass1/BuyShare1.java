package testNGClass1;

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

import AngelOne.BuySharePage;
import AngelOne.ConfirmOrder;
import AngelOne.HeaderPage;
import AngelOne.HiddenDivisionPopUp;
import AngelOne.LogOutAngelOne;
import AngelOne.LoginPage;
import AngelOne.MarketsPage;
import AngelOne.OrderCancelAlert;
import AngelOne.OrderPage;
import AngelOne.SellSharePage;
import setUp.Base;
import utils.Utility;

public class BuyShare1 extends Base {
	
	private LoginPage loginPage;
	private WebDriver driver;
	private HiddenDivisionPopUp hiddenDivisionPopUp;
	private HeaderPage headerPage;
	private MarketsPage marketsPage;
	private BuySharePage buySharePage;
	private ConfirmOrder confirmOrder;
	private  SellSharePage sellSharePage;
	private OrderPage orderPage;
	private OrderCancelAlert orderCancelAlert;
	private LogOutAngelOne logOutAngelOne ;
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
	public void createPOMObject() {
	  loginPage =new LoginPage(driver);
	  hiddenDivisionPopUp =new HiddenDivisionPopUp(driver);
	  headerPage = new HeaderPage(driver);	
	  marketsPage=new MarketsPage(driver);
	  marketsPage=new MarketsPage(driver);
	  buySharePage=new BuySharePage(driver);
	  headerPage = new HeaderPage(driver);	
	  
	  marketsPage=new MarketsPage(driver);
	  sellSharePage =new SellSharePage(driver);
	  headerPage=new HeaderPage(driver);
	  confirmOrder =new ConfirmOrder(driver);
	  logOutAngelOne =new LogOutAngelOne(driver);
	  orderPage =new OrderPage(driver);
	  
 }
		
@BeforeMethod
	public void loginAngelOne() throws InterruptedException, EncryptedDocumentException, IOException {
			driver.get("https://trade.angelbroking.com/Login");
			  
			
	  String data= Utility.excelSheet("TestData", 12, 0);
		loginPage.sendUserName(data);
		 
	 String data1= Utility.excelSheet("TestData", 13, 0);
		loginPage.sendPassword(data1);
		loginPage.clickOnSignINButton();
		 
	
	 boolean result= hiddenDivisionPopUp.clickOnTabClose();
			 
		    soft=new SoftAssert();
}	
		
@Test
   public void buyShare() {
     testId=10112;
	     headerPage.openMarket();
		 
	 String marketPageURL=driver.getCurrentUrl();
	 soft.assertEquals(marketPageURL, "https://trade.angelbroking.com/trade/trading/watchlist");
			 
     
		 marketsPage.clickOnSearch();
	     marketsPage.sendSearchInput();
	     marketsPage.clickOnAddIcon();
	 
	     marketsPage.clickOnBuyButton();
	
	     buySharePage.clickOnTopLoss();
	     buySharePage.selectQuantity();
	     buySharePage.selectTargetPrice();
	     buySharePage.selectDeliveryType();
// 	     buySharePage.clickOnDelivery();
//	     buySharePage.selectIntarday();
	     
	     buySharePage.clickOnSubmitButton();
	     
	     String buyPageURL=driver.getCurrentUrl();
	     
	     soft.assertEquals(buyPageURL, "https://trade.angelbroking.com/trade/trading/watchlist");
	     soft.assertAll();
       }

@Test
  public void sellShare() {
    testId=10113;
        headerPage.openMarket();
		 
	 String marketPageURL=driver.getCurrentUrl();
	 soft.assertEquals(marketPageURL, "https://trade.angelbroking.com/trade/trading/watchlist");
			 
		 marketsPage.clickOnSearch();
	     marketsPage.sendSearchInput();
	     marketsPage.clickOnAddIcon();
         marketsPage.clickOnSellButton();
     
	     sellSharePage.clickOnTopLoss();
	     sellSharePage.selectQuantity();
	     sellSharePage.selectTargetPrice();
	     sellSharePage.selectDeliveryType();
//	     sellSharePage.clickOnDelivery();
//	     sellSharePage.selectIntarday();
	     sellSharePage.clickOnSubmitButton();
	     
	    String sellPageURL=driver.getCurrentUrl();
	 	soft.assertEquals(sellPageURL, "https://trade.angelbroking.com/trade/trading/watchlist");
	     
	    soft.assertAll();
   }


@AfterMethod 
  public void confirmShareOrder(ITestResult result1) throws InterruptedException, IOException {
	if (ITestResult.FAILURE==result1.getStatus()) {
		Utility.capture(driver, testId);
	}
	  Thread.sleep(5000);
	  boolean result=  confirmOrder.clickOnAlertOkButton();
	   
	    confirmOrder.clickOnConfirmButton();
	    
	   Thread.sleep(3000);
	//   boolean result1= orderPage.clickOnCancelOrder();
		 
	    Thread.sleep(3000);
	 
	    headerPage.openProfileList();
	    logOutAngelOne.clickOnLogOut();
			
		String homePageURL3=driver.getCurrentUrl();
		soft.assertEquals(homePageURL3, "https://trade.angelbroking.com/login/");
			
		soft.assertAll();
	}

@AfterClass
public void cleanPOMObject() {
	  loginPage =null;
	  hiddenDivisionPopUp =null;
	  headerPage = null;	
	  marketsPage=null;
	  marketsPage=null;
	  buySharePage=null;
	  headerPage = null;	
	  
	  marketsPage=null;
	  sellSharePage =null;
	  headerPage=null;
	  confirmOrder =null;
	  logOutAngelOne =null;
	  
}


@AfterTest
public void closeBrowser() {
	 driver.quit();
	  driver=null;
	  System.gc();
}
	
}
