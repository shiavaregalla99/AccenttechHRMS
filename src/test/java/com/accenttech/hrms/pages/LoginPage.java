package com.accenttech.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accenttech.hrms.base.BaseClass;

public class LoginPage {
//Page Object Model Without page factory
	//WebElement userName=      BaseClass.driver.findElement(By.xpath("//input[@id='txtUsername']"));
 //	 WebElement password=      BaseClass.driver.findElement(By.xpath("//input[@id='txtPassword']"));
	//WebElement loginButton=   BaseClass.driver.findElement(By.xpath("//input[@id='btnLogin']"));
	
	//Page Object Model With page factory
	
	@FindBy(xpath="//input[@id='txtUsername']")
	public WebElement userName;
	@FindBy(xpath="//input[@id='txtPassword']")
	public WebElement password;
	@FindBy(xpath="//input[@id='btnLogin']")
	public WebElement loginButton;
	@FindBy(xpath="//span[@id='spanMessage']")
	public WebElement errorMessage;
	
	
	public LoginPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
