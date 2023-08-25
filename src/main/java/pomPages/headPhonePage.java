package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class headPhonePage {

	//Declaration
		@FindBy(xpath = "//span [text()='boat rockerz 450']/ancestor::div[@class='featuredProducts_cardFooter__qL8vT']/descendent ::button")
		private WebElement AddTocartButton;
		@FindBy(xpath = "//span [text()='boat rockerz 450']")
		private WebElement itemName;
		
		//Initialization
		
		public headPhonePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public void clickAddToCart() {
			AddTocartButton.click();
				
		}
		
		public String getAddToCartText() {
			return AddTocartButton.getText();

		}
	    public String  getitemNameString() {
		return itemName.getText();
		
	}
	}

