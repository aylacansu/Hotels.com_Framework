package com.qa.hotels.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.utils.ElementUtil;
import com.qa.hotels.utils.JavaScriptUtil;

public class ThreeStarsPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;

	public ThreeStarsPage(WebDriver driver) {

		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	// locators

	By threeStars = By.id("f-label-star-rating-3");
	By distance = By.xpath("//a[@data-menu='sort-submenu-distance']");
	By city = By.xpath("//a[text()='City center']");

	
	//public boolean  IsThreeStarsInTenMiles() throws InterruptedException {

	public List<String> IsThreeStarsInTenMiles () throws InterruptedException {

		elementUtil.waitForElementVisible(threeStars);
		elementUtil.doClick(threeStars);

		javaScriptUtil.scrollDownWithIterator();

		elementUtil.waitForElementVisible(distance);
		elementUtil.doClick(distance);

		elementUtil.waitForElementPresent(city);
		elementUtil.doClick(city);

		List<WebElement> distanceList = driver.findElements(By.cssSelector("ul[class='property-landmarks']"));
		List<WebElement> hList = driver.findElements(By.cssSelector("a[class='property-name-link']"));

		List<String> hotelNames = new ArrayList<String>();

		for (int i = 0; i < distanceList.size(); i++) {
			String distances = distanceList.get(i).getText();
			String dist = distances.split("\\s+")[0];
			double dist1 = Double.parseDouble(dist);

			if (dist1 <= 10) {
				
		//System.out.println("Three Stars Hotel in 10 miles");		
       //System.out.println(hotelNames.add(hList.get(i).getText() + "\n"));
				hotelNames.add(hList.get(i).getText() + "\n");
        //return true;
			}
		}
		System.out.println("Three Stars Hotel in 10 miles");
		//return  false;
		return hotelNames;
	}

	
	
	public boolean ThreeStarsHotels() throws InterruptedException {
	
		List<WebElement> distanceList = driver.findElements(By.cssSelector("ul[class='property-landmarks']"));
	 for (int i = 0; i < distanceList.size(); i++) {
			String distances = distanceList.get(i).getText();
			String dist = distances.split("\\s+")[0];
			double dist1 = Double.parseDouble(dist);

			if (dist1 > 10) {
      
	   return false;
			}
		}
		return true;
	
	}

}
