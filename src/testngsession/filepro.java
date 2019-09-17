package testngsession;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class filepro {
  
	WebDriver driver;
	
	@Test
  public void f() throws Exception {
 
		Properties pr=new Properties(); 
		FileInputStream fis=new FileInputStream("D:\\Arun\\Java Eclips\\Automation Project\\TestNGCsvread\\QAfileProperty");
		pr.load(fis);
		String a=pr.getProperty("bing.search.text.field");
		String b=pr.getProperty("bing.search.button.field");
		
		System.out.println(a);
		System.out.println(b);
		
		//driver.findElement(By.id("a")).sendKeys("Arun");
		//driver.findElement(By.id("b")).click();
	   
	
	}
  
  
  
  
  @BeforeMethod
  
  public void OpenBrowser1() throws Exception 
  {
  	  
  	  System.setProperty("webdriver.chrome.driver", "D:\\Arun\\su\\chromedriver.exe");
  		driver = new ChromeDriver();
  		driver.manage().window().maximize();
  		driver.manage().deleteAllCookies();
  		driver.get("http://www.bing.com");
	  
  }

  @AfterMethod
  public void afterMethod() {
 
     driver.close();
  }
 
}
