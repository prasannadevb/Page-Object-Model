package com.orangehrm.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page_Objects {

	@FindBy(linkText = "Directory")
	public static	WebElement directoryLink;
	
	@FindBy(linkText = "Performance")
	public static WebElement performanceLink;
	
	
	

}
