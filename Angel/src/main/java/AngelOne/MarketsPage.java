package AngelOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketsPage {

  @FindBy(xpath="//input[@id='project']")
  private WebElement searchShare;
	
  @FindBy(xpath="(//li[@class='ui-menu-item'])[1] ")
  private WebElement addselectedShare;
	
  @FindBy(xpath="//a[@id='watchlistBuy']")
  private WebElement buyShare;
	
  @FindBy(xpath="//a[text()='SEll']")
  private WebElement sellShare;

	public MarketsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSearch() {
		searchShare.click();
	}
	
	public void sendSearchInput() {
		searchShare.sendKeys("idea");
	}
	
	public void clickOnAddIcon() {
		addselectedShare.click();
	}
	
	public void clickOnBuyButton() {
		buyShare.click();
	}
	
	public void clickOnSellButton() {
		sellShare.click();
	}
}
 
