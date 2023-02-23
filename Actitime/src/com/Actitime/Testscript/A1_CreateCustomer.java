package com.Actitime.Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.A1_BaseClass;
import com.Actitime.GenericLibrary.A2_FileLibrary;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

public class A1_CreateCustomer extends A1_BaseClass  {
	A2_FileLibrary f=new A2_FileLibrary();
	@Test
	public void CreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.getTasklnk().click();
		
		
		TaskPage tp=new TaskPage(driver);
		String data = f.readDataFromExcelSheet("sheet1", 1, 1);
		String data1 = f.readDataFromExcelSheet("sheet1", 1, 2);
		tp.completetaks(data, data1);
		String expected=data;
		String actualdata=driver.findElement(By.xpath("(//div[.='HDFC001'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expected, actualdata);
		Reporter.log("assertion pass",true);
		s.assertAll();
		

		
		
	}
	
}
