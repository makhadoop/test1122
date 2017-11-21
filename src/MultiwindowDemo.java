

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class MultiwindowDemo {
	WebDriver d;
	@Test
	public void testMultiWindow() throws InterruptedException
	{
		d.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		d.manage().window().maximize();
		d.get("https://irctc.co.in/");
		assertEquals("IRCTC Online Passenger Reservation System",d.getTitle());
		String pcode=d.getWindowHandle();
		System.out.println("Parent window code is: "+pcode);
		d.findElement(By.linkText("Tour Packages")).click();
		for(String ccode:d.getWindowHandles())
		{
			System.out.println("Child window code is: "+ccode);
			d.switchTo().window(ccode);
		}
					
		assertTrue(d.findElement(By.linkText("About Us")).isDisplayed());
		d.switchTo().window(pcode);
		assertTrue(d.findElement(By.name("userName")).isDisplayed());
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
