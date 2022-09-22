package AngelOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutAngelOne {
	 @FindBy(xpath="//a[text()='Logout']")
	  private WebElement logOut;

		public LogOutAngelOne(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void clickOnLogOut() {
			logOut.click();
		}
}
