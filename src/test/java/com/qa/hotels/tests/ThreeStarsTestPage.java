package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.ThreeStarsPage;
import com.qa.hotels.pages.MainPage;

public class ThreeStarsTestPage {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	ThreeStarsPage threeStarsPage;

	@BeforeTest
	public void setUp() throws InterruptedException {

		basePage = new BasePage();
		prop = basePage.init_proporties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage = new MainPage(driver);
		threeStarsPage = mainPage.goToThreeStarsPage();

		Thread.sleep(5000);
	}

	@Test(priority = 1, enabled = true, description = "Verify that,all 3 stars hotels are in 10 miles.")
	public void verifyThreeStarSizeTest() throws InterruptedException {
		boolean result = threeStarsPage.ThreeStarsHotels();
		System.out.println(result);

		Assert.assertFalse(result);

	}

	@Test(priority = 2, enabled = true, description = "All 3 stars Hotel names are in 10 miles ")
	public void verifyIsThree() throws InterruptedException {

		System.out.println(threeStarsPage.IsThreeStarsInTenMiles());

	}

	@AfterTest
	public void tearDown() {
		System.out.println("Three Stars Test Page  ended");
		driver.quit();
	}

}
