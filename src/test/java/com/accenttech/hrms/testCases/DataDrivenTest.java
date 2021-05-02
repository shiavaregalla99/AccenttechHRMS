package com.accenttech.hrms.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.accenttech.hrms.utils.CommonMethods;
import com.accenttech.hrms.utils.ExcelUtility;

public class DataDrivenTest extends CommonMethods{
	 
	
	@Test(dataProvider="TestData")
	 	public void invalidCredentials(String username,String password,String expectedErrorMessage) {
	 		CommonMethods.sendText(login.userName, username);
			CommonMethods.sendText(login.password, password);
			CommonMethods.clickAction(login.loginButton);
	 	String actualErrorMessage=	login.errorMessage.getText();
	    Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"titles are not matched here");
	 	CommonMethods.staticWait(2);
	 	}
	
	@DataProvider(name="TestData")
	public Object[][] loginData(){
		return ExcelUtility.excelData("C:\\Users\\Pranitha Regalla\\Desktop\\TestData1.xlsx", "LoginData");
	}
	
	
}
