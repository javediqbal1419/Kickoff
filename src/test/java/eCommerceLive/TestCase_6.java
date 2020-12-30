/**Verify user is able to purchase product using registered email id(USE CHROME BROWSER)     
Test Steps:
1. Go to http://live.demoguru99.com/
2. Click on my account link
3. Login in application using previously created credential
4. Click on MY WISHLIST link 
5. In next page, Click ADD TO CART link
6. Enter general shipping country, state/province and zip for the shipping cost estimate
7. Click Estimate 
8. Verify Shipping cost generated 
9. Select Shipping Cost, Update Total 
10. Verify shipping cost is added to total 
11. Click "Proceed to Checkout"
12a. Enter Billing Information, and click Continue
12b. Enter Shipping Information, and click Continue
13. In Shipping Method, Click Continue
14. In Payment Information select 'Check/Money Order' radio button. Click Continue
15. Click 'PLACE ORDER' button 
16. Verify Oder is generated. Note the order number

NOTE: PROCEED TO CHECKOUT (step 6 ) was taken out, so as to allow the Estimate button step to get processed. 
      Rest of the steps renumbered accordingly. 
 * 
 */
package eCommerceLive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_6 {

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

	@Test
	public void testCase6testDay6() {
		
		//1. Go to Base URL
		driver.get(baseUrl);
		
		//2. click on My Account link
		driver.findElement(By.xpath("")).click();
		// 3. Login Application with previously created credential
		TestCase_5 login = new TestCase_5();
		driver.findElement(By.id("")).sendKeys(login.uEmail);
		driver.findElement(By.id("")).sendKeys(login.pwd);
		driver.findElement(By.xpath("")).submit();
		//4. click on My Wish List
		driver.findElement(By.linkText("MY WISHLIST")).click();
		//5. In next Page Add to Cart Link
		

	}

	@AfterTest
	public void tearDown() throws Exception {

		Thread.sleep(3000);
		driver.quit();

	}

}
