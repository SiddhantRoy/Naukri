package com.naukri.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.Base.TestBase;

public class LoginPage extends TestBase{

	//Using PageFactory we initialize the Page object element 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(id = "login_Layer")
	WebElement Login;
	
	@FindBy(xpath = "//label[text()='Email ID / Username']/following-sibling::input[@placeholder ='Enter your active Email ID / Username']")
	WebElement username;
	
	@FindBy(xpath = "//label[text()='Password']/following-sibling::input[@placeholder ='Enter your password']")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginBtn;
	
	//Actions
	public void LoginBtn() {
		Login.click();
	}
	
	
	public HomePage Login(String Username, String Password) throws InterruptedException {
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginBtn.click();
		Thread.sleep(5000);
		
		return new HomePage();
	}
	
}
