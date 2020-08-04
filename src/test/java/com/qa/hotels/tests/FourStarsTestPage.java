package com.qa.hotels.tests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.FourStarsPage;
import com.qa.hotels.pages.MainPage;
import com.qa.hotels.pages.ThreeStarsHiltonPage;
import com.qa.hotels.pages.ThreeStarsPage;

public class FourStarsTestPage {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	ThreeStarsHiltonPage threeStarsHiltonPage;
	ThreeStarsPage threeStarsPage;
	FourStarsPage fourStarsPage;

	@BeforeTest
	public void setUp() throws InterruptedException {

		basePage = new BasePage();
		prop = basePage.init_proporties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage = new MainPage(driver);
		fourStarsPage = mainPage.goToFourStarsPage();

		Thread.sleep(5000);
	}

	@Test(priority = 1, enabled = true,description="Verify that,all 4 stars hotels are in 10 miles.")
	public void verifyFourStarsTest() throws InterruptedException {
		boolean result = threeStarsPage.ThreeStarsHotels();
		System.out.println(result);

		Assert.assertFalse(result);

	}

	@Test(priority = 2, enabled = true,description="All 4 stars Hotel names are in 10 miles ")

	public void verifyIsFour() throws InterruptedException {

		System.out.println(fourStarsPage.IsFourStarsInTenMiles());
		
	}

	@AfterTest
	public void tearDown() {
		System.out.println("FourStars Test Page  ended");
		driver.quit();
	}

}
