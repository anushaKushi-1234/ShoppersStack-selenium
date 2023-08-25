import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.JavaUtility;
import pomPages.signUpPage;

public class RegisterShopperTest extends BaseClass{

	@Test
	public void createAccountTest() throws InterruptedException {
		welcome.clickLoginButton();
		login.clickCreateAccountButton();
		Map<String, String> map=excel.getData("Sheet1", "Shopper Registration");
		int randomNum=jutil.generateRandomNum(100);
		//String firstName=map.get("First Name") + randomNum;
	  //String lastName=map.get("Last Name") + randomNum;
		String email=randomNum + map.get("Email Address");
		String pwd=map.get("Password") + randomNum;
		signUp.createUserAccount(map.get("First Name"), map.get("Last Name"), map.get("Gender"), map.get("Phone Number"), email, pwd);
	Thread.sleep(2000);
	
	welcome.clickLoginButton();
	login.loginToApp(map.get("Email Address"), map.get("Password"));
	
	
	
	Assert.assertTrue(driver.getTitle().contains("Home"));
	
	
	
	}
	
}
