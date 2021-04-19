package com.orangehrm.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Performance_Page_Objects {
	
	@FindBy(linkText = "Manage Reviews")
	public static WebElement manageReviewsLink ; 
	
	
	@FindBy(xpath = "(//a[contains(text(),'Manage Reviews')])[2]")
	public static WebElement secondManageReviewLink;

}
