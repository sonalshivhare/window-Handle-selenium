package com.windowhandles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class window_haandle {
@Test
public void HandleMultipleWindow() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "G:\\selenium workspace 1\\windowhandles\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.naukri.com");
     String	parent=driver.getWindowHandle();
     
  Set<String>   allwindow=driver.getWindowHandles();
 Iterator<String>  itr=allwindow.iterator();
 while(itr.hasNext()){
String	child= itr.next();
if(!parent.equalsIgnoreCase(child)){
	driver.switchTo().window(child);
	System.out.println("Child window title=="+driver.getTitle());
	Thread.sleep(10000);
	driver.close();
}
 }
  driver.switchTo().window(parent);
  System.out.println("parent window title=="+driver.getTitle());
  driver.close();
}

}
