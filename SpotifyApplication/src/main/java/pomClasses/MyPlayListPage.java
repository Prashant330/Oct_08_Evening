package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPlayListPage {
	

	@FindBy    (xpath = "(//button[@data-testid='add-to-playlist-button'])[1]")
	private WebElement ADDSONG;
	
	@FindBy    (xpath = "//input[@role='searchbox']")
	private WebElement SearchField;
	
	private WebDriverWait wait;
	
//	@FindBy    (xpath = "//input[@id='login-password']")
//	private WebElement password;
//	
//	@FindBy    (xpath = "//span[@class='Indicator-sc-1airx73-0 kHTWAk']")
//	private WebElement rememberMeCheckBox;
//	
//	@FindBy    (xpath = "//span[text()='Log In']")
//	private WebElement LogInButton;
//	
	
	
	
	
	public MyPlayListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver,20);
		
		
	}
	
	public void ClickOnAddSongs()
	{
		wait.until(ExpectedConditions.elementToBeClickable(ADDSONG));
		ADDSONG.click();
	}
	
	public void ClickOnSearchField()
	{
		SearchField.click();
		SearchField.sendKeys("KGF");
	}
//	public void EnterPassword()
//	{
//		password.sendKeys("Prashant420#");
//	}
//	public void UncheckRememberMeCheckBox()
//	{
//		rememberMeCheckBox.sendKeys("Prashant420#");
//	}
//
//	public void ClickOnLogInButton()
//	{
//		LogInButton.click();
//	}

}
