package testngsession;

import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import java.io.FileReader;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBasics {
	
	
	WebDriver driver;
	String CSV_file="D:\\Arun\\hj.csv";
	
	//private CSVReader reader;
	//private CSVReader reader1;
	private CSVReader reader;
	
@BeforeMethod	
  
public void OpenBrowser() throws Exception 
  {
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\Arun\\su\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://vis.vervesys.local/Login.aspx#");
		
		WebElement popup1 = driver.findElement(By.className("login_main"));
	    popup1.click();
	    
  }
   
  
      @Test(priority=2)
	    public void verifylgoinFuntionality() throws Exception
	    {
    	  
    	  
    	  reader = new CSVReader(new FileReader(CSV_file));
    	  
    	  String[] cell;
    	  
    	  while((cell=reader.readNext())!=null) 
    	  
    	  {
    		  
    		  for(int i=0;i<1;i++) {
    		  String username=cell[i];
    		  String password=cell[i+1];
    		WebElement username1 = driver.findElement(By.id("username"));
  		    WebElement password1 = driver.findElement(By.id("password"));
  		    WebElement Login = driver.findElement(By.name("logged"));
  		    username1.sendKeys(username);
  		    password1.sendKeys(password);
  		    Login.click();
  		    
  		  String title=driver.getTitle();
  		  System.out.printf("The Page Title is:" + title);
  		  Assert.assertEquals(title, "Admin - Attendance System");
  		  
  		driver.navigate().back();;
    		 
    		  
    		  }	    
  		   }
	    
	    }   
	    
/*	     
@Test(priority=1)

public void VerifywithInvalidlgoinFuntionality() throws Exception

{
  
String CSV_file1="D:\\Arun\\lm.csv";
  reader1 = new CSVReader(new FileReader(CSV_file1));
  
  String[] cell;
  
  while((cell=reader1.readNext())!=null) 
  
  {
	  
	  for(int i=0;i<1;i++) {
	  String username=cell[i];
	  String password=cell[i+1];
	WebElement username1 = driver.findElement(By.id("username"));
	    WebElement password1 = driver.findElement(By.id("password"));
	    WebElement Login = driver.findElement(By.name("logged"));
	    username1.sendKeys(username);
	    //driver.wait(5);
	    password1.sendKeys(password);
	    //driver.wait(5);
	    Login.click();
	    String title1=driver.getTitle();
	  System.out.printf("The Page Title is:" + title1);
	  Assert.assertEquals(title1, "Verve Systems - Login");
	  
	  }	    
	   }

}  


*/

	    @AfterMethod
	   public void Driverclose() 
	   	{ 

		   driver.close();
	   	}
}