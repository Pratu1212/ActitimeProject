package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.LoginPage;

public class A1_BaseClass {
	A2_FileLibrary f=new A2_FileLibrary();
	
	
	public static WebDriver driver;
	@BeforeSuite
	
	
	public void databaseconnection()
	{
		Reporter.log("Database connected",true);
	}
	@AfterSuite
	
	public void databasedisconnection()
	{
		Reporter.log("Database disconnected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Url = f.readDataFromePropertyFile("url");
		driver.get(Url); 
		Reporter.log("browser launched successfully",true);
	}
	@AfterClass
	
	public void closeBrowser()
	{
		Reporter.log("Browser closed successfully ",true);
	}
	
	@BeforeMethod
	
	public void LoginToActitime() throws IOException
	{
		String UN = f.readDataFromePropertyFile("username");
		String PW = f.readDataFromePropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PW);
		Reporter.log("Logged in successfully",true);
	}
	@AfterMethod
	public void logoutFromActitime() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.getLogoutlnk().click();
		driver.close();
		Reporter.log("Logged out successfully",true);
	}
}
