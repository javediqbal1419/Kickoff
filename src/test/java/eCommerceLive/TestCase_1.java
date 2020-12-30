package eCommerceLive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_1 {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeTest
	public void setUp() throws Exception {
		  
		String userDir = System.getProperty("user.dir");
		System.out.println("This is User Dir :"+userDir);
		System.setProperty("webdriver.chrome.driver", userDir+"\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
	    // Maximize windows
	    driver.manage().window().maximize();
		// Step 1 Goto http://live.demoguru99.com/
	    baseUrl = "http://live.demoguru99.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	@Test
	public void testCase1testDay1() {
		//1. go to Base URL
		driver.get(baseUrl);
		
	}
	public void tearDown() {
		driver.quit();
	}

}
