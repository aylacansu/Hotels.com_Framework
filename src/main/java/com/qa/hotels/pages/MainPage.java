package com.qa.hotels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.utils.AppConstants;
import com.qa.hotels.utils.ElementUtil;


public class MainPage extends  BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	public MainPage(WebDriver driver){
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	

	By destination=By.id("qf-0q-destination");  
	By checkIn=By.xpath("//*[@id='qf-0q-localised-check-in']");
	By checkOut=By.xpath("//*[@id='qf-0q-localised-check-out']");
	By room=By.xpath("//select[@id='qf-0q-rooms']");
	By adults=By.xpath("//select[@id='qf-0q-room-0-adults']");
	By children=By.xpath("//select[@id='qf-0q-room-0-children']");
	By AgeChild1=By.xpath("//*[@id='qf-0q-room-0-child-0-age']");
	By AgeChild2=By.xpath("//*[@id='qf-0q-room-0-child-1-age']");
	By search=By.xpath("//button[text()='Search']");
	By checkInDate=By.xpath("//*[@data-date='2020-7-4']");
	By checkOutDate=By.xpath("//*[@data-date='2020-7-10']");
	
	
	public void selectRequirements(){
 	
    elementUtil.waitForElementPresent(destination);
	elementUtil.doClick(destination);
	elementUtil.doSendKeys(destination,"Boston,");
	
	elementUtil.getElement(destination).sendKeys(Keys.ARROW_DOWN);
	elementUtil.getElement(destination).sendKeys(Keys.ENTER);
	elementUtil.waitForElementPresent(checkIn);	
	elementUtil.doClick(checkIn);
	elementUtil.waitForElementPresent(checkInDate);
	elementUtil.doClick(checkInDate);
	elementUtil.waitForElementPresent(checkOut);
	elementUtil.doClick(checkOut);
	elementUtil.waitForElementPresent(checkOutDate);
	elementUtil.doClick(checkOutDate);

	elementUtil.waitForElementPresent(room);
	elementUtil.selectDropDownByVisibleText(driver, room,AppConstants.ROOM);
	elementUtil.waitForElementPresent(adults);
	elementUtil.selectDropDownByVisibleText(driver, adults, AppConstants.ADULT);
	elementUtil.waitForElementPresent(children);
	elementUtil.selectDropDownByVisibleText(driver, children, AppConstants.CHILDREN);
	elementUtil.waitForElementPresent(AgeChild1);
	elementUtil.selectDropDownByVisibleText(driver, AgeChild1, AppConstants.AGE_CHILD_1);
	elementUtil.waitForElementPresent(AgeChild2);
	elementUtil.selectDropDownByVisibleText(driver, AgeChild2, AppConstants.AGE_CHILD_2);
	elementUtil.doClick(search);
	
		
	}
	
	public String getMainPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.MAIN_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
		
	}
	
	
  public ThreeStarsHiltonPage goToHiltonPage(){
		selectRequirements();
		return new ThreeStarsHiltonPage(driver);
	}
	
	
	public ThreeStarsPage goToThreeStarsPage() {
         selectRequirements();
	return new ThreeStarsPage(driver);
     
	}

	public FourStarsPage goToFourStarsPage() {
        selectRequirements();
	return new FourStarsPage(driver);
    
	}
	
	public FiveStarsPage goToFiveStarsPage() {
        selectRequirements();
	return new FiveStarsPage(driver);
    
	}
	
	
}
	
	
