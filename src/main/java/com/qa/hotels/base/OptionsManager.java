package com.qa.hotels.base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	public ChromeOptions co;
	public FirefoxOptions fo;
	public Properties prop;
	
	
	
	
	public OptionsManager(Properties prop){
		this.prop=prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if (prop.getProperty("headless").equals("yes"))
			co.addArguments("--headless");
		if (prop.getProperty("incognito").equals("yes"))
			co.addArguments("--incognito");
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if (prop.getProperty("headless").equals("yes"))
			fo.addArguments("--headless");
		if (prop.getProperty("incognito").equals("yes"))
			fo.addArguments("--incognito");
		return fo;
	}

}
