package eCommerceLive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestCase_7 {

	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() {
		String userDir = System.getProperty("user.dir");
		System.out.println("This is User Dir :" + userDir);
		System.setProperty("webdriver.chrome.driver", userDir + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize windows
		driver.manage().window().maximize();
		baseUrl = "http://live.demoguru99.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void testCase7testDay7() {
		//1. Go to Base URL
		driver.get(baseUrl);
		//2. 
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
