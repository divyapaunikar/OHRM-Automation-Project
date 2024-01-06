package com.OHRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLogin {
	
	WebDriver driver;

	public AdminLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnPIM() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();	
	}
	
//	public void clickOnAdd() {
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
//	}
	
	public void enterFirstName(String fn) {
		driver.findElement(By.name("firstName")).sendKeys(fn);
	}
	
	public void enterMiddleName(String mn) {
		driver.findElement(By.name("middleName")).sendKeys(mn);
	}
	
	public void enterLastName(String ln) {
		driver.findElement(By.name("lastName")).sendKeys(ln);
	}
	
	public void clickLoginDetails() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")).click();
	}
	
	public void enterUsername(String user) {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"))
		.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"))
		.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String cnfpass) {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"))
		.sendKeys(cnfpass);
	}
	
	public void clickOnPIMSave() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
	}
	
	public void clickOnAdminSave() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
	}
	
	public void searchFirstname(String sfn) {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys(sfn);
	}
	
	public void clickOnPIMSearch() {
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
	}
	
	public void clickOnPIMDelete() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[1]/i")).click();
		
	}
	
	public void confirmDeleteAlert() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
	}
	
}
