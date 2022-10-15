package com.salesForce.tests.pages.login;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesForce.tests.pages.base.BasePage;



public class LoginPage extends BasePage{
	
	
@FindBy(id ="username") WebElement username;
@FindBy(id ="password") WebElement password;
@FindBy(id ="Login") WebElement loginButton;

public LoginPage(WebDriver driver) {
	super(driver);
}

	public void enterUserName(String userName) {
		waitUntilVisible(username,"user name");
		enterText(username,userName,"username");
	}
	public void enterPassword(String PassWord) {
	enterText(password,PassWord,"password");
	
}
	public void clickLoginButton() {
		clickElement(loginButton, "login Button");
	}
	
	
	public void login(String userName, String PassWord) {
		enterUserName(userName);
		enterPassword(PassWord);
		clickLoginButton();
		
		
		
			
			

		}
		
		
		
		
	}
		

	

  
