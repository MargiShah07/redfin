package com.redfin.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.redfin.reusable.reusable;
import com.relevantcodes.extentreports.LogStatus;

public class TestCase extends reusable{

	public static void main(String[] args) throws InterruptedException {
		TestCase AllTC = new TestCase();
		String path="C:\\Users\\Nilay\\ExtentReports\\RedfinReports.html";
		InitializePath(path);

		AllTC.TestCase1();

		report.flush();
		System.out.println("End");

	}
	public void TestCase1() throws InterruptedException
	{
		System.out.println("TestCase1");
		logger = report.startTest("Navigate to redfin");
		InitializeDriver();
		logger.log(LogStatus.INFO, "Chrome browser Launched.");
		Launch("https://www.redfin.com/");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Real Estate, Homes for Sale, MLS Listings, Agents | Redfin";

		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title Matched");
			logger.log(LogStatus.PASS," Redfin page is displayed.");
		}
		else
		{
			System.out.println("Title didn't match");
			logger.log(LogStatus.FAIL," Redfin page is not displayed.");
		}

		WebElement search = findElement(By.id("search-box-input"), "SearchBox");
		EnterText(search,"Search Box", "Sunnyvale");
		if(search.isDisplayed())
		{	
			logger.log(LogStatus.PASS, " Sunnyvale is displayed in search field");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Sunnyvale is not displayed in search field");
		}

		WebElement entersearch = findElement(By.xpath("//div[@class='SearchBox showResults']//button[@class='inline-block SearchButton clickable float-right']"), "EnterSearch");
		entersearch.sendKeys(Keys.ENTER);

		if(entersearch.isDisplayed())
		{	
			logger.log(LogStatus.PASS, " Sunnyvale is clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Sunnyvale is not clicked");
		}
		//		driver.switchTo().alert();
		//		WebElement Popup = findElement(By.className("guts"), "popup");
		//		Popup.isDisplayed();
		//		System.out.println("Popup is present");

		//		if(Popup.isDisplayed())
		//		{
		//			System.out.println("Popup: Did You Mean is present");
		//		}
		//		else
		//		{
		//			System.out.println("Popup is not present");
		//		}
		//		Thread.sleep(3000);

		//		WebDriverWait wait = new WebDriverWait(driver, 20 /*timeout in seconds*/);
		//		wait.until(ExpectedConditions.alertIsPresent());
		WebDriverWait wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'resultsView')]//div[1]//div[1]//div[2]//a[1]"))) != null)
			//		if(wait.until(ExpectedConditions.alertIsPresent())==null)
			//		    System.out.println("Popup is not present");
			//		else
		{
			System.out.println("Popup: Did You Mean is present");
			logger.log(LogStatus.PASS, "Popup: Did you mean. is Present");
		}
		else
		{
			System.out.println("Popup: Did You Mean is not present");
			logger.log(LogStatus.FAIL, "Popup: Did You Mean is not present");
		}

		Thread.sleep(3000);


		WebElement city = findElement(By.linkText("Sunnyvale"), "Cities");
		city.click();
		//		if(city.isSelected())
		//		{	
		//			logger.log(LogStatus.PASS, " Sunnyvale Real Estate Page is navigated");
		//		}
		//		else
		//		{
		//			logger.log(LogStatus.FAIL, " Sunnyvale Real Estate Page is not navigated");
		//		}

		WebElement searchtag = findElement(By.className("textContent"), "sunnyvaletag");
		String actualTitle1 = searchtag.getText();
		String expectedTitle1 = "Sunnyvale";
		//		Assert.assertTrue(verify_Text(actualTag, expectedTag, "city Tag"));
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("Sunnyvale Text Matched in searchbar on left");
			logger.log(LogStatus.PASS," Sunnyvale city is mentioned in searchbar.");
		}
		else
		{
			System.out.println("Sunnyvale Text didn't Match in searchbar on left");
			logger.log(LogStatus.FAIL," Sunnyvale city is not mentioned in searchbar.");
		}

		//		minprice.selectByVisibleText("$800k");

		WebElement minprice = findElement(By.xpath("//span[contains(text(),'No min')]"),"MinimumPrice");
		minprice.click();
		Thread.sleep(2000);

		//		Select drpdown = new Select(driver.findElement(By.))
		//		Thread.sleep(2000);
		//		drpdown.selectByVisibleText("$800k");

		logger.log(LogStatus.PASS, "minimum Value entered.");

		//		minprice.click();


		//		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		//		System.out.println("list of citis" + anchors);
		//		for(WebElement city : anchors) {
		//			  String attributeValue=city.getAttribute("href");
		//			 
		//		        Object cityToBeSelected = null;
		//				if(cityToBeSelected.equals(attributeValue)) {
		//		        	 
		//		        	JavascriptExecutor executor = (JavascriptExecutor)driver;
		//				    executor.executeScript("arguments[0].click();", city);
		//				    logger.log(LogStatus.PASS, "city selected from popup");
		//		            break;
		//		        }
		//		}


		Thread.sleep(2000);
		driver.close();
		report.endTest(logger);

	}


}
