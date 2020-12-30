package eCommerceLive;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_5 {

	private WebDriver driver;
	private String baseUrl;
	public String fName = "QA1";
	public String mName = "QAM";
	public String lName = "QAL";
	public String uEmail = "qa21@gmail.com";
	public String pwd = "12345678";
	public String txtemail = "testing@gmail.com";

	@BeforeTest
	public void setUp() throws Exception {

		String userDir = System.getProperty("user.dir");
		System.out.println("This is User Dir :"+userDir);
		System.setProperty("webdriver.chrome.driver", userDir+"\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();

		// Maximize windows
		driver.manage().window().maximize();

		baseUrl = "http://live.demoguru99.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void testDay5testCase5() throws Exception {
		driver.get(baseUrl);
		// 1. click on my Account link
//		driver.findElement(By.xpath("(//span[contains(.,'Account')])")).click();
//		 driver.findElement(By.linkText("MY ACCOUNT")).click();
		driver.findElement(By.linkText("MY ACCOUNT")).click();

		// 3. click on Create Account
		driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();

		// 4.
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.clear();
		firstName.sendKeys(fName);
		WebElement middleName = driver.findElement(By.xpath("//input[@name='middlename']"));
		middleName.clear();
		middleName.sendKeys(mName);
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.clear();
		lastName.sendKeys(lName);
		WebElement email= driver.findElement(By.xpath("//input[@id='email_address']"));
		email.clear();
		email.sendKeys(uEmail);
		WebElement password1 = driver.findElement(By.xpath("//input[@name='password']"));
		password1.clear();
		password1.sendKeys("12345678");
		WebElement password2 = driver.findElement(By.xpath("//input[@title='Confirm Password']"));
		password2.clear();
		password2.sendKeys("12345678");
		driver.findElement(By.xpath("(//button[@title='Register'])")).click();

		// 5.
//		String welcomeMsg = driver.findElement(By.xpath("//div[@class='welcome-msg'])")).getText();
//		String msg1 = driver.findElement(By.xpath("//html[@id='top']/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")).getText();
//		System.out.println("This is Welcome Message is : " + msg1);
		String msg2 = driver.findElement(By.xpath("//html[@id='top']/body/div/div/div[2]/div/div[2]/div/div/div[2]/p/strong")).getText();
		System.out.println("This is 2nd Message : "+msg2);
//		String msg3 =driver.findElement(By.xpath("//html[@id='top']/body/div/div/div[2]/div/div[2]/div/div/div/h1")).getText();
//		System.out.println("This is 3rd Message : "+msg3);
//		String msg4 =driver.findElement(By.xpath("//html[@id='top']/body/div/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div/div[2]/p")).getText();
//		System.out.println("This is 4th Message : "+msg4);
		
		// welcome message should be
		String welMsg = ("Hello,"+" "+fName+" "+ mName+" " +lName+"!");
		System.out.println("This is welcome message : "+welMsg);
		try {
			assertEquals(msg2, welMsg);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//6. Go to TV menu	    
		driver.findElement(By.linkText("TV")).click();
	    Thread.sleep(1000);
	    
	 // 7. Add product in your wish list - use product - LG LCD	    
	    driver.findElement(By.xpath("(//a[@class='link-wishlist'])[1]")).click();
	    Thread.sleep(3000);
	    //8. Share Wish List
	    driver.findElement(By.xpath("//span[@contains='Share Wishlist')])")).click();
	    
	    driver.findElement(By.xpath("//div[@id='email_address']")).sendKeys(txtemail);
	    
	    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Hellow I am send you the wish list");
	    
	    driver.findElement(By.linkText("Share Wishlist")).click();
	    String shareMsg = driver.findElement(By.partialLinkText("Your Wishlist")).getText();
	    System.out.println("This is share message :"+shareMsg);
	    String msgShare = "Your Wishlist has been shared.";
	    try {
	    	assertEquals(shareMsg, msgShare);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }

	}
	

	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	

}
