package br.com.selenium.java.automation.step.definition;

import br.com.selenium.java.automation.logic.CartLO;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CartSD {

	private CartLO cartLO;

	public CartSD() {
		cartLO = new CartLO();
	}

	@Dado("^que eu clico em um item da loja virtual$")
	public void que_eu_clico_em_um_item_da_loja_virtual() {
		cartLO.clicaBotaoAdicionaItemCarrinho();
	}

	@Quando("^eu clico no botao de fechar a compra$")
	public void eu_clico_no_botao_de_fechar_a_compra() {
		cartLO.clicaBotaoFechaCompraItemCarrinho();
	}

	@Então("^o carrinho devera apresentar \"([^\"]*)\" carregado$")
	public void o_carrinho_devera_apresentar_carregado(String arg1) {
		cartLO.validaQuantidadeaItemCarrinho(arg1);
	}
}