package com.selenium.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.practo.com/");
		driver.findElementByXPath("(//input[@class=\"c-omni-searchbox c-omni-searchbox--small\"])[1]").clear();
		driver.findElementByXPath("(//input[@class=\"c-omni-searchbox c-omni-searchbox--small\"])[1]").sendKeys("hyder");
		Thread.sleep(2000);
		driver.findElementByXPath("//div[contains(text(),'Hyderabad')]").click();
		driver.findElementByXPath("(//input[@class=\"c-omni-searchbox c-omni-searchbox--small\"])[2]").sendKeys("hospi");
	    Thread.sleep(2000);
		driver.findElementByXPath("//div[contains(text(),'Hospital')]").click();
		Thread.sleep(4000);
		driver.findElementByXPath("(//div[@class=\"c-filter__select--checkbox u-d-inlineblock u-valign--middle u-pos-rel\"])[3]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[contains(text(),'All Filters')]").click();
		driver.findElementByXPath("(//div[@class=\"c-filter__select--checkbox u-d-inlineblock u-valign--middle u-pos-rel\"])[5]").click();
		Thread.sleep(2000);
		
		List<WebElement> name=driver.findElementsByXPath("//h2[@class=\"u-title-font u-c-pointer u-bold\"]");
		//for(WebElement webElement:name) {
			FileInputStream fin=new FileInputStream("D:\\Book1.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fin);
			XSSFSheet ws=wb.getSheet("p1");
			Row row;

			for(int i=1;i<=name.size();i++)
			{
				row=ws.createRow(i);//row=1
				row.createCell(0).setCellValue(name.get(i-1).getText());
				row.createCell(1).setCellValue(driver.findElementByXPath("(//div[@class=\"common__star-rating tooltip-hover\"])["+i+"]").getText());
				Thread.sleep(2000);
				System.out.println("Success");
			}
			
			FileOutputStream fout=new FileOutputStream("D:\\Book1.xlsx");
			wb.write(fout);
			driver.quit();

	}

}

