package com.windowhandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Window_Handle {
		 
		public static void main(String[] args) {
		 
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
		 
		WebDriver driver = new FirefoxDriver();
		 
		driver.get("https://www.stqatools.com");
		 
		// Current window location store into Parent Window string.
		String parentWindow = driver.getWindowHandle();
		 
		// Click some link that opens a new window.
		driver.findElement(By.xpath("//*[@id='window_path']")).click();
		 
		// Store newly open window into Child Window using getWindowHandles.
		for (String childWindow : driver.getWindowHandles()) {
		 
		// Switch to Newly open window using switchTo().
		driver.switchTo().window(childWindow);
		 
		}
		 
		// Close newly opened window when done with it.
		driver.close();
		 
		// switch back to the Parent window.
		driver.switchTo().window(parentWindow);
		 
		}
		 
		}

