
package com.qa.amazon;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_amazon {
	 static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.navigate().to("https://www.amazon.in");
		
		driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("9392636336");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("sasi kumar99");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Assertions
		String Expected_Title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String Actual_Title = driver.getTitle();
		Assert.assertEquals(Actual_Title,Expected_Title);
		
		//scroll
		JavascriptExecutor js = ((JavascriptExecutor)driver);
			for(int i=0;i<10;i++) {
				js.executeScript("window.scrollBy(0,250)");
			}
			
		//mouse_over
		WebElement Lan_setting =	driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions action = new Actions(driver);
		action.moveToElement(Lan_setting).build().perform();
		WebElement Your_Orders = driver.findElement(By.xpath("//*[@id=\"nav_prefetch_yourorders\"]/span"));
		Your_Orders.click();
		
		//dropDown
	    WebElement order_history = driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
		Select select = new Select(order_history);
		System.out.println(select.getFirstSelectedOption());
		
		
		//Screenshot
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/amazon_yourOders.png");
		FileUtils.copyFile(src, dest);
		
		System.out.println("Sucessfully screenshot is taken");
		
	
	
	
	}

}