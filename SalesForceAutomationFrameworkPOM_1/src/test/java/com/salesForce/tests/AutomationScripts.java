package com.salesForce.tests;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesForce.Test.base.BaseTest;
import com.salesForce.tests.pages.home.HomePage;
import com.salesForce.tests.pages.login.LoginPage;
import com.salesForce.tests.utility.CommonUtilities;


public class AutomationScripts extends BaseTest {

		@Test
	
		public static void SFTC01_emptyPassword() throws InterruptedException {
		
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String userName=CU.getApplicationProperty("userName", applicationPropertiesFile);
		driver.findElement(By.id("password")).click();
		waitUntilPageLoads();
		driver.findElement(By.id("Login")).click();
		
		}		
		


	@Test
	
	public static void SFTC02_login()  {
		
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String userName=CU.getApplicationProperty("userName", applicationPropertiesFile);
		String PassWord=CU.getApplicationProperty("PassWord", applicationPropertiesFile);
		LoginPage login = new LoginPage(driver);
		waitUntilPageLoads();
		login.login(userName, PassWord);
		
	}
	
@Test
		
		public static void SFTC03_rememberUsername() throws InterruptedException {
	String expected="Chatter";
	waitUntilPageLoads();
	CommonUtilities CU = new CommonUtilities();
	Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
	String userName=CU.getApplicationProperty("userName", applicationPropertiesFile);
	String PassWord=CU.getApplicationProperty("PassWord", applicationPropertiesFile);
	LoginPage login = new LoginPage(driver);
	login.login(userName, PassWord);
	waitUntilPageLoads();
	HomePage homepage = new HomePage(driver);
	waitUntilPageLoads();
	String actual=homepage.GetTextFromSalesforceElement();
	System.out.println(actual);
	Assert.assertEquals(actual,expected );
	report.logTestInfo("testscript execution completed"); 
	
}
			
		
			
	@Test
	
	
	public static void  SFTC04A_forgotPassword() throws InterruptedException  {
		
		WebElement forgetPassword =driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]"));
		waitUntilVisible(forgetPassword,"forgetPassword");
		clickElement(forgetPassword, "forget password");
		WebElement forgotPWField=driver.findElement(By.id("un"));
		enterText(forgotPWField,"userName", "forgotPWField");
		WebElement continueButton= driver.findElement(By.xpath("//*[@id=\"continue\"]"));
		waitUntilVisible( continueButton," continue Button");
		clickElement(continueButton, "continue button");
		
		
}

	
	@Test
	
	public static void SFTC04B_loginErrorMessage() throws InterruptedException  {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String invalid_username=CU.getApplicationProperty("invalid_username", applicationPropertiesFile);
		String invalid_pw=CU.getApplicationProperty("invalid_pw", applicationPropertiesFile);
		LoginPage login = new LoginPage(driver);
		login.login(invalid_username, invalid_pw);
		waitUntilPageLoads();
		
		}
		
	@Test
	
	public static void SFTC05_userMenu() throws InterruptedException {
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String userName=CU.getApplicationProperty("userName", applicationPropertiesFile);
		String PassWord=CU.getApplicationProperty("PassWord", applicationPropertiesFile);
		LoginPage login = new LoginPage(driver);
		login.login(userName, PassWord);
		waitUntilPageLoads();
		WebElement menuDropDown=driver.findElement(By.xpath("//*[@id=\"userNav-arrow\"]"));
		waitUntilPageLoads();
		clickElement(menuDropDown, "menu DropDown");
		
	}
			}
	

		
		
		
	
