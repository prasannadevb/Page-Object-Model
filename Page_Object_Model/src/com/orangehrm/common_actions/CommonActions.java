package com.orangehrm.common_actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.page_objects.Directory_Page_Objects;
import com.orangehrm.page_objects.Home_Page_Objects;
import com.orangehrm.page_objects.Login_Page_Objects;
import com.orangehrm.page_objects.Performance_Page_Objects;

public class CommonActions {

	public static boolean status=false;
	public static WebDriver driver=null;
	public static Properties	properties;

	CommonActions commonActions;

	static Logger logger= Logger.getLogger(CommonActions.class);

	@BeforeSuite
	public void gotoApplication() throws IOException {


		PropertyConfigurator.configure("log4j.properties");
		logger.info("Loading the log4j properties file");
		commonActions= new CommonActions();
		commonActions.loadPropertyFile();
		System.setProperty(properties.getProperty("Browser"),properties.getProperty("DriverLocation"));
		logger.info("Launching the browser");
		driver = new ChromeDriver();
		logger.info("Hitting the given URL");
		driver.get(properties.getProperty("URL"));
		driver.manage().window().maximize();

		logger.info("Initializing the Page Objects");
		PageFactory.initElements(driver, Login_Page_Objects.class);
		PageFactory.initElements(driver, Home_Page_Objects.class);
		PageFactory.initElements(driver, Directory_Page_Objects.class);
		PageFactory.initElements(driver, Performance_Page_Objects.class);
		logger.info(" Page Objects Initialized");
	}



	public void loadPropertyFile() throws IOException {
		logger.info("Loading the Config property file");
		FileInputStream fileInputStream= new FileInputStream("config.properties");
		properties= new Properties();
		properties.load(fileInputStream);


	}


	public void login() {
		try {
			logger.info("Logging in to the Application");
			Login_Page_Objects.userName.sendKeys(properties.getProperty("UserName"));

			Login_Page_Objects.password.sendKeys(properties.getProperty("Password"));

			Login_Page_Objects.password.submit();


			Thread.sleep(5000);
			WebElement welcomeLink=CommonActions.driver.findElement(By.partialLinkText("Welcome"));
			if (welcomeLink.isDisplayed()) {
				status=true;
				logger.info("Login successful");
			}else{
				logger.info("Login Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}

	}

	/*
	 * @AfterSuite public void killApplication() { driver.quit(); }
	 */
}
