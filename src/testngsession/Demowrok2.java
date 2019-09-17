package testngsession;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Demowrok2 {
  
	WebDriver driver;
	
	
	
@Test
 
  public void f() throws Exception 

	{
  
	FileInputStream fis=new FileInputStream("D:\\Arun\\ko.txt");
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	//String v=br.readLine();
    String v;
	while((v=br.readLine())!=null) {
    	
    	String a[]=v.split(",");
    	for (int i=0;i<a.length;i++) 
    			{
    
    			System.out.println(a[i]);
    			}
	}
	
	}
    		



@BeforeMethod
  
  
  
public void OpenBrowser1() throws Exception 
{
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\Arun\\su\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://vis.vervesys.local/Login.aspx#");
		WebElement popup1 = driver.findElement(By.className("login_main"));
	    popup1.click();
	    
}

  
  
  
  
  
  @AfterMethod
  public void driverQuit() 
  
  {
   driver.close();
  
  }

}
