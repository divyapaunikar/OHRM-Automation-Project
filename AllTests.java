package com.OHRMProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AllTests {
	WebDriver driver;
	String fPath = "C:\\Users\\divya\\Documents\\Automation\\OHRM_Assignment_Data.xlsx";
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	XSSFCellStyle style;
	XSSFFont font;
	
	LoginLogoutAdmin la;
	AdminLogin al;

	@Test
	public void addEmployee() throws InterruptedException, FileNotFoundException {
		
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=1;i<=rowCount;i++) {
			la.loginApp("admin","admin123");
			al.clickOnPIM();
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
			//Fill details
			al.enterFirstName(sheet.getRow(i).getCell(1).getStringCellValue());
			al.enterMiddleName(sheet.getRow(i).getCell(2).getStringCellValue());
			al.enterLastName(sheet.getRow(i).getCell(3).getStringCellValue());
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")).click();
			//enter username
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"))
					.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
			
			//WebElement uexists = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/span"));
			al.enterPassword(sheet.getRow(i).getCell(5).getStringCellValue());
			al.enterConfirmPassword(sheet.getRow(i).getCell(5).getStringCellValue());
			Thread.sleep(2000);
			al.clickOnPIMSave();
//			if(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/span")).getText()!= "Username already exists") 
//				{
//				al.enterPassword(sheet.getRow(i).getCell(5).getStringCellValue());
//				al.enterConfirmPassword(sheet.getRow(i).getCell(5).getStringCellValue());
//				Thread.sleep(2000);
//				al.clickOnPIMSave();
//				
//				}
//			else {
//				System.out.println("Username already exists. User cannot be added");
//			}
			
			Thread.sleep(4000);
			la.logoutApp();
			Thread.sleep(2000);
			la.loginApp(sheet.getRow(i).getCell(4).getStringCellValue(),sheet.getRow(i).getCell(5).getStringCellValue());
			
			driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")).click();
			Thread.sleep(3000);
			WebElement uid = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input"));		
			System.out.println(uid.getAttribute("value"));
			sheet.getRow(i).getCell(6).setCellValue(uid.getAttribute("value"));
			WebElement uname = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
			System.out.println(uname.getText());
			sheet.getRow(i).getCell(8).setCellValue(uname.getText());
			String expName = sheet.getRow(i).getCell(7).getStringCellValue();
			String actName = sheet.getRow(i).getCell(8).getStringCellValue();
			cell = sheet.getRow(i).getCell(9);
			style = wb.createCellStyle();
			font = wb.createFont();
			if(expName == actName) {
				cell.setCellValue("Pass");
				font.setBold(true);
				font.setColor(IndexedColors.GREEN.index);
				style.setFont(font);
				cell.setCellStyle(style);
			}
			else {
				cell.setCellValue("Fail");
				font.setItalic(true);
				font.setColor(IndexedColors.RED.index);
				style.setFont(font);
				cell.setCellStyle(style);
			}
				
			Thread.sleep(5000);
			la.logoutApp();
			
			Thread.sleep(2000);
			la.loginApp("admin","admin123");
			al.clickOnPIM();
			//driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")).sendKeys(sheet.getRow(i).getCell(6).getStringCellValue());
			al.clickOnPIMSearch();
			Thread.sleep(2000);
			WebElement searchuid = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div"));
			System.out.println("Search user id : "+searchuid.getText());
			al.clickOnPIMDelete();
			Thread.sleep(2000);
			al.confirmDeleteAlert();
			Thread.sleep(2000);
//			if(searchuid.getText() == uid.getAttribute("value")) {
//				al.clickOnPIMDelete();
//				Thread.sleep(2000);
//				al.confirmDeleteAlert();
//			}
//			else
//				System.out.println("User id not matching. User cannot be deleted.");

			la.logoutApp();
		}
	}
  
	@BeforeTest(alwaysRun=true)
	public void beforeTest() throws IOException {
		
		file = new File(fPath);
		fis = new FileInputStream(file);	
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		fos = new FileOutputStream(file);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		la = new LoginLogoutAdmin(driver);
		al = new AdminLogin(driver);
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fis.close();
		
		driver.close();
	}
  
}
