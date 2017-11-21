
import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDemo {
	WebDriver d;
	@Before
	public void setUP()
	{
		d=new FirefoxDriver();
		/*System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Dec13\\Lib\\IEDriverServer.exe");
		d=new InternetExplorerDriver();*/
		//System.setProperty("webdriver.chrome.driver", "F:\\Bhavana\\SelJars\\Browsers\\Chrome\\chromedriver.exe");
	//	d=new ChromeDriver();
	}
	@Test
	public void testWebDemo() throws Exception
	{
		d.manage().window().maximize();
		d.get("https://www.google.co.in");
		assertEquals("Google",d.getTitle());
		d.findElement(By.id("lst-ib")).sendKeys("Selenium");
		//d.findElement(By.name("q")).sendKeys("Selenium");
		//d.findElement(By.className("gbqfif")).sendKeys("Selenium");
		//d.findElement(By.id("gbqfb")).click();
		d.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
		d.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		
		//d.findElement(By.xpath("//div[@id='gbwa']/div/a")).click();
		//d.findElement(By.cssSelector("a.gb_q.gb_g")).click();
		//d.findElement(By.linkText("YouTube")).click();
		//d.findElement(By.partialLinkText("Tube")).click();
		Thread.sleep(4000);
	}
	@After
	public void tearDown()
	{
		d.quit();
	}

}
