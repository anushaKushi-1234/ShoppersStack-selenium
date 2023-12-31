package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class welcomePage {

	//declaration
		
		@FindBy(id="loginBtn")
		private WebElement loginButton;

		//initialization

		public welcomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//utilization	
		public void clickLoginButton() {
			loginButton.click();
		}
}
