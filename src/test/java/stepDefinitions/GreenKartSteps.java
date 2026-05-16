package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.GreenKartObjects;
import utilities.GlobalVariables;

public class GreenKartSteps {

	String CartItem;
	GlobalVariables gVar;
	
	GreenKartObjects greenKart = new GreenKartObjects();
	
	public GreenKartSteps(GlobalVariables gVar)	{
		this.gVar = gVar;
	}
	
	@Given("the GreenKart application")
	public void the_green_kart_application() {
		gVar.driver = new ChromeDriver();
		gVar.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		gVar.driver.manage().window().maximize();
		
	}

	@When("the item {string} is Searched in searchbar")
	public void the_item_is_searched_in_searchbar(String item) throws Exception {
		WebElement search = gVar.driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']"));
		search.sendKeys(item);
		Thread.sleep(2000);
	}

	@When("the item is list in the result")
	public void the_item_is_list_in_the_result() {
		WebElement product = gVar.driver.findElement(By.xpath("//h4[@class='product-name']"));
		String items = product.getText();
		CartItem = items.split("-")[0].trim();
		System.out.println("CartItem  " + CartItem);
	}

}
