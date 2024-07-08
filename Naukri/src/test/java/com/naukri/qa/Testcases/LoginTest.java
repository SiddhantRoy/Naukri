package com.naukri.qa.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.qa.Base.TestBase;
import com.naukri.qa.pages.HomePage;
import com.naukri.qa.pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	//create constructor of LoginTest
	public LoginTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test
	public void loginPage() throws InterruptedException {
		loginPage.LoginBtn();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void terDown() {
		driver.quit();
	}

}
