

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AjaxDemo {
	WebDriver d;
	@Test
	public void testAjax() throws InterruptedException
	{
		d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		d.manage().window().maximize();
		d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India",d.getTitle());
		Select bank=new Select(d.findElement(By.id("selBank")));
		bank.selectByIndex(4);
		Select state=new Select(d.findElement(By.id("selState")));
		state.selectByVisibleText("Andhra Pradesh");
		Select city=new Select(d.findElement(By.id("selCity")));
		city.selectByVisibleText("Hyderabad");
		Select branch=new Select(d.findElement(By.id("selBranch")));
		branch.selectByVisibleText("Sanjeeva Reddy Nagar");
		Thread.sleep(4000);
	}
	@Before
	public void setUP()
	{
		d=new FirefoxDriver();
		/*System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Dec13\\Lib\\IEDriverServer.exe");
		d=new InternetExplorerDriver();*/
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Dec13\\Lib\\chromedriver"
				+ "-+-.exe");
		//d=new ChromeDriver();
	}
	@After
	public void tearDown()
	{
		d.quit();
	}

}
