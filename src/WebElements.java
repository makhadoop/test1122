

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElements {
	WebDriver d;
	@Test
	public void testWebElements() throws InterruptedException
	{
		
		d.manage().window().maximize();
		d.get("http://book.theautomatedtester.co.uk/");
		d.findElement(By.id("q")).sendKeys("Selenium");
		d.findElement(By.linkText("Chapter1")).click();
		WebElement radio=d.findElement(By.id("radiobutton"));
		if(radio.isSelected())
		{
			System.out.println("Radio button is already selected");
		}
		else
		{
			radio.click();
		}
		
		WebElement checkbox=d.findElement(By.name("selected(1234)"));
		if(checkbox.isSelected())
		{
			System.out.println("Check box is already selected");
		}
		else
		{
			checkbox.click();
		}
		Select dd=new Select(d.findElement(By.id("selecttype")));
		dd.selectByIndex(2);
		d.findElement(By.id("html5div")).clear();
		d.findElement(By.id("html5div")).sendKeys("Selenium");
		Thread.sleep(5000);
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
