package com.naukri.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.qa.Base.TestBase;
import com.naukri.qa.pages.HomePage;
import com.naukri.qa.pages.LoginPage;
import com.naukri.qa.pages.ProfilePage;

public class ProfileTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	
	public ProfileTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		loginPage.LoginBtn();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnCompleteProf();
	}
	
	@Test
	public void verifyProfileName() {
		String profName = profilePage.getUsername();
		Assert.assertEquals(profName, "Siddhant Sankar Parida");
	}
	
	@Test
	public void verifyResumeheadlineDtl() throws InterruptedException {
		
		String resumeheadlineActualDtl = "Looking for better opportunity as a QA Automation Engineer/SDET. M.tech in Software Engineering with 5 years of relevant IT experience as a Quality Analyst with Key Skills - Java, JavaScript,Selenium, REST API Automation, Test Automation, Regression.";
		String resumeheadlineActualDtl_wotDot = "Looking for better opportunity as a QA Automation Engineer/SDET. M.tech in Software Engineering with 5 years of relevant IT experience as a Quality Analyst with Key Skills - Java, JavaScript,Selenium, REST API Automation, Test Automation, Regression";
		
		profilePage.ResumeHeadlineEdit();
		String resumeDetails = profilePage.ResumeheadlineTextBox();
		if(resumeDetails.equals(resumeheadlineActualDtl)) {
			profilePage.UpdateResumeheadlineTextBox(resumeheadlineActualDtl_wotDot);
			profilePage.clickOnsaveBtn();
			
		}else {
			profilePage.UpdateResumeheadlineTextBox(resumeheadlineActualDtl);
			profilePage.clickOnsaveBtn();
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
