package com.accenttech.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accenttech.hrms.base.BaseClass;
import com.accenttech.hrms.base.PageIntializer;

public class CommonMethods extends PageIntializer {

	
	public static void sendText(WebElement ele,String text) {
		waitForVisibility(ele);
		ele.clear();
		ele.sendKeys(text);
	}
	public static void clickAction(WebElement ele) {
		waitForClickability(ele);
		ele.click();
		
	}
	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait= new WebDriverWait(BaseClass.driver,30);
	return wait;
	}
	
	public static WebElement waitForClickability(WebElement ele) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static WebElement waitForVisibility(WebElement ele) {
		return getWaitObject().until(ExpectedConditions.visibilityOf((ele)));
	}

	
	public static void staticWait(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String takeScreenshot(String fileName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=	ts.getScreenshotAs(OutputType.FILE);
		String destinationPath=Constants.SCREENSHOT_PATH+fileName+getTimeStamp()+".png";
		
		try {
			FileUtils.copyFile(file, new File(destinationPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destinationPath;
		
	}
	
	 public static String getTimeStamp() {
	    	Date date= new Date();
	    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	      return sdf.format(date.getTime());
	    }
	}
	


