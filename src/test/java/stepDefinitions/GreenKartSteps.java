package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.GreenKartObjects;
import utilities.GlobalVariables;

public class GreenKartSteps {

	GlobalVariables gVar;
	GreenKartObjects greenKart;
	
	public GreenKartSteps(GlobalVariables gVar) {
		this.gVar = gVar;
	}

	@Given("the GreenKart application")
	public void the_green_kart_application() {
		gVar.driver = new ChromeDriver();
		greenKart = new GreenKartObjects(gVar.driver, gVar);
		greenKart.applicationLaunch();
	}

	@When("the item {string} is Searched in searchbar")
	public void the_item_is_searched_in_searchbar(String item) throws Exception {
		greenKart.search(item);
	}

	@When("the item is list in the result")
	public void the_item_is_list_in_the_result() {
		greenKart.itemList();
	}

}
