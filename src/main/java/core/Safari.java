package core;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.util.regex.*;

public class Safari {
	static WebDriver driver;
	public static void main (String [] args) {
		
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		if (!System.getProperty("os.name").contains("Mac")) {throw new IllegalArgumentException("Safari is available only on Mac");}
		
		driver = new SafariDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,15);
		String url = "http://alex.academy/exe/payment/indexE.html";
		driver.get(url);
		String payment = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_monthly_payment"))).getText();
		
		

		 String regex =  //"^"
				 //+"(:?\\$)?"
				 //+"(\\d\\,\\d{3}\\.\\d{2})?"
				 //+"($)";
				 "^"
  + "(?:\\$)?"
 + "((?:\\d{1,3})(?:\\,)?(?:\\d{3})?(?:\\.)?(\\d{0,2})?)"
+ "$";
			System.out.println(regex);	 
				 
				 ;

		 Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(payment);
		m.find();
		  double monthly_payment = Double.parseDouble(m.group(1).replaceAll(",", ""));
		double annual_payment = new BigDecimal(monthly_payment * 12).setScale(2, RoundingMode.HALF_UP).doubleValue();

		

		                     DecimalFormat df = new DecimalFormat("0.00"); // 19854.6 =>19854.60

		

		                     String f_annual_payment = df.format(annual_payment);

		

		driver.findElement(By.id("id_annual_payment")).sendKeys(String.valueOf(f_annual_payment));

		

		 WebElement line = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_validate_button")));
	     ((JavascriptExecutor)driver).executeScript("arguments[0].click();", line);

		

		                     String actual_result = driver.findElement(By.id("id_result")).getText();


	                         System.out.println("Browser Safari");
	                         System.out.println("http://alex.academy/exe/payment/indexE.html");
		                     System.out.println("String: \t" + payment);



		                     System.out.println("Annual Payment: " + f_annual_payment);

		

		                     System.out.println("Result: \t" + actual_result);


		                     driver.quit();


		       }



		
	
}
