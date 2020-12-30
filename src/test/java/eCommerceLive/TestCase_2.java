package eCommerceLive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_2 {
	
	private WebDriver driver;
	  private String baseUrl;
	  
	  @BeforeTest
	  public void setUp() {
		  
		  System.setProperty("webdriver.chrome.driver", "E:\\myworkspace\\Kickoff\\Drivers\\chromedriver.exe");
		    driver = new ChromeDriver();
		    
		    // Maximize windows
		    driver.manage().window().maximize();
			// Step 1 Goto http://live.demoguru99.com/
		    baseUrl = "http://live.demoguru99.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
	  }
	  
	  @Test
	  public void testDay2TestCase2() {
		  driver.get(baseUrl);
		  driver.findElement(By.xpath("//a[contains(.,'Mobile')]")).click();
		  
		  String sony = driver.findElement(By.xpath("//a[contains(.,'Sony Xperia')]")).getText();
		  System.out.println(sony);
		  
		  driver.findElement(By.xpath("//a[contains(.,'Sony Xperia')]")).click();
		  
		  String mobName = driver.findElement(By.cssSelector("span.h1")).getText();
		  System.out.println("Mobile name is :"+mobName);
		  
		  
		  
//		  if(sony.equalsIgnoreCase("SONY XPERIA")) {
//			  
//			  String price = driver.findElement(By.xpath("//span[@class='price']")).getText();
//			 System.out.println("Price is :"+price);
//			 
//			 driver.findElement(By.xpath("//a[contains(.,'Sony Xperia')]")).click();
//		  }
//		  else {
//			
//		}
		  
		  
	  }
	  
	  @AfterTest
	  public void tearDown() {
		  driver.quit();
	  }

}
