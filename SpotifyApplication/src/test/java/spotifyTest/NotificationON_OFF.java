package spotifyTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.AccountOverViewPage;
import pomClasses.HomePage;
import pomClasses.LogInPage;

public class NotificationON_OFF {
	
public static void main(String[] args) {
		
		
		System.out.println("Heeellelle");
		
		
System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().window().maximize();
		driverTest.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverTest.get("https://open.spotify.com/");
		
		
		HomePage homePage = new HomePage(driverTest);
		
		homePage.ClickOnLoginButton();
		
		LogInPage logInPage = new LogInPage(driverTest);
		
		logInPage.EnterEmailId();
		logInPage.EnterPassword();
		logInPage.uncheckRememberMeCheckBox();
		logInPage.ClickOnLogInButton();
		
		homePage.ClickOnAccInfo();
		homePage.ClickOnAccountButton();
		
		 ArrayList<String> addr1 = new ArrayList<String>(   driverTest.getWindowHandles()   );
		  
		 driverTest.switchTo().window(addr1.get(1));//switch to child browser
		 
		 AccountOverViewPage accountOverViewPage = new AccountOverViewPage(driverTest);
		 
		 accountOverViewPage.ClickOnAdvHiddenPopUp();
		 
		 accountOverViewPage.ClickOnNotificationButton();
		 
		 accountOverViewPage.ClickNotificationButtonBox();
		
	}

}


