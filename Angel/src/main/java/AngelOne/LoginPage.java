package AngelOne;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class LoginPage {
private WebDriver driver;

	@FindBy(xpath="//input[@id='txtUserID']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='txtTradingPassword']")
	private WebElement password;
	
	@FindBy(xpath="//a[@id='loginBtn']")
	private WebElement signInButton;
	
	public LoginPage(WebDriver driver)  {
		PageFactory.initElements(driver,this);
		this.driver=driver;
		  
	}
	 
	public void sendUserName(String user) {
		 
		//userName.sendKeys("S1603196");
		userName.sendKeys(user);
		 
		
	}
	
	public void sendPassword(String pass) {
		
		password.sendKeys(pass);
		//password.sendKeys("Sagar@1437");
	}
	
	public void clickOnSignINButton() {
		signInButton.click();
	}
}


