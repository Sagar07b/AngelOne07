package AngelOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmOrder {

	@FindBy(xpath="//button[@id='btnconfirmOk_Alert']")
	private WebElement alertOkButton;
	
	@FindBy(xpath="//button[text()='CONFIRM']")
	private WebElement confirmButton;
	
	public ConfirmOrder(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnConfirmButton() {
		confirmButton.click();
	}
	
	public boolean clickOnAlertOkButton() {
		boolean result= alertOkButton.isDisplayed();
		
		if(result == true)
		{
			alertOkButton.click();
		}
		  return result;
	}
 
	
	
}
 
