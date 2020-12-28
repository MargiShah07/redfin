package com.redfin.reusable;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class reusable {
	protected static WebDriver driver;
	protected static ExtentReports report;
	protected static ExtentTest logger;

	/*
	 * Name: Driver Initialization
	 * Description: Set Property and initialization of driver 
	 * 
	 *  Created By: Margi Shah
	 *  Creation Date: 20 Feb 2019
	 *  Last Modified Date: 20 Feb 2019
	 * */

	public static void InitializeDriver()
	{
		System.out.println("Start");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nilay\\Selenium\\Drivers\\chromedriver_84.exe");

		driver = new ChromeDriver(options);

	}
	
	/*
	 * Name: ExtentReport Path Initialization
	 * Description: Initialization of extent report 
	 * 
	 *  Created By: Margi Shah
	 *  Creation Date: 20 Feb 2019
	 *  Last Modified Date: 20 Feb 2019
	 * */
	
	public static void InitializePath(String path)
	{
		report=new ExtentReports(path);
	}
	
	/*
	 * Name: Launch URL
	 * Description: Launching the URL and maximizing the screen 
	 * 
	 *  Created By: Margi Shah
	 *  Creation Date: 20 Feb 2019
	 *  Last Modified Date: 20 Feb 2019
	 * */
	
	public static void Launch(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		//logger=report.startTest(logfilename);
	}

	/*
	 * Name: EnterText
	 * Description: Enter the text value in to the Text object on the page.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * Created By: Margi Shah
	 * Creation Date: 20 Feb 2019
	 * Last Modified Date: 20 Feb 2019
	 */

	public static void EnterText(WebElement obj, String objName, String textValue)
	{

		if(obj.isDisplayed())
		{
			obj.sendKeys(textValue);
			System.out.println("Pass: " + textValue + " entered in " + objName);
			//logger.log(LogStatus.PASS, "" + textValue + "entered in " + objName);
		}
		else
		{
			System.out.println("Fail: " + objName + "could not be found.");
			//logger.log(LogStatus.FAIL, "" + objName + "could not be found.");
		}

	}

	/*
	 * Name: SelectCheckbox
	 * Description: check the checkbox value of object on the page.
	 * Arguments: ObjectName : Name of the object
	 * obj: object of webelement
	 * Created By: Margi Shah
	 * Creation Date: 20 Feb 2019
	 * Last Modified Date: 20 Feb 2019
	 */

	public static void SelectCheckBox(WebElement obj, String objName)
	{
		if(obj == null)
			return;
		if (obj.isDisplayed()) {
			if(!obj.isSelected())
			{
				obj.click();
			}
			System.out.println("Pass: checkbox " + objName + " is selected");
			//logger.log(LogStatus.PASS, "" + objName + " is selected");
		}
		else
		{
			System.out.println("Fail: " + objName + " could not be found");
			//logger.log(LogStatus.FAIL, "" + objName + " could not be found");
		}
	}

	/*
	 * Name: Clear Text 
	 * Description: clear the Text value of object on the page.
	 * Arguments: obj: object of webelement
	 *  Created By: Margi Shah
	 *  Creation Date: 20 Feb 2019
	 *  Last Modified Date: 20 Feb 2019
	 * */

	//public static void ClearText(By location, String objName, String textValue)

	public static void ClearText(WebElement obj)
	{
		obj.clear();
	}

	/*
	 * Name: click_On_Link
	 * Description: click the link object on the page.
	 * Arguments: ObjectName : Name of the object
	 * obj: object of webelement
	 * Created By: Margi Shah
	 * Creation Date: 20 Feb 2019
	 * Last Modified Date: 20 Feb 2019
	 */
	
	public static void click_On_Link(WebElement obj,String objName)
	{
		if(obj==null)
			return;
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("Pass: " +objName+ " is Clicking on Link");
			//logger.log(LogStatus.PASS, "" +objName+ " is Clicking on Link");
		}
		else
		{
			System.out.println("Fail:" + objName + " No such link Found to perform the click Action" );
			//logger.log(LogStatus.FAIL, "" + objName + " No such link Found to perform the click Action");
		}
	}
	
	/*
	 * Name: click_On_Button
	 * Description: click the button on the page.
	 * Arguments: ObjectName : Name of the object
	 * obj: object of webelement
	 * Created By: Margi Shah
	 * Creation Date: 20 Feb 2019
	 * Last Modified Date: 20 Feb 2019
	 */
	public static void click_On_Button(WebElement obj,String objName)
	{
		if(obj==null)
			return;
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("Pass: " +objName+ " is Clicking on Button");
			//logger.log(LogStatus.PASS, "" +objName+ " is Clicking on Button");
		}
		else
		{
			System.out.println("Fail:" + objName + " No such button Found to perform the click Action" );
			//logger.log(LogStatus.FAIL, "" + objName + " No such button Found to perform the click Action");
		}
	}
	
	/*
	 * Name: findElement
	 * Description: find elements of object on the page.
	 * Arguments: location: xpath of the object
	 * objName: Name of the object
	 * 
	 * Created By: Margi Shah
	 * Creation Date: 20 Feb 2019
	 * Last Modified Date: 20 Feb 2019
	 */

	public static WebElement findElement(By location, String objName)
	{
		WebElement obj = null;
		try
		{
			obj = driver.findElement(location);
			System.out.println("Pass: " + objName+ " found on the page.");
			//logger.log(LogStatus.PASS, "" + objName+ " found on the page.");
		}
		catch(NoSuchElementException errMessage)
		{
			System.out.println("Fail: " + objName + "could not be found in the page.");
			//logger.log(LogStatus.FAIL, "" + objName + "could not be found in the page.");
		}
		return obj;
	}
	

	/*
	 * Name: Drop down
	 * Description: dropdown menu on the page.
	 * Arguments: obj: object of webelement
	 * text: text value of the object
	 * 
	 * Created By: Margi Shah
	 * Creation Date: 20 Feb 2019
	 * Last Modified Date: 20 Feb 2019
	 */
	
	public static void DropDown(WebElement obj,String text)
	{
		if(obj.isDisplayed())
		{
			Select drpdwn = new Select(obj);
			drpdwn.selectByVisibleText(text);
			System.out.println("Pass:" +text + " is selected");
			//logger.log(LogStatus.PASS, "" +text + " is selected");
		}
		else
		{
			System.out.println("Fail:" +text+ " is not selected");
			//logger.log(LogStatus.FAIL, "" +text+ " is not selected");
		}
	}
	
	public boolean verify_Text( String actualText, String expectedText,String elementName) {
//		System.out.println(actualText +" "+expectedText);
		if (actualText.contains(expectedText)) {
//			logger.log(LogStatus.PASS, elementName + " text is validated");
			return true;
		} else {
//			logger.log(LogStatus.FAIL, elementName + " text is not validated");
			return false;

		}
	}
	
	//end report
//	public static void EndReport() 
//	{
//		report.endTest(logger);
//		report.flush();
//		System.out.println("End");
//	}
}
