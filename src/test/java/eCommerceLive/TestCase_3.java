package eCommerceLive;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_3 {

	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:\\myworkspace\\Kickoff\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize windows
		driver.manage().window().maximize();

		baseUrl = "http://live.demoguru99.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testDay3TestCase3() {

		// 1. Go to http://live.demoguru99.com
		driver.get(baseUrl);

		// 2. Click on Mobile menu
		driver.findElement(By.linkText("MOBILE")).click();
		System.out.println("Click on Mobile link Button ");
		// 3. click on Add to Cart

		driver.findElement(By.xpath("(//span[contains(.,'Add to Cart')])[2]")).click();

		System.out.println("Click on Add to Cart Button ");
		
		// 4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button.
		// Expected "The requested quantity for "Sony Xperia" is not available." error
		// message is displayed.
		
		WebElement qty = driver.findElement(By.xpath("//input[@class='input-text qty']"));
		qty.clear();
		qty.sendKeys("1000");
		System.out.println("Quantity is added : ");

		driver.findElement(By.xpath("//button[@title='Update']")).click();
		System.out.println("Click on Update Button");
		
		// 5. Verify the error message
		String errMsg = driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
		System.out.println("The Error Message is : "+errMsg);
		
		String msgQty = ("* The maximum quantity allowed for purchase is 500.");
		try {
			assertEquals(errMsg, msgQty);
		}catch (Exception e) {
			e.printStackTrace();
		}
		// 6. Click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message
		// "SHOPPING CART IS EMPTY" is shown.
		
		//7. 
		String noItemStg = ("You have no items in your shopping cart.");
		String noItemMsg = driver.findElement(By.partialLinkText("You have no items in your shopping cart.")).getText();
		System.out.println("The Message is : "+noItemMsg);
		System.out.println("The Message is : "+noItemStg);

		
	}

	@AfterTest
	public void tearDown() {
//		driver.quit();
	}

}
