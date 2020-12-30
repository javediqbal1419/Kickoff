package eCommerceLive;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_4 {

	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:\\myworkspace\\Kickoff\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize windows
		driver.manage().window().maximize();

		baseUrl = "http://live.demoguru99.com/";
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test
	public void testDay4testCase4() throws Exception {
		// 1. Go to http://live.demoguru99.com
		driver.get(baseUrl);

		// 2. Click on Mobile menu
		driver.findElement(By.linkText("MOBILE")).click();
		System.out.println("Click on Mobile link Button ");
		
		// 3. click on Add to Cart
		
//		 String mainMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
		driver.findElement(By.xpath("(//a[@class='link-compare'])[1]")).click();
		String mainMobile1 =  driver.findElement(By.xpath("//h2/a[@title='Sony Xperia'")).getText();
//		driver.findElement(By.xpath("((//a[contains(.,'Add to Compare')])[1]")).click();
		System.out.println("Click on Add to Compare sony :");
		
		String mainMobile2 =  driver.findElement(By.xpath("//h2/a[@title='IPhone'")).getText();
		driver.findElement(By.xpath("(//a[@class='link-compare'])[2]")).click();
//		driver.findElement(By.xpath("((//a[contains(.,'Add to Compare')])[2]")).click();
		
		System.out.println("Click on Add to Comapre iPhone : ");

		// 4. click on compare button
		driver.findElement(By.xpath("(//button[@title = 'Compare'])")).click();
		Thread.sleep(3000);
		System.out.println("Click on Compare Button : ");
		
		// switch to new windows
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			System.out.println("This is handle : "+handle);
		}

		// 5. verify the pop windows and check that the products are reflected in it

		String titleOfPage = driver.getTitle();
		System.out.println("This is title of the page :"+titleOfPage);
		String title = ("Products Comparison List - Magento Commerce");
		try {
			assertEquals(titleOfPage, title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String popMobile1 = driver.findElement(By.xpath("//a[contains(.,'Sony Xperia')]")).getText();
		String popMobile2 = driver.findElement(By.xpath("//a[contains(.,'IPhone')]")).getText();
		
		try{
			assertEquals(popMobile1, mainMobile1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(popMobile2, mainMobile2);
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		

		// 6. close pop up windows
		driver.findElement(By.xpath("//button[@title='Close Window'")).click();
		// switch to new windows
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}

	}
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
