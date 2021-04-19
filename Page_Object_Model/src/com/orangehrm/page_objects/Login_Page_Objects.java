package com.orangehrm.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Objects {
	
	@FindBy(id="txtUsername")
	public static WebElement userName;
	
	@FindBy(id="txtPassword")
	public static WebElement password;

}
