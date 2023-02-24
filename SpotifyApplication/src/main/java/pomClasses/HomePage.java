package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	
	@FindBy    (xpath = "//span[text()='Log in']")
	private WebElement LogInButton;
	
	@FindBy    (xpath = "//span[text()='Search']")
	private WebElement SearchBoxButton;
	
	@FindBy    (xpath = "//span[text()='Create Playlist']")
	private WebElement CreateplayListButton;
	
	@FindBy    (xpath = "//input[contains(@class,'Type__TypeElement')]")
	private WebElement SearchField;
	
@FindBy    (xpath = "//button[contains(@class,'odcjv30UQnjaTv4sylc0')]")
	
	private WebElement AccInfoButton;

	@FindBy    (xpath = "//div[text()='The Monster Song (From \"KGF Chapter 2\")']")
	private WebElement SongPlayButton;
	
	@FindBy    (xpath = "//span[text()='Account']")
	private WebElement AccountButton;
	
	@FindBy    (xpath = "//Span[text()='Log out']")
	private WebElement LogOutButton;
	
	
	private WebDriverWait wait;
	private WebDriver driver;
	private Actions actions;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		this.driver = driver;
		wait = new WebDriverWait(driver,20);
		actions =new Actions(this.driver);
	}
	
	public void ClickOnLoginButton()
	{
		LogInButton.click();
	}
	public void ClickOnSearchBox()
	{
		wait.until(ExpectedConditions.visibilityOf(SearchBoxButton));
		SearchBoxButton.click();	
	}
	
	public void ClickCreateplayListButton()
	{
		CreateplayListButton.click();
	}
	public void ClickOnSearchField()
	{
		SearchField.click();
		SearchField.sendKeys("KGF");
			
	}
	public void SongPlayButton()
	{
		wait.until(ExpectedConditions.visibilityOf(SongPlayButton));
		
		actions.moveToElement(SongPlayButton).doubleClick().build().perform();	
	}
	
	public void ClickOnAccInfo()
	{
		AccInfoButton.click();
	}
	
	public void ClickOnAccountButton()
	{
		actions.moveToElement(AccountButton).click().build().perform();
	}
	public void LogOutApplication()
	{
		actions.moveToElement(LogOutButton).click().build().perform();
	}
	

}
