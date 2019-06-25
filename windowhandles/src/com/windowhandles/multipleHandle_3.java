package com.windowhandles;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class multipleHandle_3 {
public static void main(String[] args) {
	System.setProperty("Webdriver.chrome.driver", "G:\\selenium workspace 1\\windowhandles\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.naukri.com");
String	parent=driver.getWindowHandle();

Set<String> allwindow=driver.getWindowHandles();
ArrayList<String> tap=new ArrayList<>(allwindow);
System.out.println(tap.size());
System.out.println(driver.switchTo().window(tap.get(3)).getTitle());
driver.close();
System.out.println(driver.switchTo().window(tap.get(2)).getTitle());
	driver.close();
	System.out.println(driver.switchTo().window(tap.get(1)).getTitle());
	driver.close();
	System.out.println(driver.switchTo().window(tap.get(0)).getTitle());
	System.out.println("Title is parent=="+driver.getTitle());
	
	driver.switchTo().defaultContent();
}
}
