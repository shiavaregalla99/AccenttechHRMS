package com.accenttech.hrms.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.accenttech.hrms.utils.ConfigsReader;
import com.accenttech.hrms.utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	//shiva changes
	
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	public static ExtentTest test;
	@BeforeTest(alwaysRun=true)
	public void generateReport() {
		ConfigsReader.readProperties(Constants.CONFIGS_PATH);
		htmlReport = new ExtentHtmlReporter(Constants.EXTENTREPORT_PATH);
		htmlReport.config().setReportName("ExtentReport");
		htmlReport.config().setTheme(Theme.DARK);
		report= new ExtentReports();
		report.attachReporter(htmlReport);
	}
	@AfterTest(alwaysRun=true)
	public void writeReport() {
		report.flush();
	}
	
	//webdriver set up here
	//purpose of this method 
	@BeforeMethod(alwaysRun=true)
	public static WebDriver setUp() {
		
		 
		   switch (ConfigsReader.getProperty("browserName")) {
		      case "chrome":
					//System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
					WebDriverManager.chromedriver().setup();
		    	  driver = new ChromeDriver();
					break;
				case "firefox":
					//System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_PATH);
				  WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					throw new RuntimeException("Browser is not supported");
				}

				// driver.manage().window().fullscreen();
				driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
				driver.get(ConfigsReader.getProperty("URL"));
				// initialize all page objects as part of setup
				
				PageIntializer.intialize();
				return driver;

			}

		@AfterMethod(alwaysRun=true)
			public static void tearDown() {
				if (driver != null) {
					driver.quit();
				}
			}
		}


