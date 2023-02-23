package com.Actitime.Testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert1 {
	@Test
	public void demonstration() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String expectedtitle = "Google";
		String actualtitle = driver.getTitle();
		
		
		/*if (expectedtitle.equals(actualtitle)) {
			System.out.println("title is matching");
		}
		else {
			System.out.println("title is not matching");
		}*/
	
		Assert.assertEquals(expectedtitle, actualtitle);
		driver.close();
	}
	
}
