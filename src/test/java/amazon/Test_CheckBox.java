package amazon;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_CheckBox {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.twoplugs.com ");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void testCheckBox() throws IOException
	{
		WebElement country=driver.findElement(By.xpath(" //a[normalize-space()='Contact']"));
		JavascriptExecutor js=(JavascriptExecutor )driver;
		js.executeScript("arguments[0].style.border='3px solid red'",country);
		
		File src=country.getScreenshotAs(OutputType.FILE);
		String ter=".\\ScreenShot\\contact.png";
		File f=new File(ter);
		FileUtils.copyFile(src, f);
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
