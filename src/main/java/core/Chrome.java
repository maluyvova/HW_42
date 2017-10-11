package core;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.*;
import java.util.logging.*;

public class Chrome {
	static WebDriver driver;
	
	public static void main (String [] args) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF);
		
       String driverPath=""; 
        if (System.getProperty("os.name").toUpperCase().contains("MAC"))   driverPath="./resources/webdrivers/mac/chromedriver";
        else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) driverPath = "";
	System.setProperty("webdriver.chrome.driver", driverPath);
	System.setProperty("webdriver.chrome.silentOutput","true");
	ChromeOptions option = new ChromeOptions();
	option.addArguments("disable-infobars");
	option.addArguments("--disable-notifications");
	if (System.getProperty("os.name").toUpperCase().contains("MAC"))
       option.addArguments("-start-fullscreen");
       else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
	option.addArguments("--start-maximazed");
	else throw new IllegalArgumentException("UknowOS");
	
	driver = new ChromeDriver(option);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver,15);
	String url = "http://alex.academy/exe/payment/index2.html";
	driver.get(url);
	String payment = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_monthly_payment"))).getText();
	
	

	 String regex =  "^"
			 +"(?:\\$)"
			 +"(?:\\s*)"
			
			 
			 +"(\\d{1,}\\,\\d{1,}\\.\\d{1,})"
	+ "$";
    

	 Pattern p = Pattern.compile(regex);
	Matcher m = p.matcher(payment);
	m.find();
	  double monthly_payment = Double.parseDouble(m.group(1).replaceAll(",", ""));
	double annual_payment = new BigDecimal(monthly_payment * 12).setScale(2, RoundingMode.HALF_UP).doubleValue();

	

	                     DecimalFormat df = new DecimalFormat("0.00"); // 19854.6 =>19854.60

	

	                     String f_annual_payment = df.format(annual_payment);

	

	driver.findElement(By.id("id_annual_payment")).sendKeys(String.valueOf(f_annual_payment));

	

	                     driver.findElement(By.id("id_validate_button")).submit();

	

	                     String actual_result = driver.findElement(By.id("id_result")).getText();


                         System.out.println("Browser Crome");
                         System.out.println("http://alex.academy/exe/payment/index2.html");
	                     System.out.println("String: \t" + payment);



	                     System.out.println("Annual Payment: " + f_annual_payment);

	

	                     System.out.println("Result: \t" + actual_result);


	                     driver.quit();


	       }



	
	

    
	
	
	
	}


