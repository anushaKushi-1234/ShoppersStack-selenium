package genericLibraries;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddressFormPage;
import pomPages.HomePage;
import pomPages.MyAddressPage;
import pomPages.MyProfilePage;
import pomPages.ShopperLoginPage;
import pomPages.cartPage;
import pomPages.headPhonePage;
import pomPages.signUpPage;
import pomPages.welcomePage;

	
	public class BaseClass {
		
		protected PropertiesUtility property;
		protected ExcelUtility excel;
		protected JavaUtility jutil;
		protected webDriverUtility webUtil;
		public WebDriver driver;
		public static WebDriver sdriver;
		
		protected welcomePage welcome;
		protected ShopperLoginPage login;
		protected HomePage home;
		protected signUpPage signUp;
		protected MyProfilePage myProfilePage;
		protected MyAddressPage myPage;
		protected headPhonePage headPhonePage;
		protected cartPage cart;
		protected AddressFormPage address;
		
		//@BeforeSuite
		//@BeforeTest
		
		@BeforeClass
		public void classConfiguration() throws IOException {
			property=new PropertiesUtility();
			excel=new ExcelUtility();
			jutil=new JavaUtility();
			webUtil=new webDriverUtility();
			
			property.propertiesInit(IConstantPath.PROPERTIES_PATH);
			excel.excelInit(IConstantPath.EXCEL_PATH);
		}
		
		@BeforeMethod
		public void methodconfiguration() {
		driver=webUtil.navigateToApp(property.getData("browser"), property.getData("url"), Long.parseLong(property.getData("time")));
		sdriver=driver;
			
			welcome=new welcomePage(driver);
			login=new ShopperLoginPage(driver);
			home=new HomePage(driver);
			signUp=new signUpPage(driver);
			myProfilePage=new MyProfilePage(driver);
			myPage=new MyAddressPage(driver);
			headPhonePage=new headPhonePage(driver);
			cart=new cartPage(driver);
			address=new AddressFormPage(driver);
		}
		
		@AfterMethod
		public void methodTeardown() {
			home.clickProfilebutton();
			  home.clickLogout();
			webUtil.closeallBrowsers();
		}
		@AfterClass
		public void classTeardown() {
			excel.closeExcel();

	}
	//@AfterTest
		//AfterSuite
	
	
}
