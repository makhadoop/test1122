

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class AlertDemo {
	WebDriver d;

	@Test
	public void testAlert() throws Exception
	{
		d.manage().window().maximize();
		d.get("https://irctc.co.in/");
		//assertEquals("IRCTC Online Passenger Reservation System",d.getTitle());
		d.findElement(By.id("button")).click();
		Alert al=d.switchTo().alert();
		assertEquals("Enter Value for  UserName",al.getText());
		al.accept();
		d.findElement(By.name("userName")).sendKeys("Selenium");
		d.findElement(By.id("button")).click();
		al.accept();
		d.findElement(By.name("password")).sendKeys("Selenium");
		Thread.sleep(4000);
	}
	@BeforeMethod
	public void setUP()
	{
		d=new FirefoxDriver();
		/*System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Dec13\\Lib\\IEDriverServer.exe");
		d=new InternetExplorerDriver();*/
		//System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Dec13\\Lib\\chromedriver"
		//		+ "-+-.exe");
		//d=new ChromeDriver();
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
}
