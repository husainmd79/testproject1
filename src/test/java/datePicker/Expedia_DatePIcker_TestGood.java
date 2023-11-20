package datePicker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Expedia_DatePIcker_TestGood {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.Expedia.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
	}
	@Test
	public void datePickerTest()
	{
		String MoYr="January 2024";
		String date1="25";
		driver.findElement(By.xpath("//button[@name='EGDSDateRange-date-selector-trigger']")).click();
		while(true)
		{
			WebElement moyr=driver.findElement(By.xpath("//span[@class='uitk-align-center uitk-month-label']"));
			if(moyr.getText().equals(MoYr))
			{
				break;
			}
			else 
				{
					driver.findElement(By.xpath("//div[@class='uitk-cal-controls-button uitk-cal-controls-button-inset-multi uitk-cal-controls-button-next']")).click();
				}
			}
		List<WebElement> allDate=driver.findElements(By.xpath("(//tbody)[1][@class='uitk-day-wrap']//div"));
		for(WebElement date:allDate)
		{
			if(date.getText().equals(date1))
			{
				date.click();
				break;
			}
				
		}
		
		}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	}


