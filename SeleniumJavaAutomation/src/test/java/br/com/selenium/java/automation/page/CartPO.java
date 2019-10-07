package br.com.selenium.java.automation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPO {

	@FindBy(how = How.XPATH, using = "//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[1]")
	@CacheLookup
	private WebElement btnAddItemCart;

	@FindBy(how = How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	@CacheLookup
	private WebElement btnCloseCartItemPurchase;

	@FindBy(how = How.XPATH, using = "//*[@id='header']/div[3]/div/div/div[3]/div/a/span[1]")
	@CacheLookup
	private WebElement spnItemQuantityCart;

	public WebElement getBtnAddItemCart() {
		return btnAddItemCart;
	}

	public WebElement getBtnCloseCartItemPurchase() {
		return btnCloseCartItemPurchase;
	}

	public WebElement getSpnItemQuantityCart() {
		return spnItemQuantityCart;
	}
}