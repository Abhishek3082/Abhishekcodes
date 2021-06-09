package com.selenium.basic;
import java.awt.Robot;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Naukri_uploadfile 
{

	public static void main(String[] args) throws Exception
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
		driver.findElement(By.xpath("//label[@title='Upload your CV to Register']")).click();
		Thread.sleep(5000);
		
		//Runtime.getRuntime().exec("D:\\fileupload.exe");
		
		Robot r=new Robot();	
	
		
	  	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("d:\\Abhishek.docx"), null);//copy the text into clipboard memeory
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		

	}

}
