

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class OnloadAlertDemo {
	WebDriver d;

	@Test
	public void testOnloadAlert() throws Exception
	{
		d.manage().window().maximize();
		d.get("http://www.dailyfreecode.com/code/simple-display-alert-onload-event-page-2194.aspx");
		Alert al=d.switchTo().alert();
		assertEquals("This is syntax-example.com site.",al.getText());
		al.accept();
		assertTrue(d.findElement(By.id("hlHome")).isDisplayed());
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
