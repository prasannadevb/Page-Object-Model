package com.orangehrm.test_cases;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.orangehrm.common_actions.CommonActions;
import com.orangehrm.page_objects.Directory_Page_Objects;
import com.orangehrm.page_objects.Home_Page_Objects;


public class Test_Fetch_Account_assistants extends CommonActions{
	
	static Logger logger= Logger.getLogger(Test_Fetch_Account_assistants.class);

	public void gotoDirectory() {
		logger.info("Go to Directory Menu");
		
		Home_Page_Objects.directoryLink.click();


	}

	public void selectAccountAssistantJob() {

		
		logger.info("Select Account Assistant Job Role");
		Select selectJob= new Select(Directory_Page_Objects.jobTitleDropDown);
		selectJob.selectByVisibleText(properties.getProperty("Role"));	
		Directory_Page_Objects.searchButton.click();

	}

	@Test
	public void verifyFilteringJobTitle() {

		logger.info("Executing the Fetch Account Assistants test case");
		Test_Fetch_Account_assistants test_Fetch_Account_assistants= new Test_Fetch_Account_assistants();

		test_Fetch_Account_assistants.login();
		if(CommonActions.status==true) {
			test_Fetch_Account_assistants.gotoDirectory();
			test_Fetch_Account_assistants.selectAccountAssistantJob();
		}
		


	}

}
