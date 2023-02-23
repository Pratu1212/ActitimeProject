package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	@FindBy(xpath="//div[.='Add New']")
	private WebElement Anwlink;
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement Anclink;
	
	@FindBy(xpath="(//input[@Placeholder='Enter Customer Name'])[2]")
	private WebElement cstmrlink;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement dscblink;
	@FindBy(xpath="(//div[@class='dropdownButton'])[15]")
	private WebElement lstbxlink;
	@FindBy(xpath="(//div[.='Galaxy Corporation'])[7]")
	private WebElement ourcomp;
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createbtn;
	
	
	
	public TaskPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAnwlink() {
		return Anwlink;
	}

	public WebElement getAnclink() {
		return Anclink;
	}
	public WebElement getCstmrlink() {
		return cstmrlink;
	}
	public WebElement getDscblink() {
		return dscblink;
	}
	public WebElement getLstbxlink() {
		return lstbxlink;
	}

	public WebElement getOurcomp() {
		return ourcomp;
	}

	public WebElement getCreatebtn() {
		return createbtn;
	}
	// bussiness logic or generic method
	public void completetaks(String custname ,String Description) throws InterruptedException
	{
		Anwlink.click();
		Anclink.click();
		cstmrlink.sendKeys(custname);
		dscblink.sendKeys(Description);
		//lstbxlink.click();
		Thread.sleep(3000);
	//	ourcomp.click();
		createbtn.click();
		
		
		
		
		
		
	}
}
