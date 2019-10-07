package br.com.selenium.java.automation.logic;

import static org.testng.Assert.assertEquals;

import br.com.selenium.java.automation.action.UsefulFunctions;
import br.com.selenium.java.automation.page.Page;

public class CartLO extends Page {

	public void clicaBotaoAdicionaItemCarrinho() {
		UsefulFunctions.waitElementPresentWithInteval(20, CartPage().getBtnAddItemCart()).click();
	}

	public void clicaBotaoFechaCompraItemCarrinho() {
		UsefulFunctions.waitElementPresentWithInteval(20, CartPage().getBtnCloseCartItemPurchase()).click();
	}

	public void validaQuantidadeaItemCarrinho(String item) {
		assertEquals(item, UsefulFunctions.waitElementPresentWithInteval(20, CartPage().getSpnItemQuantityCart()).getText());
	}
}