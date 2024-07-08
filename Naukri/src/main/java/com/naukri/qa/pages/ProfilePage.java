package com.naukri.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.Base.TestBase;

public class ProfilePage extends TestBase{
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='fullname']")
	WebElement userName;
	
	@FindBy(xpath="//span[text()='Resume headline']/following-sibling::span[@class='edit icon']")
	WebElement resumeHeadline;
	
	@FindBy(xpath = "//textarea[@id='resumeHeadlineTxt']")
	WebElement resumeHeadlineTxtBox;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	public String getUsername() {
		String user = userName.getText();
		return user;	
	}
	
	public void ResumeHeadlineEdit() {
		resumeHeadline.click();
	}
	
	public String ResumeheadlineTextBox() {
		String resumeTxt = resumeHeadlineTxtBox.getText();
		return resumeTxt;
	}
	
	public void UpdateResumeheadlineTextBox(String value) {
		resumeHeadlineTxtBox.clear();
		resumeHeadlineTxtBox.sendKeys(value);
	}
	
	public void clickOnsaveBtn() throws InterruptedException {
		saveBtn.click();
		Thread.sleep(5000);
	}

}
