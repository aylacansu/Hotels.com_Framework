package com.qa.hotels.tests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.MainPage;
import com.qa.hotels.utils.AppConstants;

public class MainPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
	
		basePage=new BasePage();
		prop=basePage.init_proporties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage=new MainPage(driver);
		Thread.sleep(5000);
		}
	
	@Test(priority=1,enabled=true,description="verify that,MainPage Title is true or not ")
	public void verifyMainPageTitle() {
		String title=mainPage.getMainPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, AppConstants.MAIN_PAGE_TITLE);
	}

	@Test(priority=2,enabled=true,description="Select all requirements")
	public void verifySelectRequeriments(){
		mainPage.selectRequirements();
	
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
