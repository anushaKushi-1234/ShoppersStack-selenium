package TestScripts;

import java.util.Map;

import genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass{
	Map<String, String> map=excel.getData("Sheet1", "Add to cart");
	welcome.clickLoginButton();
	login.loginToApp(map.get("Email"), map.get("Password"));
	Thread.sleep(2000);
	
	home.mouseHoverElectronic(webUtil);
	Thread.sleep(2000);
	
	home.clickHeadPhonesLink();
	headPhone.clickAddToCart();
	Thread.sleep(2000);
	
	Assert.assertequals(headPhone.getAddToCartText(), "ADDED");
	String itemName=headPhone.getItemName();
	headPhone.clickcartIcon();
	Assert.assertTrue(cart.getCartItem().equalsIgnoreCase(itemName));

	

}
