
import org.testng.annotations.*;

public class TestNGAnnotationsDemo {
	@BeforeClass
	public void meth1()
	{
		System.out.println("This is @BeforeClass code");
	}
	@AfterClass
	public void meth2()
	{
		System.out.println("This is @AfterClass code");
	}
	@BeforeMethod
	public void meth3()
	{
		System.out.println("This is @BeforeMethod code");
	}
	@AfterMethod
	public void meth4()
	{
		System.out.println("This is @AfterMethod code");
	}
	
	@BeforeTest
	public void meth5()
	{
		System.out.println("This is @BeforeTest code");
	}
	@AfterTest
	public void meth6()
	{
		System.out.println("This is @AfterTest code");
	}
	@Test
	public void meth7()
	{
		System.out.println("This is first @Test code");
	}
	@Test
	public void meth8()
	{
		System.out.println("This is second @Test code");
	}

}

