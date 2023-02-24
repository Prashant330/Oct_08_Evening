package TestNGTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pomClasses.HomePage;
import pomClasses.LogInPage;

public class Facebook {
	WebDriver driver;
	HomePage homePage;
	LogInPage logInPage;
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	@Test
	public void test() {
		System.out.println("Test");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
}
}