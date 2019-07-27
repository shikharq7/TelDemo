package telstrademo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCommonDriver {
	private long lngPageLoadTimeOut;
	private long lngElementDetectionTimeOut;
	WebDriver driver;

	TestCommonDriver() {
		
		lngPageLoadTimeOut = 60L;
		lngElementDetectionTimeOut = 30L;
	}

	public void openBrowser(String sBrowserType) {
		if (sBrowserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\NINDIYA PC\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (sBrowserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\NINDIYA PC\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(lngPageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(lngElementDetectionTimeOut, TimeUnit.SECONDS);
		driver.get("about:blank");
		
	
	}
	
	public void signin()
	{ 
	driver.findElement(By.xpath("//a[contains(@class,'login')]")).click();
	driver.findElement(By.xpath("//input[contains(@name,'email_create')]")).clear();
	driver.findElement(By.xpath("//input[contains(@name,'email_create')]")).sendKeys("testdemo@gmail.com");
	driver.findElement(By.xpath("//button[contains(@name,'SubmitCreate')]")).click();
	driver.findElement(By.id("uniform-id_gender1")).click();
	driver.findElement(By.id("customer_firstname")).sendKeys("Shikhar");
	driver.findElement(By.id("customer_lastname")).sendKeys("Sharma");
	driver.findElement(By.id("passwd")).sendKeys("12345");

	Select day= new Select (driver.findElement(By.id("days")));
	day.selectByValue("10");
	Select month= new Select (driver.findElement(By.id("months")));
	month.selectByValue("12");
	Select year= new Select (driver.findElement(By.id("years")));
	year.selectByValue("1988");
	driver.findElement(By.id("company")).sendKeys("ABC");
	driver.findElement(By.id("address1")).sendKeys("1234");
	driver.findElement(By.id("city")).sendKeys("Melbourne");
	Select state= new Select (driver.findElement(By.id("id_state")));
	state.selectByIndex(1);
	driver.findElement(By.id("postcode")).sendKeys("31223");
	Select coun= new Select (driver.findElement(By.id("id_country")));
	coun.selectByIndex(1);
	driver.findElement(By.id("phone_mobile")).sendKeys("40012000");
	driver.findElement(By.id("alias")).sendKeys("Test123");
	driver.findElement(By.id("submitAccount")).click();
	
	
	
		
	} 

	public void navigateToUrl(String sUrl) {
		driver.get(sUrl);
		
	}

}