package AngelOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    private WebDriver driver;  
    private Actions act;
	
	@FindBy(xpath="//div[@class='checkbox checkbox-primary ']")
	private WebElement selectCheckBoxOrder;

	@FindBy(xpath="( //a[text()='Cancel'])[1]")
	private WebElement cancelOrder;
	
	@FindBy(xpath="(//a[@data-toggle='modal'])[2]")
	private WebElement orderDetails;
	

	@FindBy(xpath="//button[text()='Ok']")
	private WebElement clickOnOkButton;
	
	@FindBy(xpath="(//span[@class='filter-option pull-left'])[8]")
	private WebElement getTextResult;
	
	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnCheckBox() {
		selectCheckBoxOrder.click();
	}
	
	public  boolean clickOnCancelOrder() throws InterruptedException {
		 
			boolean result1= orderDetails.isDisplayed();
			
			if(result1 == true)
			{
				act=new Actions(driver);
				 act.moveToElement(orderDetails).moveToElement(cancelOrder).click().build().perform();
				 Thread.sleep(4000);
				 clickOnOkButton.click();
				 clickOnOkButton.click();
			}
			  return result1;
		 
	} 
	 
	
	 
	
}
