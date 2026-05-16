package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.GlobalVariables;

public class TopDealsSteps {

	GlobalVariables gVar;
	String CartItem;
	String DealItem;

	public TopDealsSteps(GlobalVariables gVar)	{
		this.gVar = gVar;
	}

	@Then("navigate to Top Deals screen")
	public void navigate_to_top_deals_screen() throws Exception {
		gVar.driver.findElement(By.linkText("Top Deals")).click();
		Thread.sleep(2000);
		screenNavigation();
	}

	@When("the item {string} is Searched in searchbar in deals page")
	public void the_item_is_searched_in_searchbar_in_deals_page(String item) {
		gVar.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(item);
	}

	@Then("the item is list in the result of deals page")
	public void the_item_is_list_in_the_result_of_deals_page() {
		DealItem = gVar.driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
		System.out.println("DealItem  " + DealItem);
	}

	@When("item {string} is displayed in both screen")
	public void item_is_displayed_in_both_screen(String string) {
		Assert.assertEquals(CartItem, gVar.DealItem);
	}

	@Then("close the browser")
	public void close_the_browser() {
		gVar.driver.quit();
	}

	void screenNavigation() {
		Set<String> wins = gVar.driver.getWindowHandles();
		List<String> win = new ArrayList<>(wins);
		gVar.driver.switchTo().window(win.get(1));
	}
}
