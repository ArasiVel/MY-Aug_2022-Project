package com.salesForce.tests.pages.home;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesForce.tests.pages.base.BasePage;

public class HomePage extends BasePage {
@FindBy(xpath ="//*[@id=\"Chatter_Tab\"]/a")WebElement Chatter;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String GetTextFromSalesforceElement() {
		String text = readText(Chatter, "text form field");
		
		String path=captureWebElementScreenshot(Chatter, "search");
		try {
			report.attachScreeshot(path);
		} catch (IOException e) {
			report.logTestFailedWithException(e);
		}
		return text;
	}
		
		
					
		

		}
		
		
		
	
