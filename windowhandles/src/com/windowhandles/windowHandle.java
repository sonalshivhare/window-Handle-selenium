package com.windowhandles;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class windowHandle {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
String	parent=driver.getWindowHandle();
System.out.println(parent);
driver.findElement(By.xpath("//a[contains(@href,'//www.google.com')]")).click();

 Set<String>  allwindow=driver.getWindowHandles();
int val=allwindow.size();
System.out.println(val);
 for(String child : allwindow){
	 if(!parent.equalsIgnoreCase(child)){
		 driver.switchTo().window(child);
		 driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		 Thread.sleep(2000);
		 Actions act=new Actions(driver);
		 act.sendKeys(Keys.ENTER).build().perform();
		 
		
	 }
	 driver.switchTo().window(parent);
 }
driver.close();
}
}
