package AngelOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
     private WebDriver driver;
	private WebDriverWait wait;
     
	@FindBy(xpath="//a[@id='mnDashboard']")
	private WebElement dashboard;
	
	@FindBy(xpath="//a[@id='mnPort']")
	private WebElement portfolio;
	
	@FindBy(xpath="//a[@id='mnMarkets']")
	private WebElement markets;
	
	@FindBy(xpath="//a[@id='mnOrders']")
	private WebElement orders;
	
	@FindBy(xpath="//a[@id='mnAdvisory']")
	private WebElement advisory;
	
	@FindBy(xpath="//a[@id='mnFunds']")
	private WebElement funds;
	
	@FindBy(xpath="//a[@id='mnReports']")
	private WebElement reports;
	
	@FindBy(xpath="//a[@id='mnMore']")
	private WebElement mores;
	
	@FindBy(xpath="//i[@class='icon-search']")
	private WebElement searchIcon;
	
	@FindBy(xpath="//input[@id='DashboardsearchControl']")
	private WebElement searchInput;
	
	@FindBy(xpath="//i[@title='Watchlist']")
	private WebElement watchlist;
	
	@FindBy(xpath="//a[text()='S1603196 ']")
	private WebElement profile;
	
	public HeaderPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void openDashboard() {
		dashboard.click();
	}
	
	public void openPortfolio() {
		portfolio.click();
	}
	
	public void openMarket() {
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(markets));
		markets.click();
	}
	
	public void openOrders() {
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(orders));
		orders.click();
	}
	
	public void openAdvisory() {
		advisory.click();
	}
	
	public void openFunds() {
		funds.click();
	}
	
	public void openReports() {
		reports.click();
	}
	
	public void openMores() {
		mores.click();
	}
	
	public void clickOnSearchIcon() {
		searchIcon.click();
	}
	
	public void sendSearchInput() {
		searchInput.sendKeys("tcs");
	}
	
	public void openWatchlist() {
		watchlist.click();
	}
	
	public void openProfileList() {
	    wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(profile));
		profile.click();
	}
	
	
	
}
