package core;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
public class Amazon{
	static WebDriver driver;
	/*public static boolean Present(By by) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty()) return true;
		else return false;
	}*/
	public static void main (String [] args) {
		Logger.getLogger("").setLevel(Level.OFF);
		String url = "https://www.amazon.com/gp/product/B002USUJV0/ref=s9_acsd_top_hd_bw_b9Lkhnn_c_x_w?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-4&pf_rd_r=Y0R1W392GQ90BGYG3ZYK&pf_rd_t=101&pf_rd_p=8c925d07-027a-53b5-94f7-6a62fdcbebf3&pf_rd_i=8566630011";
		WebDriver driver = new HtmlUnitDriver();
		((HtmlUnitDriver)driver).setJavascriptEnabled(true);
		driver.get(url);
		/*By mainPicture =By.xpath ("//*[@id=\"landingImage\"]");
		By productTitle = By.id("productTitle");
		By addToCart=By.xpath("//*[@id=\"add-to-cart-button\"]");
		By mainPrice=By.id("priceblock_ourprice");
		System.out.println("Browser:HtmlUnit");
		System.out.println("Page url: " + driver.getCurrentUrl());
		System.out.println("01.mainPicture"+(Present(mainPicture)?"Exists":"Not Exists"));
		System.out.println("productTitle"+(Present(productTitle)?"Exists":"Not Exist"));*/
		
		String x [] = {"//*[@id=\"landingImage\"]","//*[@id=\"add-to-cart-button\"]"};

		for (int i =0; i<x.length;i++)
			 if (!driver.findElements(By.xpath(x[i])).isEmpty()) {
				 System.out.println(" Element is Present");
			 }else {System.out.println(" Element is not Present");
			 }
		String y [] = {"productTitle","priceblock_ourprice"};
		for (int i =0; i<x.length;i++)
		 if (!driver.findElements(By.id(y[i])).isEmpty()) {
			 System.out.println(" Element is Present");
		 }else {System.out.println(" Element is not Present");
		 }
	}
}