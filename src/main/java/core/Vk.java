package core;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;


public class Vk {
	
	public static void main (String [] args)  throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF);
		String email ="19168466720";
		String password = "maluyvova1995";
		String user = " Mozilla/5.0 (iPad; CPU OS 10_1_1 like Mac OS X) AppleWebKit/602.2.14 (KHTML, like Gecko) Version/10.0 Mobile/14B100 Safari/602.1";
		String driverPath="";
		String url = "https://vk.com/";
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))     driverPath="./resources/webdrivers/mac/geckodriver.sh";
		   else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) driverPath="./resources/webdrivers/pc/chromedriver.exe";
		FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
		options.addPreference("general.useragent.override", user);
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		   
		   WebDriver driver = new FirefoxDriver(options);
		 
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait (driver,15);
			driver.manage().window().setSize(new Dimension(1024,768));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/form/dl[1]/dd/div/input"))).sendKeys(email);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/form/dl[2]/dd/div/input"))).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/div[1]/input"))).click();
		final long start = System.currentTimeMillis();
		String title = driver.getTitle();
		final long finish=System.currentTimeMillis();
		System.out.println("Title of thsi page is" + title);
		System.out.println("Waiting time was :" + (finish-start));
	
		
		
		System.out.println((String)((JavascriptExecutor)driver).executeScript("return navigator.userAgent"));
		
	}

}
