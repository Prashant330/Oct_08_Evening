package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountOverViewPage {
	
	@FindBy    (xpath = "(//a[@data-testid='Menu Item'])[4]")
	private WebElement NotificationButton;
	
	@FindBy    (xpath = "(//span[@class='Indicator-sc-1airx73-0 bpcByA'])[1]")
	private WebElement NotificationCheckBox;
	

	@FindBy    (xpath = "(//button[@aria-label='Close'])[2]")
	private WebElement AdvHiddenPopUp;
	
	
	
	private WebDriverWait wait;
	
	public AccountOverViewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver,20);
	}
	
	
	public void ClickOnNotificationButton()
	{wait.until(ExpectedConditions.visibilityOf(NotificationButton));
	
		NotificationButton.click();
	}
	public void ClickNotificationButtonBox()
	{
		NotificationCheckBox.click();
	}
	public void ClickOnAdvHiddenPopUp()
	{
		wait.until(ExpectedConditions.elementToBeClickable(AdvHiddenPopUp));
		AdvHiddenPopUp.click();
	}


}
