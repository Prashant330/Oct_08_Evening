package spotifyTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.HomePage;
import pomClasses.LogInPage;

public class SongSearchAndPlay {
	
	public static void main(String[] args) {
		
		
		System.out.println("Heeellelle");
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				
				WebDriver driverTest = new ChromeDriver();
				driverTest.manage().window().maximize();
			//	driverTest.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				driverTest.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driverTest.get("https://open.spotify.com/");
				
				HomePage homePage = new HomePage(driverTest);
				
				homePage.ClickOnLoginButton();
				
				LogInPage logInPage = new LogInPage(driverTest);
				
				logInPage.EnterEmailId();
				logInPage.EnterPassword();
				logInPage.uncheckRememberMeCheckBox();
				logInPage.ClickOnLogInButton();
				
				homePage.ClickOnSearchBox();
				homePage.ClickOnSearchField();
				homePage.SongPlayButton();
	}

}
