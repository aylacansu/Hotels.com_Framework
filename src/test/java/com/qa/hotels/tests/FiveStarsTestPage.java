package com.qa.hotels.tests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.FiveStarsPage;
import com.qa.hotels.pages.FourStarsPage;
import com.qa.hotels.pages.MainPage;
import com.qa.hotels.pages.ThreeStarsHiltonPage;
import com.qa.hotels.pages.ThreeStarsPage;

public class FiveStarsTestPage {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	ThreeStarsHiltonPage threeStarsHiltonPage;
	ThreeStarsPage threeStarsPage;
	FourStarsPage fourStarsPage;
	FiveStarsPage fiveStarsPage;

	@BeforeTest
	public void setUp() throws InterruptedException {

		basePage = new BasePage();
		prop = basePage.init_proporties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage = new MainPage(driver);
		fiveStarsPage = mainPage.goToFiveStarsPage();
		Thread.sleep(5000);
	}

	@Test(priority = 1, enabled = true, description = "Verify that,all 5 stars hotels are in 10 miles.")
	public void verifyFiveStarsTest() throws InterruptedException {
		boolean result = threeStarsPage.ThreeStarsHotels();
		System.out.println(result);

		Assert.assertFalse(result);

	}

	@Test(priority = 2, enabled = true,description="All 5 stars Hotel names are in 10 miles ")

	public void verifyIsFive() throws InterruptedException {

		System.out.println(fiveStarsPage.IsFiveStarsInTenMiles());

	}

	@AfterTest
	public void tearDown() {
		System.out.println("Five Stars Test Page  ended");
		driver.quit();
	}

}
