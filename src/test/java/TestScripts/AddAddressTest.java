package TestScripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pomPages.MyAddressPage;

public class AddAddressTest extends BaseClass{
	
	@Test
	public void addAddressTest() throws InterruptedException {
		Map<String, String> map=excel.getData("Sheet1", "Add Address");
		welcome.clickLoginButton();
		login.loginToApp(map.get("Email"), map.get("Password"));
		Thread.sleep(3000);
		home.clickProfilebutton();
		Thread.sleep(2000);
		home.selectMyProfile();
		Thread.sleep(3000);
		myProfilePage.clickMyAddresses();
		MyAddressPage.clickAddAddress();
		address.addAddressDetails(webUtil, map, jutil);
		Thread.sleep(2000);
		Assert.assertEquals(MyAddressPage.getsuccesmsg(), "Successfully added");
		Thread.sleep(2000);
	}

}
