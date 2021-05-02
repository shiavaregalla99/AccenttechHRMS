package com.accenttech.hrms.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accenttech.hrms.base.BaseClass;
import com.accenttech.hrms.pages.LoginPage;
import com.accenttech.hrms.utils.CommonMethods;

public class Test_001 extends CommonMethods{
     @Test()
	public void validLogin() {
	    CommonMethods.sendText(login.userName, "admin");
		CommonMethods.sendText(login.password, "admin123");
		CommonMethods.clickAction(login.loginButton);
		
	String actualTitle=	BaseClass.driver.getTitle();
	String expectedTitle="OrangeHRM";
	Assert.assertEquals(actualTitle, expectedTitle,"titles are not matched here");
	CommonMethods.staticWait(2);
	}
     @Test(enabled=false)
 	public void invalidusername() {
 		CommonMethods.sendText(login.userName, "admin");
		CommonMethods.sendText(login.password, "Admin123");
		CommonMethods.clickAction(login.loginButton);
 	String actualErrorMessage=	login.errorMessage.getText();
 	String expectedErrorMessage="Invalid credentials";
 	Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"titles are not matched here");
 	CommonMethods.staticWait(2);
 	}
     
     @Test(enabled=false)
 	public void invalidPassword() {
 		
 		
 		CommonMethods.sendText(login.userName, "admin");
		CommonMethods.sendText(login.password, "Admin123");
		CommonMethods.clickAction(login.loginButton);
 		String actualErrorMessage=	login.errorMessage.getText();
 	 	String expectedErrorMessage="Invalid credentials";
 	 	Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"titles are not matched here");
 	 	CommonMethods.staticWait(2);
 	}
     
     @Test
 	public void invalidCredentials() {
 		
 		
 		CommonMethods.sendText(login.userName, "admin");
		CommonMethods.sendText(login.password, "Admin123");
		CommonMethods.clickAction(login.loginButton);
 		String actualErrorMessage=	login.errorMessage.getText();
 	 	String expectedErrorMessage="Invalid credential";
 	 	Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"titles are not matched here");
 	 	CommonMethods.staticWait(2);
 	}
     
}
