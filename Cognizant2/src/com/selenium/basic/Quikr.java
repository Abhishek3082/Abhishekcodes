package com.selenium.basic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Quikr 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.get("https://www.quikr.com/");
		Thread.sleep(9000);
		driver.findElementByClassName("wpn_modal_actionButton").click();
		
		driver.findElementByXPath("//div[@class='select-city']").click();
		Thread.sleep(1000);
		driver.findElementById("green_dhtml_content_All India").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Visit Our Store']").click();
		Thread.sleep(2000);
		
		ArrayList<String> lst=new ArrayList(driver.getWindowHandles());

		driver.switchTo().window(lst.get(1));
		
		List<WebElement> name=driver.findElementsByXPath("//h1[@class='mdc-card__title']");
		
		FileInputStream fin=new FileInputStream("D:\\Book1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet ws=wb.getSheet("Quikr");
		Row row;

		for(int i=1;i<=name.size();i++)
		{
			row=ws.createRow(i);//row=1
			row.createCell(0).setCellValue(name.get(i-1).getText());
			row.createCell(1).setCellValue(driver.findElementByXPath("(//h2[@class='mdc-card__subtitle'])["+i+"]").getText());
			Thread.sleep(2000);
			System.out.println("Success");
		}
		
		FileOutputStream fout=new FileOutputStream("D:\\Book1.xlsx");
		wb.write(fout);
		driver.quit();
	}
}