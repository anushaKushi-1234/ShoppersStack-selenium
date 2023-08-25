package genericLibraries;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtility {
	private WebDriver driver;
	
	public WebDriver navigateToApp(String browser, String url, long time) {
		
		
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			HashMap<String, Boolean> prefs=new HashMap<String, Boolean>();
			prefs.put("autofill.profile_enabled", false);
			
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			driver=new ChromeDriver();
			break;
			
		case "edge":
			driver=new ChromeDriver();
			break;

		default:
			System.out.println("Invalid browser Info");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return driver;
	}

	//ExplicitWait//
	public WebElement explicitWait(long time, WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
	return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement explicitWait(WebElement element, long time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public Boolean explicitWait(long time, String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void mouseHover(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	
	public void doubleClickOnElement(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	
	public void rightClick(WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void dragAndDropAnElement(WebElement element, WebElement target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}
	
	public void selectFromDropdown(WebElement element, int index) {
       Select select=new Select(element);
       select.selectByIndex(index);
	}
	
	public void selectFromDropdown(WebElement element, String value) {
		 Select select=new Select(element);
	       select.selectByValue(value);
	}
	
	public void selectFromDropdown( String text, WebElement element) {
		 Select select=new Select(element);
	       select.selectByVisibleText(text);
	}
	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		}
	
	public void switchToFrame(String idorName) {
		driver.switchTo().frame(idorName);
		}
	
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		}
	
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguements[0].scrollIntoView(true)", element);
	}
	
	public void handAlert(String status) {
	Alert al=driver.switchTo().alert();
	if(status.equalsIgnoreCase("ok")) {
		al.accept();
	}
	else {
		al.dismiss();
	}
	
}
	public void switchTochildBrowser() {
		Set<String> set= driver.getWindowHandles();
		for (String s: set) {
			driver.switchTo().window(s);
		}
	}
	public void switchToWindow(String id) {
		driver.switchTo().window(id);
	}
	
	public String getParentWindowId() {
		return driver.getWindowHandle();	
		}
	
	public void closeBrowser() {
		driver.close();
	}
	public void closeallBrowsers() {
		driver.quit();
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	

