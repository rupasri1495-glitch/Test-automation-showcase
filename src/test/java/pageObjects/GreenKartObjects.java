package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GlobalVariables;

public class GreenKartObjects {

	GlobalVariables gVar;
	
	WebDriver driver;
	
	public GreenKartObjects(WebDriver driver, GlobalVariables gVar)	{
		this.driver = driver;
		this.gVar = gVar;
	}

	By search = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	By product = By.xpath("//h4[@class='product-name']");

	public void applicationLaunch() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
	}

	public void search(String item) throws Exception {
		WebElement searchItem = driver.findElement(search);
		searchItem.sendKeys(item);
		Thread.sleep(6000);
	}

	public void itemList() {
		WebElement productList = driver.findElement(product);
		String items = productList.getText();
		gVar.CartItem = items.split("-")[0].trim();
		System.out.println("CartItem  " + gVar.CartItem);
	}
}
