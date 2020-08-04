package com.qa.hotels.pages;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.utils.ElementUtil;
import com.qa.hotels.utils.JavaScriptUtil;

public class FiveStarsPage  extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;

	public FiveStarsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil=new JavaScriptUtil(driver);
	}	
	
		
By fiveStars = By.id("f-label-star-rating-5");
By distance=By.xpath("//a[@data-menu='sort-submenu-distance']");
By city=By.xpath("//a[text()='City center']");	

	

public List<String> IsFiveStarsInTenMiles() throws InterruptedException {


	  
	  elementUtil.doClick(fiveStars);
	  
	  javaScriptUtil.scrollDownWithIterator();
	  
	  elementUtil.waitForElementVisible(distance);
	  elementUtil.doClick(distance);
	  
	  elementUtil.waitForElementPresent(city);
	  elementUtil.doClick(city);
	  
	  
	 
	  List<WebElement> distanceList=driver.findElements(By.cssSelector("ul[class='property-landmarks']"));
	 
	  
	  List<WebElement> hList=driver.findElements(By.cssSelector("a[class='property-name-link']"));
	 
	  
	  List<String>hotelNames=new ArrayList<String>();
	  
	 
	  
	 for (int i = 0; i < distanceList.size(); i++) {
	
		String distances = distanceList.get(i).getText();
		String dist=distances.split("\\s+")[0].trim(); 
		double dist1=Double.parseDouble(dist);
		
		if (dist1 <= 10) {
			 
			 hotelNames.add(hList.get(i).getText() + "\n");
			 
			}


	}
	 System.out.println("Five Stars Hotel in 10 miles");
	 
	 return hotelNames;
}

public boolean FiveStarsHotels() throws InterruptedException {
	
	
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

	  














