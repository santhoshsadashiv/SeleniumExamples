package com.Testcase;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utils.*;
import com.PageObjectModel.LoginPage;

import freeCRmAuto1.BaseClass;

public class CreateCalenderEvents extends BaseClass{
	@BeforeTest
		public void setup() {
		excelFileName = "LoginFreeCrm";
		testName = "CreateCalenderEvents";
		testDescription = "testcase for create Events";
		testAuthor ="santhosh";
		
		}
	
	@Test(dataProvider = "fetch")//retryAnalyzer=RetryFailedTestCases.class)
	
	public void CreateEvent(String emailid,String password,String title,String task ) throws InterruptedException {
		LoginPage lp = new LoginPage();
		lp.setCredentials(emailid, password)
		.clickLoginButton()
		.Calenderevents(title, task);

		
	}
	
}
