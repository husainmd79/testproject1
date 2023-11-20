package datePicker;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilityFile.XlutilityData;

public class DataDriven_newTourTest_good {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@Test(dataProvider="newtour")
	public void newTourDataDrivenTest(String Name,String Email,String Country)
	{
		driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
		WebElement Name1=driver.findElement(By.xpath("//input[@name='firstName']"));
		Name1.clear();
		Name1.sendKeys(Name);
		
		WebElement email=driver.findElement(By.xpath("//input[@id='userName']"));
		email.clear();
		email.sendKeys(Email);
		
		WebElement city=driver.findElement(By.xpath("//input[@name='city']"));
		city.clear();
		city.sendKeys( Country);
		
	}
	@DataProvider(name="newtour")
	public String [][]newTour() throws IOException
	{
		String path=".\\ExcelFile\\newtour_eclipse_dataDrivenTest.xlsx";
		XlutilityData xl=new XlutilityData(path);
		int totalrows=xl.getRowCount("sheet1");
		int totalCell=xl.getCellCount("sheet1", 1);
		String newTour[][]=new String[totalrows][totalCell];
		 
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalCell;j++)
			{
				newTour[i-1][j]=xl.getCellData("sheet1", i, j);
			}
		}
		return newTour;
		
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
