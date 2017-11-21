

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class FrameDemo {
	WebDriver d;
	@Test
	public void testFrame() throws InterruptedException
	{
		d.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		d.manage().window().maximize();
		d.get("http://jqueryui.com/autocomplete/");
		//d.switchTo().frame(d.findElement(By.className("demo-frame")));
		d.switchTo().frame(0);
		assertTrue(d.findElement(By.id("tags")).isDisplayed());
		
		Thread.sleep(4000);
	}

	@BeforeMethod
	public void setUP()
	{
		d=new FirefoxDriver();
		/*System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Dec13\\Lib\\IEDriverServer.exe");
		d=new InternetExplorerDriver();*/
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Dec13\\Lib\\chromedriver"
				+ "-+-.exe");
		//d=new ChromeDriver();
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
