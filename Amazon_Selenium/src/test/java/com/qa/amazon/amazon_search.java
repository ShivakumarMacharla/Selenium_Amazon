package com.qa.amazon;



import java.io.File;

import java.io.IOException;

import java.util.concurrent.TimeUnit;



import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;



public class amazon_search {

	static WebDriver driver;

	@Test(dataProvider ="search_data",dataProviderClass = amazon_Data.class)

	public void maintest(String Data) throws IOException {

		driver.navigate().to("https://www.amazon.in");

		WebElement Search_bar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		Search_bar.sendKeys(Data);

		Search_bar.sendKeys(Keys.ENTER);

		if(Data.equals("mirror")) {

			driver.findElement(By.xpath("//*[@id=\"CardInstance3sOT_qX6OeAhUmpVgH0CGA\"]/div[1]/div/div[2]/div[2]/div[1]/div/a[2]/div/div[1]/img")).click();

			driver.findElement(By.id("buy-now-button")).click();	

			

		 Assert.assertTrue(driver.findElement(By.linkText("Checkout")).isDisplayed());

			

			//Screenshot

			screenshot();

			

			System.out.println("mirror");

			

		}

		else if(Data.equals("iphone")) {

			System.out.println("iphone");

			

		}

		else if(Data.equals("books")) {

			System.out.println("books");

			

		}

		else if(Data.equals("shoes")){

			System.out.println("shoes");

			

		}

		

		

		

	}

	@BeforeTest

	public void launch() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		

		

	}

	@AfterTest

	public void taredown() {

		driver.close();

	}



	public void screenshot() throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File("./screenshots/image3.png");

		FileUtils.copyFile(src, dest);

	}

	

	}