package Tests;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Pages.LoginPage;
import Pages.NavigationMenu;
import Utils.BaseTest;


public class LoginTest extends BaseTest {
	
	@Parameters({"user", "pass"})
	@Test
	public void loginTest(String user, String pass) throws InterruptedException {
		//menu.navigateTo(menu.shopLink);		
		//menu.navigateTo(menu.contactLink);
		NavigationMenu menu = new NavigationMenu(driver);		
		menu.navigateTo(menu.loginLink);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginInApp(user, pass);
		Thread.sleep(5000);
		loginpage.logoutFromApp();
		
		
	}
	

	@Test(priority = 1)
	public void invalidloginTest() {
		//menu.navigateTo(menu.shopLink);		
		//menu.navigateTo(menu.contactLink);
		NavigationMenu menu = new NavigationMenu(driver);		
		menu.navigateTo(menu.loginLink);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginInApp("UserGresit", "ParolaGresita");
		
		
	}
}
