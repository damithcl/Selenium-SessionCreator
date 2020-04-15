package org.cinglevue.tests;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//@Listeners({loginloop.loop.AnnotationTransformer.class})
public class SessionFactory {
	

	
	
	static HashMap<String,String> UserMap;

	//@BeforeTest
	public void init() throws IOException {
		UserMap  = XLRead.readXcel(System.getProperty("user.dir"), "userlist.xlsx", "sheet1");
        System.out.println(UserMap);

	}

	@Test(threadPoolSize = 1000,invocationCount = 4)
    public  void executSession() throws InterruptedException, IOException{
		init();
        
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
		
		WebDriver driver = DriverFactory.getInstance().getDriver();
        
        Long id = Thread.currentThread().getId();
       
        System.out.println("Session ID is "+id);
        driver.get(new InputHandler().getProperty("BaseUrl"));



    for (Map.Entry<String, String> entry : UserMap.entrySet()) {
    	
		 System.out.println(entry.getKey() + "/" + entry.getValue());
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(entry.getKey());
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(entry.getValue());
        driver.findElement(By.xpath("//input[@id='kc-login']")).click();
      
        Thread.sleep(1000);
        UserMap.remove(entry.getKey(), entry.getValue());
        break;

    
}

    
       
        }




	
	
	
    
}