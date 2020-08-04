package com.qa.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;

import com.qa.hotels.utils.ElementUtil;
import com.qa.hotels.utils.JavaScriptUtil;

public class ThreeStarsHiltonPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;

	public ThreeStarsHiltonPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil=new JavaScriptUtil(driver);

	}

	// locators

	By threeStars = By.xpath("//*[@id='f-star-rating-3']");

	public boolean IsHiltonThree() throws InterruptedException {

		elementUtil.waitForElementVisible(threeStars);
		elementUtil.doClick(threeStars);

		javaScriptUtil.scrollDownWithIterator();

		List<WebElement> hotels = driver.findElements(By.cssSelector("a[class='property-name-link']"));

		for (int i = 0; i < hotels.size(); i++) {
			String hotelNames = hotels.get(i).getText();

			if (hotelNames.contains("Hilton")) {

				System.out.println("Found Hotel is " + hotelNames);
				return true;

			}
		}
		return false;
	}

}
