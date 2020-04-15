package org.cinglevue.tests;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory
{

   private DriverFactory()
   {
      //Do-nothing..Do not allow to initialize this class from outside
   }
   private static DriverFactory instance = new DriverFactory();

   public static DriverFactory getInstance()
   {
      return instance;
   }

   ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
   {
      @Override
      protected WebDriver initialValue()
      {

    	ChromeOptions co = new ChromeOptions();
  		co.addArguments("--start-maximized");
  		co.addArguments("start-maximized"); // open Browser in maximized mode
  		co.addArguments("disable-infobars"); // disabling infobars
  		co.addArguments("--disable-extensions"); // disabling extensions
  		co.addArguments("--disable-gpu"); // applicable to windows os only
  		co.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
  		co.addArguments("--no-sandbox"); // Bypass OS security model
         return new ChromeDriver(co); // can be replaced with other browser drivers
      }
   };

   public WebDriver getDriver() // call this method to get the driver object and launch the browser
   {
      return driver.get();
   }

   public void removeDriver() // Quits the driver and closes the browser
   {
      driver.get().quit();
      driver.remove();
   }
}