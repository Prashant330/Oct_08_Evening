package TestNGTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomClasses.AccountOverViewPage;
import pomClasses.HomePage;
import pomClasses.LogInPage;
import pomClasses.MyPlayListPage;

public class DemoTestNGClass {
	
	WebDriver driver;
	HomePage homePage;
	LogInPage logInPage;
	
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		System.out.println("before Class");
		
		if(browserName.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		 driver = new ChromeDriver();
	}
		
			if(browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\vaibu\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
			
			 driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("BeforeTest- TestClass2");}
	
	@BeforeClass
	public void createPOMObjects() {
		 homePage = new HomePage(driver);
		 logInPage = new LogInPage(driver);
	}
	
	@BeforeMethod
	public void LoggedInAndSpotifyHomePageOpen() {
		System.out.println("before Method");
		driver.get("https://open.spotify.com/");
		
		 homePage = new HomePage(driver);
		
		homePage.ClickOnLoginButton();
		
		LogInPage logInPage = new LogInPage(driver);
		
		logInPage.EnterEmailId();
		logInPage.EnterPassword();
		logInPage.uncheckRememberMeCheckBox();
		logInPage.ClickOnLogInButton();
	}
	//"C:\Users\vaibu\Downloads\geckodriver-v0.32.1-win32\geckodriver.exe"
	@Test
	public void CreatePlayList() {
		System.out.println("Test1- TestClass2");
		
		homePage.ClickCreateplayListButton();
		MyPlayListPage myPlayListPage = new MyPlayListPage(driver);
		myPlayListPage.ClickOnSearchField();
		myPlayListPage.ClickOnAddSongs();
		
	}
	
	@Test
	public void NotificationOnOF() throws InterruptedException {
		System.out.println("Test2- TestClass2");
		
		homePage.ClickOnAccInfo();
		Thread.sleep(2000);
		homePage.ClickOnAccountButton();
		
		 ArrayList<String> addr1 = new ArrayList<String>(   driver.getWindowHandles()   );
		  
		 driver.switchTo().window(addr1.get(1));//switch to child browser
		 
		 String title =driver.getTitle();
		 System.out.println(title);
		 String url = driver.getCurrentUrl();
		 System.out.println(url);
		 if(url.equals("https://www.spotify.com/in-en/account/overview/?utm_source=spotify&utm_medium=menu&utm_campaign=your_account"))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }
		 
		 AccountOverViewPage accountOverViewPage = new AccountOverViewPage(driver);
		 
		 accountOverViewPage.ClickOnAdvHiddenPopUp();
		 
		 accountOverViewPage.ClickOnNotificationButton();
		 
		 accountOverViewPage.ClickNotificationButtonBox();
		 driver.close();
		 driver.switchTo().window(addr1.get(0));
		 
		 String title2 =driver.getTitle();
		 System.out.println(title2);
		 String url2 = driver.getCurrentUrl();
		 System.out.println(url2);
		 if(url2.equals("https://open.spotify.com/"))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }
	}
	@Test
	public void ListenSong() throws InterruptedException {
		System.out.println("Test3- TestClass2");
	
	
	homePage.ClickOnSearchBox();
	homePage.ClickOnSearchField();
	homePage.SongPlayButton();}
	
	@AfterMethod
	public void LogOutMethod()
	{
		System.out.println("after Method- TestClass2");
	homePage.ClickOnAccInfo();
	homePage.LogOutApplication();
		
	}
	
	@AfterClass
	public void clearPOMObjects() {
		System.out.println("after Class- TestClass2");
		homePage = null;
		logInPage =  null;
		
	}
	@AfterTest
	public void QuitBrowser() {
		System.out.println("AfterTest- TestClass2");
		driver.quit();
		driver = null;
		System.gc();//Garbage collector
	}
	
	

	
}
