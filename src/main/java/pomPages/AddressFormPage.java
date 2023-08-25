package pomPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.webDriverUtility;

public class AddressFormPage {

	//Declaration
	@FindBy(id="Name")
	private WebElement NameTF;
	
	@FindBy(id="House/Office Info")
	private WebElement houseInfoTF;
	
	@FindBy(id="Street Info")
	private WebElement streetInfoTF;
	
	@FindBy(id="Landmark")
	private WebElement LandMarkInfoTF;
	
	@FindBy(id="Country")
	private WebElement countryDropDown;
	
	@FindBy(id="State")
	private WebElement StateDropDown;
	
	@FindBy(id="City")
	private WebElement cityDropDown;
	
	@FindBy(id="Pincode")
	private WebElement pincodeTF;
	
	@FindBy(id="Phone Number")
	private WebElement PhoneNumberTF;
	
	@FindBy(id="//button[text()='Add Address']")
	private WebElement addAddressButton;
	
	//Initialization
	public AddressFormPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void addAddressDetails(webDriverUtility web, Map<String, String> details) {
		NameTF.sendKeys(details.get("Name"));
		houseInfoTF.sendKeys(details.get("House/Office Info"));
		streetInfoTF.sendKeys(details.get("Street Info"));
		LandMarkInfoTF.sendKeys(details.get("Landmark"));
		
		web.selectFromDropdown(details.get("Country"),countryDropDown);
		web.selectFromDropdown(details.get("State"),StateDropDown);
		web.selectFromDropdown(details.get("City"),cityDropDown);
		
		pincodeTF.sendKeys(details.get("Pincode"));
		PhoneNumberTF.sendKeys(details.get("Phone Number"));
		addAddressButton.click();	
	}
	
	}
