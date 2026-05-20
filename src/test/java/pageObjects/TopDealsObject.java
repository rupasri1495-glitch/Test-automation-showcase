package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utilities.GlobalVariables;

public class TopDealsObject {
	
	GlobalVariables gVar;
	public String DealItem;
	public String CartItem;
	
	public TopDealsObject(GlobalVariables gVar)	{
		
		this.gVar = gVar;
	}

	By topDeals = By.linkText("Top Deals");
	By searchItem = By.xpath("//input[@id='search-field']");
	By dealItem = By.xpath("//tbody/tr/td[1]");

	public void topDealslink() {
		gVar.driver.findElement(By.linkText("Top Deals")).click();
	}

	public void searchItem(String item) {
		gVar.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(item);
	}

	public void itemResult() {
		gVar.DealItem = gVar.driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
		System.out.println("DealItem  " + gVar.DealItem);
	}

	public void itemMatch() {
		Assert.assertEquals(gVar.CartItem, gVar.DealItem);
	}

	public void closeBrowser() {
		gVar.driver.quit();
	}
	
	public void screenNavigation() {
		Set<String> wins = gVar.driver.getWindowHandles();
		List<String> win = new ArrayList<>(wins);
		gVar.driver.switchTo().window(win.get(1));
	}

	
}
