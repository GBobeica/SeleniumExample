package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//clasa de page objects
public class NavigationMenu {
	
	WebDriver driver;
	
	//constructor 
	public NavigationMenu(WebDriver driver) {
		this.driver = driver;			
	}
	
	//driver.findElement(By.linkText("BOOKS"))
	
	//locatorul
	public By shopLink = By.linkText("BOOKS");
	//driver.findElement(shopLink);
	public By contactLink = By.linkText("CONTACTS");
	public By loginLink = By.linkText("Login");
	public By singleAuthor = By.linkText("SINGLE AUTHOR");
	public By blogMenu = By.linkText("BLOG");
	public By blogLink = By.linkText("BLOG");
	public By aboutLink = By.linkText("ABOUT");
	public By postFormatsLink = By.linkText("Post Formats");
	
	
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
		
				
	}
	
	public void hoverMenu(By locator) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		
	}


}
