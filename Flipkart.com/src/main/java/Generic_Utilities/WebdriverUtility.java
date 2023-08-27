package Generic_Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of all webdriver related methods
 * @author NETHRADHANU
 *
 */
public class WebdriverUtility 
{
	
	
	/**
	 * This method is used to maximize the browser window  //3.141.59
	 * @param driver
	 */
	public void maximizeWinow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method will wait until the page get loaded
	 * @param driver
	 */
	public void waitTillPageGetLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstants.implicitWaitDuration));
		
	}
	/**
	 * This method will wait till element visible in the Ui 
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait till the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait till the alert present in the Ui
	 * @param driver
	 */
	public void waitForAlertPopup(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * this method waits until title to be visible in webpage
	 * @param driver
	 * @param title
	 */
	
	public void waitForATitle(WebDriver driver,String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 *  this method waits until the url to visible in the webpage 
	 * @param driver
	 * @param url
	 */
	public void waitForAUrl(WebDriver driver,String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * this method will ignore if its get noSuchElementException
	 * @param driver
	 */
	public void ignoreNoSuchElementExc(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * this method used to select element in dropdown based on index
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this method used to select element in dropdown based on value
	 * @param element
	 * @param value
	 */
	public void selectElementInDropdown(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * this method used to select element in dropdown based on visibleText
	 * @param text
	 * @param element
	 */
	public void selectElementInDropdown(String text,WebElement element)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * this method will fetch all the options present in the dropdown
	 * @param element
	 */
	public void getAllOptionsFromDropdown(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) 
		{
			String text = option.getText();
			System.out.println(text);
		}
	}
	/**
	 * this method is used to mouse over on an element
	 * @param driver
	 * @param element
	 */
		public void mouseOverOnElement(WebDriver driver,WebElement element)
		{
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}
//
/**
 * this method is used to perform right click action
 * @param driver
 * @param element
 */
public void rightClickOnElement(WebDriver driver,WebElement element)
{
	Actions action = new Actions(driver);
	action.contextClick(element).perform();
}
/**
 * this method is used to double click on an element
 * @param driver
 * @param element
 */
public void doubleClickOnElement(WebDriver driver,WebElement element)
{
	Actions action = new Actions(driver);
	action.doubleClick(element).perform();
}
/**
 * this method is used to switch frame based on index
 * @param driver
 * @param index
 */
public void switchFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * this method is used to switch frame based on id
 * @param driver
 * @param id
 */
public void switchToFrame(WebDriver driver,String id)
{
	driver.switchTo().frame(id);
}
/**
 * this method is used to switch frame based on webElement
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * this method is used to switch to the main frame of a webpage
 * @param driver
 */
public void switchToFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * this method is used to accept the alert popup
 * @param driver
 * @param text
 */
public void switchToAlertPopupAndAccept(WebDriver driver,String text) 
{
	Alert alt = driver.switchTo().alert();
//	String t = alt.getText();
//	System.out.println(t);
	if(alt.getText().trim().contains(text.trim()))
	{
		System.out.println("alert is present");
	}else {
		System.out.println("alert is not present");
	}
	alt.accept();
}
/**
 * this method is used to dismiss the alert popup
 * @param driver
 * @param text
 */
public void switchToAlertPopupAndDismiss(WebDriver driver,String text)
{
	Alert alt = driver.switchTo().alert();
	if(alt.getText().trim().equalsIgnoreCase(text.trim()))
	{
		System.out.println("alert is present");
	}else {
		System.out.println("alert is not present");
	}
	alt.dismiss();
}
/**
 * this method is used to handle fileUploadPopup
 * @param element
 * @param path
 */
public void fileUpload(WebElement element,String path)
{
	element.sendKeys(path);
}

/**
 * this method is used to provide user own polling time
 * @param duration
 * @param element
 * @param pollingTime
 */
public void customWait(int duration,WebElement element,long pollingTime)
{
	int count=0;
	while(count<duration)
	{
		try {
			element.click();
			break;
		} catch (Exception e) {
			try {
				Thread.sleep(pollingTime);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			count++;
		}
	}
}
/**
 * this method is used to get screenShots 
 * @param driver
 * @param screenShotName
 * @return
 * @throws IOException
 */
public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
{
	TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
	File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
	LocalDateTime localDateTime = LocalDateTime.now();
	File dst = new File("./sceenShots/"+screenShotName+""+localDateTime+".png");
	FileUtils.copyFile(src, dst);
    return screenShotName;
}
/**
 * this method is used to switch to child window
 * @param driver
 * @param title
 */
public void switchWindow(WebDriver driver,String title)
{
	Set<String> set = driver.getWindowHandles();
	for (String wdw : set) 
	{
		driver.switchTo().window(wdw);
		String text = driver.getTitle();
		if(text.contains(title))
		{
			break;
		}
	}
}
/**
 * this method is used to switch to child window
 * @param driver
 * @param url
 */
public void switchingWindow(WebDriver driver,String url)
{
Set<String> set = driver.getWindowHandles();
Iterator<String> it = set.iterator();
while(it.hasNext())
{
	String wid = it.next();
	driver.switchTo().window(wid);
	String text = driver.getCurrentUrl();
	if(text.contains(url))
	{
		break;
	}
}
}
}



