package com.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freeCRmAuto1.BaseClass;

public class CreateEvents extends BaseClass{

By txt_Calender = By.xpath("//span[text()='Calendar']");
By txt_PlusButton = By.xpath("(//button[@class='ui mini basic icon button']/i)[1]");
By txt_Title = By.xpath("//input[@name='title']");
By txt_StartDate =By.xpath("//div[@class='react-datepicker__input-container']//input");
By txt_Date =By.xpath("//div[@class='react-datepicker__day react-datepicker__day--011 react-datepicker__day--selected']");
By txt_Category = By.xpath("(//div[@name='category'])[1]");
By txt_Oportunity= By.xpath("//div[@name='category']/span[1]/following::div/span[text()='Opportunity']");
By txt_AlldayCheckbox=By.xpath("(//label[text()='All Day'])[2]");
By txt_Task = By.xpath("(//input[@class='search'])[3]");
By txt_SaveMeeting= By.xpath("//button[@class='u linkedin button']");

public CreateEvents Calenderevents(String title,String task ) throws InterruptedException {
	driver.findElement(txt_Calender).click();
	Thread.sleep(5000);
	driver.findElement(txt_PlusButton).click();
	driver.findElement(txt_Title).sendKeys(title);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='react-datepicker__input-container']//input")));
	((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--018']")));


((JavascriptExecutor)driver).executeScript("arguments[0].click();", elem);
	driver.findElement(txt_Category).click();
	driver.findElement(txt_Oportunity).click();
	driver.findElement(txt_AlldayCheckbox).click();
	driver.findElement(txt_Task).sendKeys(task); 
	driver.findElement(txt_SaveMeeting).click();
	return this;
}

}