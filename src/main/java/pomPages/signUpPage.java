package pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signUpPage {

	//Declaration
		@FindBy (id="First Name")
	   private WebDriver firstNameTF;
	   @FindBy (id="Last Name")
	   private WebElement LastNameTF;
	   @FindBy(xpath = "//div[@id='Gender']/descendant::label/span[2]")
	   private List<WebElement> genderRadioButton;
	   @FindBy(id="Phone Number")
	   private WebElement phoneNumberTF;
	   @FindBy (id="Email Address")
	   private WebElement emailAddressTF;
	   @FindBy (id="Password")
	   private WebElement passwordTF;
	   @FindBy(id="Confirm Password")
	   private WebElement confirmpasswordTF;
	   private WebElement termsAndConditionsCB;
	   @FindBy (xpath = "//button[text()='Register']")
	   private WebElement registerButton;
	   
	   //Initialization
	   public  signUpPage(WebDriver driver) {
		   PageFactory.initElements(driver, this);
		   
	   }
	   
	   //Utilization
	   public void createUserAccount(String FirstName,String LastName,String expectedGender,String PhoneNum,String email,String Password) {
		((WebElement) firstNameTF).sendKeys(FirstName);
		 LastNameTF.sendKeys(LastName);
		 
		 for(WebElement element:genderRadioButton) {
			 String gender = element.getText();
			 if(gender.equals(expectedGender)) {
				 element.click();
				 break;
				 
			 }
		 }
		 
		 phoneNumberTF.sendKeys(PhoneNum);
		 emailAddressTF.sendKeys(email);
		 passwordTF.sendKeys("password");
		 confirmpasswordTF.sendKeys("confirmpassword");
		 termsAndConditionsCB.click();
		 
		 registerButton.click();
	   } 

	}

