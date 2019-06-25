package com.windowhandles;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MultipleWindows {
	    // Declaring variables
	    private WebDriver driver;
	    private String baseUrl;
	    @Before
	    public void setUp() throws Exception {
	        // Selenium version 3 beta releases require system property set up
	        System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\"
	                + "Selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
	        // Create a new instance for the class FirefoxDriver
	        // that implements WebDriver interface
	        driver = new FirefoxDriver();
	        // Implicit wait for 5 seconds
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        // Assign the URL to be invoked to a String variable
	          baseUrl = "https://chandanachaitanya.github.io/selenium-practice-site/";
	    }
	    @Test
	    public void testPageTitle() throws Exception {
	        // Open baseUrl in Firefox browser window
	        driver.get(baseUrl);
	        // Get current window handle
	        String parentWinHandle = driver.getWindowHandle();
	        System.out.println("Parent window handle: " + parentWinHandle);
	        // Locate 'Click to open a new browser window!' button using id
	        WebElement newWindowBtn = driver.findElement(By.id("win1"));
	        // Click the button to open a new window
	        newWindowBtn.click();
	        // Get the window handles of all open windows
	        Set<String> winHandles = driver.getWindowHandles();
	        // Loop through all handles
	        for(String handle: winHandles){
	            if(!handle.equals(parentWinHandle)){
	            driver.switchTo().window(handle);
	            Thread.sleep(1000);
	            System.out.println("Title of the new window: " +
	driver.getTitle());
	            System.out.println("Closing the new window...");
	            driver.close();
	            }
	        }
	        // Switching the control back to parent window
	        driver.switchTo().window(parentWinHandle);
	        // Print the URL to the console
	        System.out.println("Parent window URL: " + driver.getCurrentUrl());
	    } // End of @Test
	    @AfterClass
	    public void tearDown() throws Exception {
	        // Close the Firefox browser
	        driver.close();
	    }
	}

