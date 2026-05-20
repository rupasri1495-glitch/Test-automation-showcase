package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TopDealsObject;
import utilities.GlobalVariables;

public class TopDealsSteps {

	TopDealsObject topDeals;
	GlobalVariables gVar;

	public TopDealsSteps(GlobalVariables gVar) {
		this.gVar = gVar;
	}

	@Then("navigate to Top Deals screen")
	public void navigate_to_top_deals_screen() {
		topDeals = new TopDealsObject(gVar.driver, gVar);
		topDeals.topDealslink();
		topDeals.screenNavigation();
	}

	@When("the item {string} is Searched in searchbar in deals page")
	public void the_item_is_searched_in_searchbar_in_deals_page(String item) {
		topDeals.searchItem(item);
	}

	@Then("the item is list in the result of deals page")
	public void the_item_is_list_in_the_result_of_deals_page() {
		topDeals.itemResult();
	}

	@When("item is displayed in both screen")
	public void item_is_displayed_in_both_screen() {
		topDeals.itemMatch();
	}

	@Then("close the browser")
	public void close_the_browser() {
		topDeals.closeBrowser();
	}
}
