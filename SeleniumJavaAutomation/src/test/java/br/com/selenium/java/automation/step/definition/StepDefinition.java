package br.com.selenium.java.automation.step.definition;

import br.com.selenium.java.automation.logic.LogicObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	private LogicObject logicObject;

	public StepDefinition() {
		logicObject = new LogicObject();
	}

	@Given("^que eu preencho o 'campo busca' da tela inicial \"([^\"]*)\"$")
	public void que_eu_preencho_o_campo_busca_da_tela_inicial(String texto) {
		logicObject.preencheCampoBuscaTelaInicial(texto);
	}

	@When("^eu clico no 'botao de busca'$")
	public void eu_clico_no_botao_de_busca() {
		logicObject.clicaBotaoBuscaTelaInicial();
	}

	@Then("^devera me devolver um resultado na pesquisa$")
	public void devera_me_devolver_um_resultado_na_pesquisa() {
		logicObject.verificaResultadoBusca();
	}
}