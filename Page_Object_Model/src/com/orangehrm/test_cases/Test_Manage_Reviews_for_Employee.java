package com.orangehrm.test_cases;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.orangehrm.common_actions.CommonActions;
import com.orangehrm.page_objects.Home_Page_Objects;
import com.orangehrm.page_objects.Performance_Page_Objects;



public class Test_Manage_Reviews_for_Employee extends CommonActions{



	WebElement performanceLink;
	Actions actions;






	public void hoverToPerformance() {
		
		actions= new Actions(driver);
		actions.moveToElement(Home_Page_Objects.performanceLink).click().perform();

	}


	public void hoverToAndClickManageReviews() {

		
		actions.moveToElement(Performance_Page_Objects.manageReviewsLink).perform();
		actions.moveToElement(Performance_Page_Objects.secondManageReviewLink).click().perform();
	}



	@Test
	public void test_Manage_Reviews_for_Employee() {

		Test_Manage_Reviews_for_Employee manage_Reviews_for_Employee= new Test_Manage_Reviews_for_Employee();
		manage_Reviews_for_Employee.hoverToPerformance();
		manage_Reviews_for_Employee.hoverToAndClickManageReviews();

	}



}
