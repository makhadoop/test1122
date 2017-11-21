

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ConfirmationsDemo {
	WebDriver d;

	@Test
	public void testConfirmation() throws Exception
	{
		d.manage().window().maximize();
		d.get("http://jsbin.com/enifaf");
		d.findElement(By.xpath("//button[@onclick='launchConfirm()']")).click();
		Alert al=d.switchTo().alert();
		assertEquals("Press a button!",al.getText());
		al.accept();
		//al.dismiss();
		assertTrue(d.findElement(By.id("chosenButton")).getText().contains("You pressed OK"));
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
	//	d.quit();
	}
}
