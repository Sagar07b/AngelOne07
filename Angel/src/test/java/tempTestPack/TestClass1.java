package tempTestPack;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AngelOne.BuySharePage;
import AngelOne.ConfirmOrder;
import AngelOne.HeaderPage;
import AngelOne.HiddenDivisionPopUp;
import AngelOne.LogOutAngelOne;
import AngelOne.LoginPage;
import AngelOne.MarketsPage;
import AngelOne.OrderCancelAlert;
import AngelOne.OrderPage;
import utils.Utility;

public class TestClass1 {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		 
		System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\Automation notes\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://trade.angelbroking.com/Login");
	
	LoginPage loginPage =new LoginPage(driver);
	
	String data= Utility.excelSheet("Velocity", 12, 0);
	loginPage.sendUserName(data);
    String data1= Utility.excelSheet("Velocity", 13, 0);
		 
	loginPage.sendPassword(data1);
		loginPage.clickOnSignINButton();
		
	HiddenDivisionPopUp hiddenDivisionPopUp =new HiddenDivisionPopUp(driver);
		hiddenDivisionPopUp.clickOnTabClose();
		
	HeaderPage headerPage = new HeaderPage(driver);	
		headerPage.openMarket();
		
	MarketsPage marketsPage = new MarketsPage(driver);
		marketsPage.clickOnSearch();
		marketsPage.sendSearchInput();
		marketsPage.clickOnAddIcon();
		marketsPage.clickOnBuyButton();
		
	BuySharePage buySharePage =new BuySharePage(driver);
		buySharePage.clickOnTopLoss();
		buySharePage.selectQuantity();
		buySharePage.selectTargetPrice();
		 Thread.sleep(5000);
		buySharePage.selectDeliveryType();
		buySharePage.clickOnSubmitButton();
		
    ConfirmOrder confirmOrder =new ConfirmOrder(driver);
        confirmOrder.clickOnAlertOkButton();
		confirmOrder.clickOnConfirmButton();
		
	OrderPage orderPage =new OrderPage(driver);
		orderPage.clickOnCancelOrder();
		
	OrderCancelAlert orderCancelAlert =new OrderCancelAlert(driver);
		orderCancelAlert.clickOnOkButton();
		orderCancelAlert.clickOnOkButton();
		
		  headerPage=new HeaderPage(driver);
		  headerPage.openProfileList();
		  
		  LogOutAngelOne logOutAngelOne =new LogOutAngelOne(driver);
		  logOutAngelOne.clickOnLogOut();
	}
}
