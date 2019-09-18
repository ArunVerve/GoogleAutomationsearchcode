package Googlesearch;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search {
  
	WebDriver driver;
	
	@Test
	public void OpenBrowser() throws Exception 
	  {
		  
		  System.setProperty("webdriver.chrome.driver", "D:\\Arun\\su\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get("https://www.google.co.in");
			
			
		WebElement vis	=driver.findElement(By.name("q"));
		vis.clear();
		vis.sendKeys("Verve systems");
		vis.submit();
		
		boolean isTheTextPresent = driver.getPageSource().contains("Verve systems");
		assertTrue(isTheTextPresent);
		//assertFalse(isTheTextPresent);
		
		driver.close();
}

	
	
	
}
