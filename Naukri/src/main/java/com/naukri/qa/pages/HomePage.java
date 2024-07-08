package com.naukri.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.Base.TestBase;


public class HomePage extends TestBase{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='nI-gNb-header__logo nI-gNb-company-logo']")
	WebElement logo;
	
	@FindBy(xpath="//div[@class='view-profile-wrapper']")
	WebElement completeProfileBtn;
	
	//Action
	public void verifyLogo()
	{
		boolean logoStatus = logo.isDisplayed();
	}
	
	public ProfilePage clickOnCompleteProf() {
		completeProfileBtn.click();
		
		return new ProfilePage();
	}
}
