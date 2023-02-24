package spotifyTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.AccountOverViewPage;
import pomClasses.HomePage;
import pomClasses.LogInPage;
import pomClasses.MyPlayListPage;

public class CreatePlaylistAndSongTest {
	
public static void main(String[] args) throws InterruptedException {
	
	
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
			
			homePage.ClickCreateplayListButton();
			
			
		
			
			
			MyPlayListPage myPlayListPage = new MyPlayListPage(driverTest);
			
			myPlayListPage.ClickOnSearchField();
			
			
			
			myPlayListPage.ClickOnAddSongs();
			
			
			
			 homePage.ClickOnAccInfo();
			 Thread.sleep(2000);
			 homePage.LogOutApplication();
			 
		
			
			
			
}

}
