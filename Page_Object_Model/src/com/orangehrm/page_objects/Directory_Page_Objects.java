package com.orangehrm.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Directory_Page_Objects {
	
	@FindBy(id="searchDirectory_job_title")
	public static WebElement  jobTitleDropDown; 
	
	@FindBy(id="searchBtn")
	public static WebElement searchButton;

}
