package crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.base.TestBase;
import crm.pages.HomePage;
import crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	//
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String ActualLoginPageTitle = loginPage.validateLoginPageTitle();
		String ExpectedLoginPageTitle = "Free CRM - CRM software for customer relationship "
				+ "management, sales, and support.";
		Assert.assertEquals(ActualLoginPageTitle, ExpectedLoginPageTitle);
	}
	
	@Test(priority=2)
	public void crmLogoImage() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
