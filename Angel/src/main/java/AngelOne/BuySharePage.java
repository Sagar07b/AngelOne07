package AngelOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuySharePage {

	@FindBy(xpath="//li[@id='tabSLOrder']")
	private WebElement stoploss;
	
	@FindBy(xpath=" //input[@id='txtBuySellPopQuantity']")
	private WebElement selectQantity;
	
	@FindBy(xpath="//input[@id='txtBuySellPopTriggerPrice']")
	private WebElement selectTargetPrice;
	
	@FindBy(xpath="(//span[text()='DELIVERY'])[1]")
	private WebElement delivery;
	
	@FindBy(xpath="(//span[text()='INTRADAY'])[1]")
	private WebElement  Intarday;
	
	@FindBy(xpath="(//span[text()='AMO DELIVERY'])[1]")
	private WebElement AMOdelivery;
	
	@FindBy(xpath="(//span[text()='AMO INTRADAY'])[1]")
	private WebElement AMOIntarday;
	

	@FindBy(xpath="(//span[@class='filter-option pull-left'])[8]")
	private WebElement getTextResult;
	
	 
	
	@FindBy(xpath="//button[@id='btnOrderPadSubmit']")
	private WebElement submitButton;
	
	public BuySharePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTopLoss() {
		stoploss.click();
	}
	
	public void selectQuantity() {
		selectQantity.clear();
		selectQantity.sendKeys("5");
	}
	
	public void selectTargetPrice() {
		selectTargetPrice.clear();
		selectTargetPrice.sendKeys("8.9");
	}
	public void selectDeliveryType() {
		String text=getTextResult.getText();
		if(text.equals("AMO DELIVERY"))
		{
			AMOdelivery.click();
			 
			AMOIntarday.click();
		}
		else
		{
			delivery.click();
		
		    Intarday.click();
		}
	}
	public void clickOnSubmitButton() {
		submitButton.click();
	}
	
 
}


