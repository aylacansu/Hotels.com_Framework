package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.MainPage;
import com.qa.hotels.pages.ThreeStarsHiltonPage;

public class ThreeStarsHiltonTestPage {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	ThreeStarsHiltonPage threestarsHiltonPage;

	@BeforeTest
	public void setUp() throws InterruptedException {

		basePage = new BasePage();
		prop = basePage.init_proporties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage = new MainPage(driver);
		threestarsHiltonPage = mainPage.goToHiltonPage();
		Thread.sleep(5000);
	}

	@Test(priority=1,enabled=true,description="Verify that,Hilton is in 3 stars Hotels or not")

	public void verifyIsHiltonThree() throws InterruptedException {

		Assert.assertTrue(threestarsHiltonPage.IsHiltonThree());

	}

	@AfterTest
	public void tearDown() {
		System.out.println("Hilton Test ended");
		driver.quit();
	}

}
