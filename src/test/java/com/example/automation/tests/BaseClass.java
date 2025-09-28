package com.example.automation.tests;// Changed package name to 'base' for better structure

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;
	@BeforeClass
	public void setup() throws IOException {
		// Initialize Chrome Driver using WebDriverManager
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Set a low implicit wait; reliance is on explicit waits per requirements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		FileInputStream file = new FileInputStream(
				"C:\\Users\\dheeraj\\eclipse-workspaces\\Datagrid\\src\\test\\resources\\config.properties");
		 p = new Properties();
		
		p.load(file);

		driver.get(p.getProperty("baseURL"));

	}

	public void scrolllintoView(WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public String captureScreen(String tname) throws IOException {
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String targetfilepath = "C:\\Users\\dheeraj\\eclipse-workspaces\\Datagrid\\screenshots\\" + tname + " "
					+ timeStamp + ".png";// = System.getProperty("user.dir")+"\\screenshots\\"
			File targetfile = new File(targetfilepath);

			SourceFile.renameTo(targetfile);
			return targetfilepath;

		}
		

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
