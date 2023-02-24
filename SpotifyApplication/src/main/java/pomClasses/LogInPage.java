package pomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
	
	@FindBy    (xpath = "//input[@type='text']")
	private WebElement emailidUsername;
	
	@FindBy    (xpath = "//input[@id='login-password']")
	private WebElement password;
	
	@FindBy    (xpath = "//span[@class='Indicator-sc-1airx73-0 kHTWAk']")
	private WebElement rememberMeCheckBox;
	
	@FindBy    (xpath = "//span[text()='Log In']")
	private WebElement LogInButton;
	
	
	
	private WebDriver driver;
	
	private JavascriptExecutor javascriptExecutor;
	
	
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
		JavascriptExecutor js = (JavascriptExecutor)driver;
	}
	
	public void EnterEmailId()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(emailidUsername));
		emailidUsername.sendKeys("pp72845@gmail.com");
	}
	public void EnterPassword()
	{
		password.sendKeys("Prashant420#");
	}
	public void uncheckRememberMeCheckBox()
	{ 
		rememberMeCheckBox.click();
	}

	public void ClickOnLogInButton()
	{
		LogInButton.click();
	}
	
	
}
