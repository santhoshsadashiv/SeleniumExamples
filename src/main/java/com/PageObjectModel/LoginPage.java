package com.PageObjectModel;

import org.openqa.selenium.By;
import freeCRmAuto1.BaseClass;
public class LoginPage extends BaseClass {
	
By txt_Username = By.name("email");
By txt_Password = By.name("password");
By btn_Login = By.xpath("//div[contains(@class,'ui fluid large blue')]");


public LoginPage setCredentials(String emailid,String password) {
	
	driver.findElement(txt_Username).sendKeys(emailid);
	driver.findElement(txt_Password).sendKeys(password);
		return this;
}
public CreateEvents clickLoginButton() {
	driver.findElement(btn_Login).click();
	return new CreateEvents();
	
}
}  
