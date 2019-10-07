package br.com.selenium.java.automation.logic;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;

import br.com.selenium.java.automation.action.UsefulFunctions;
import br.com.selenium.java.automation.page.Page;

public class LogicObject extends Page {

	public void preencheCampoBuscaTelaInicial(String texto) {
		UsefulFunctions.waitElementPresentWithInteval(30, PageObject().getTxtSearchHomePage()).sendKeys(texto.toUpperCase());
	}

	public void clicaBotaoBuscaTelaInicial() {
		UsefulFunctions.waitElementPresentWithInteval(30, PageObject().getBtnSearchHomePage()).click();
		limpaCampoBuscaTelaInicial();
	}

	public void verificaResultadoBusca() {
		WebElement elemento = UsefulFunctions.waitElementPresentWithInteval(30, PageObject().getDivSearchResult());
		System.out.println(">> Texto da <div>" + elemento.getText() + "</div>");
		assertEquals(elemento.getText().contains("1"), true, ">> A busca não devolveu um resultado satisfatório!");
	}

	private void limpaCampoBuscaTelaInicial() {
		UsefulFunctions.waitElementPresentWithInteval(30, PageObject().getTxtSearchHomePage()).clear();
	}
}