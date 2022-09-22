package AngelOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HiddenDivisionPopUp {

     @FindBy(xpath="//button[@id='tabclose']")	
	  private WebElement tabClose;
     
     public HiddenDivisionPopUp (WebDriver driver) {
    	 PageFactory.initElements(driver, this);
     }
     
	public boolean clickOnTabClose() {
		boolean result= tabClose.isDisplayed();
		
		if(result == true)
		{
		  tabClose.click();
		}
		  return result;
	}
	
	
}