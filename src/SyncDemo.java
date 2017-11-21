

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;




import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
public class SyncDemo {
	WebDriver d;
	@Test
	public void testSync() throws InterruptedException
	{
		//d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		d.manage().window().maximize();
		d.get("https://www.google.co.in/");
		assertEquals("Google",d.getTitle());
		d.findElement(By.name("q")).sendKeys("Selenium");
		d.findElement(By.id("lst-ib")).click();
		WebDriverWait wait=new WebDriverWait(d,10);
		WebElement link=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selenium - Web Browser Automation")));
		link.click();
		//d.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		d.findElement(By.linkText("Download")).click();
		//assertEquals("Selenium IDE",d.findElement(By.xpath("//div[@id='mainContent']/h3")).getText());
		assertTrue(d.findElement(By.xpath("//div[@id='mainContent']/h3")).getText().contains("Selenium IDE"));
		Thread.sleep(4000);
	}
	
	@Before
	public void setUP()
	{
		d=new FirefoxDriver();
		/*System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Dec13\\Lib\\IEDriverServer.exe");
		d=new InternetExplorerDriver();*/
		//System.setProperty("webdriver.chrome.driver", "F:\\Bhavana\\SelJars\\Browsers\\Chrome\\chromedriver.exe");
		
		//d=new ChromeDriver();
	}
	@After
	public void tearDown()
	{
		d.quit();
	}


}
