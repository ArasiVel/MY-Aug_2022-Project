package com.salesForce.Test.base;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.salesForce.tests.utility.CommonUtilities;
import com.salesForce.tests.utility.GenerateReports;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Logger logger =LogManager.getLogger(BaseTest.class);
	public static GenerateReports report=null;
	
	@BeforeTest
	public static void setupBeforeTest() {
		report=GenerateReports.getInstance();
		report.startExtentReport();
	}
	@Parameters({ "browsername" })
	@BeforeMethod
	public static void setUp( String browsername,Method m) {
		report.startSingleTestReport(m.getName());
		System.out.println("beofore method execution started");
		setDriver(browsername);
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		gotoUrl(url);
		waitUntilPageLoads();
		
	}
	
	
	@AfterMethod
	public static void tearDown() {
		logger.info("after method execution is started");
		report.logTestInfo("after method execution is started");
		closeBrowser();
	}
	
	@AfterTest
	public static void teardownAfterTest() {
		report.endReport();
	}

	public static void setDriver(String browser) {

		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
	}
	
	
	public static void gotoUrl(String url) {
		driver.get(url);
	}

public static void waitUntilPageLoads() {
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
}

public static void enterText(WebElement element, String text, String objName) {
	if (element.isDisplayed()) {
		clearElement(element, objName);
		element.sendKeys(text);
		report.logTestInfo("text entered in " + objName + "field");
		
	} else {
		report.logTestFailed("fail: \" + objName + \" element not displayed");
	}
}


public static void clearElement(WebElement element, String objName) {
	
	
}
public static void clickElement(WebElement element, String objName) {
	if (element.isDisplayed()) {
		element.click();
		report.logTestInfo("pass:" + objName + " element clicked");
	} else {
		report.logTestFailed("fail:" + objName + "  element not displayed");

	}
}

public static void waitUntilVisible(WebElement element, String objName) {
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(element));
}


public static void closeBrowser() {
	driver.close();
}

public static void closeAllbrowser() {
	driver.quit();
	
	
	
}

}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	