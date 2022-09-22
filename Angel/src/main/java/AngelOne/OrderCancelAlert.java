package AngelOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCancelAlert {
	@FindBy(xpath="//button[text()='Ok']")
	private WebElement clickOnOkButton;
	
	public OrderCancelAlert(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOkButton() {
		clickOnOkButton.click();
	}
}
