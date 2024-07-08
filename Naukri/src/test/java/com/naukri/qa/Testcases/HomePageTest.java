package com.naukri.qa.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.qa.Base.TestBase;
import com.naukri.qa.pages.HomePage;
import com.naukri.qa.pages.LoginPage;
import com.naukri.qa.pages.ProfilePage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		loginPage.LoginBtn();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void clickOncompleteProfile() throws InterruptedException {
		profilePage = homePage.clickOnCompleteProf();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

	
}
